package com.meli.be_java_hisp_w18_g01.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.comparators.LocalDateComparatorAsc;
import com.meli.be_java_hisp_w18_g01.comparators.LocalDateComparatorDesc;
import com.meli.be_java_hisp_w18_g01.comparators.StringComparatorAsc;
import com.meli.be_java_hisp_w18_g01.comparators.StringComparatorDesc;
import com.meli.be_java_hisp_w18_g01.dtos.*;
import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w18_g01.mappers.MapperPostToPostDTO;
import com.meli.be_java_hisp_w18_g01.mappers.MapperPostToPromoPostDTO;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private long postCount = 3L;
    @Autowired
    private UserDbService userDbService;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public void addPost(PostDTO postDTO) {
        User user = userDbService.findById(postDTO.getUser_id());
        postCount++;
        Post post;
        ObjectMapper mapper = new ObjectMapper();

        try {
            post = new Post(postCount,
                    user,
                    LocalDate.parse(postDTO.getDate(),dateFormatter),
                    mapper.convertValue(postDTO.getProduct(), Product.class),
                    postDTO.getCategory(),
                    postDTO.getPrice()
            );
        } catch (Exception e) {
            postCount--;
            throw new BadRequestException("Los parámetros para la creación de la publicación son inválidos");
        }
        user.addPost(post);
    }

    @Override
    public void addPromoPost(PromoPostDTO promoPostDTO) {
        User user = userDbService.findById(promoPostDTO.getUser_id());
        Post post;
        ObjectMapper mapper = new ObjectMapper();
        try{
            post = new Post(postCount, user,
                    LocalDate.parse(promoPostDTO.getDate(),dateFormatter), mapper.convertValue(promoPostDTO.getProduct(), Product.class),
                    promoPostDTO.getCategory(), promoPostDTO.getPrice(),true,promoPostDTO.getDiscount());
        }catch (Exception e){
            postCount--;
            System.out.println(e.getMessage());
            throw new BadRequestException("Los parámetros para la creación de la publicación son inválidos");
        }
        user.addPost(post);
    }

    @Override
    public List<SellerDTO> getRecentPostsFromFollowed(long userId, String order) {
        User user = userDbService.findById(userId);
        List<User> sellers = user.getFollowed().stream()
                .filter(seller -> seller.getPosts().stream().anyMatch(post -> post.isRecent()))
                .collect(Collectors.toList());

        MapperPostToPostDTO mapperPostToPostDTO = new MapperPostToPostDTO();
        return sellers.stream().map(seller -> {
                    List<Post> sortedPosts = this.sortPosts(seller.getPosts().stream().filter(post -> post.isRecent()).collect(Collectors.toList()), order);

                    return new SellerDTO(seller.getUser_id(),
                            sortedPosts.stream().map(post -> mapperPostToPostDTO.convertValue(post, PostDTO.class))
                                    .collect(Collectors.toList()));
                })
                .collect(Collectors.toList());

    }

    @Override
    public SellerPromoPostCountDTO getSellerPromoPostCount(long userId) {
        User user = userDbService.findById(userId);
        return new SellerPromoPostCountDTO(userId, user.getUser_name(), user.getPromoPosts().size());
    }

    @Override
    public SellerPromoPostInfoDTO getSellerPromoPostInfo(long userId) {
        User user = userDbService.findById(userId);
        MapperPostToPromoPostDTO mapperPostToPromoPostDTO = new MapperPostToPromoPostDTO();
        return new SellerPromoPostInfoDTO(user.getUser_id(), user.getUser_name(),
                user.getPromoPosts().stream().map(post->mapperPostToPromoPostDTO.convertValue(post, PromoPostDTO.class)).collect(Collectors.toList()));
    }

    public List<Post> sortPosts(List<Post> posts, String order) {
        Comparator comp;
        if (order == null)
            return posts;
        switch (order) {
            case "date_asc":
                comp = new LocalDateComparatorAsc();
                break;
            case "date_desc":
                comp = new LocalDateComparatorDesc();
                break;
            default:
                throw new BadRequestException("El parámetro " + order + " es inválido.");
        }
        posts.sort((p1, p2) -> comp.compare(p1.getDate(), p2.getDate()));
        return posts;
    }
}
