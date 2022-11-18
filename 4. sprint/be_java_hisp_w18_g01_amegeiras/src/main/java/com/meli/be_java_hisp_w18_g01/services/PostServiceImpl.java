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
import com.meli.be_java_hisp_w18_g01.mappers.MapperPostToPostDiscDTO;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private long postCount = 1L;

    @Autowired
    MapperPostToPostDTO mapperPostToPostDTO;

    @Autowired
    MapperPostToPostDiscDTO mapperPostToPostDiscDTO;
    @Autowired
    UserDbService userDbService;

    @Override
    public void addPost(PostDTO postDTO) {
        User user = userDbService.findById(postDTO.getUser_id());
        postCount++;
        Post post;
        ObjectMapper mapper = new ObjectMapper();

        try {
            post = new Post(postCount,
                    user,
                    LocalDate.parse(postDTO.getDate()),
                    mapper.convertValue(postDTO.getProduct(), Product.class),
                    postDTO.getCategory(),
                    postDTO.getPrice()
            );
        } catch (Exception e) {
            throw new BadRequestException("Los parámetros para la creación de la publicación son inválidos");
        }
        user.addPost(post);
    }

    @Override
    public void addPostDisc(PostDiscDTO postDiscDTO) {
        User user = userDbService.findById(postDiscDTO.getUser_id());
        postCount++;
        Post post;
        ObjectMapper mapper = new ObjectMapper();

        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            post = new Post(postCount,
                    user,
                    LocalDate.parse(postDiscDTO.getDate(), dateFormatter),
                    mapper.convertValue(postDiscDTO.getProduct(), Product.class),
                    postDiscDTO.getCategory(),
                    postDiscDTO.getPrice()
            );
            if (postDiscDTO.isHas_promo()) {
                post.setHasPromo(postDiscDTO.isHas_promo());
                post.setDiscount(postDiscDTO.getDiscount());
            }
        } catch (Exception e) {
            throw new BadRequestException("Los parámetros para la creación de la publicación son inválidos");
        }
        user.addPost(post);
    }

    @Override
    public SellerPostDiscountCountDTO getPromoPostCount(long userId) {
        User user = userDbService.findById(userId);
        return new SellerPostDiscountCountDTO(user.getUser_id(), user.getUser_name(), user.getPostDiscountCount());
    }

    @Override
    public SellerPostsDiscountInfoDTO getPromoPosts(long userId) {
        User user = userDbService.findById(userId);

        LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        ObjectMapper mapper = new ObjectMapper();

        List<Post> promoPost = user.getPostDiscount();


        return new SellerPostsDiscountInfoDTO(user.getUser_id(),user.getUser_name(),promoPost.stream()
                .map(post -> mapperPostToPostDiscDTO.convertValue(post, PostDiscDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public List<SellerDTO> getRecentPostsFromFollowed(long userId, String order) {
        User user = userDbService.findById(userId);
        List<User> sellers = user.getFollowed().stream()
                .filter(seller -> seller.getPosts().stream().anyMatch(Post::isRecent))
                .collect(Collectors.toList());
        ObjectMapper mapper = new ObjectMapper();

        LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        return sellers.stream().map(seller -> {
                    List<Post> sortedPosts = this.sortPosts(seller.getPosts().stream().filter(Post::isRecent).collect(Collectors.toList()), order);

                    return new SellerDTO(seller.getUser_id(),
                            sortedPosts.stream().map(post -> mapperPostToPostDTO.convertValue(post, PostDTO.class))
                                    .collect(Collectors.toList()));
                })
                .collect(Collectors.toList());

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
