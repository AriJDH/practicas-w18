package com.meli.be_java_hisp_w18_g01.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.comparators.LocalDateComparatorAsc;
import com.meli.be_java_hisp_w18_g01.comparators.LocalDateComparatorDesc;
import com.meli.be_java_hisp_w18_g01.dtos.*;
import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w18_g01.mappers.MapperPostToPostDTO;
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
    private long postCount = 0L;

    @Autowired
    MapperPostToPostDTO mapperPostToPostDTO;
    @Autowired
    UserDbService userDbService;

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
        ObjectMapper mapper = new ObjectMapper();

        LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        return sellers.stream().map(seller -> {
                    List<Post> sortedPosts = this.sortPosts(
                            seller.getPosts().stream().filter(
                                    post -> post.isRecent())
                                    .collect(Collectors.toList()), order);

                    return new SellerDTO(seller.getUser_id(),
                            sortedPosts.stream().map(
                                    post -> mapperPostToPostDTO.convertValue(post, PostDTO.class))
                                    .collect(Collectors.toList()));
                })
                .collect(Collectors.toList());

    }

    /* US 0010 Post post isHas_promo */
    @Override
    public void addPostPromo(PostDiscountDTO postDiscountDTO) {
        User user = userDbService.findById(postDiscountDTO.getUser_id());
        postCount++;
        Post post;
        ObjectMapper mapper = new ObjectMapper();

        try {
            System.out.println(postDiscountDTO.getDate());
            post = new Post(
                    postCount,
                    user,
                    LocalDate.parse(postDiscountDTO.getDate(), this.dateFormatter),
                    mapper.convertValue(postDiscountDTO.getProduct(), Product.class),
                    postDiscountDTO.getCategory(),
                    postDiscountDTO.getPrice(),
                    postDiscountDTO.isHas_promo(),
                    postDiscountDTO.getDiscount()
            );
        } catch (Exception e) {
            throw new BadRequestException("Los parámetros para la creación de la publicación son inválidos");
        }
        user.addPost(post);
    }

    /* Ejercicio US 0011 count isHas_promo */
    @Override
    public CountPostDiscountDTO getPostsWithDiscountAtSeller(long userId) {
        User user = userDbService.findById(userId);
        int countPostDiscount = (int) user.getPosts().stream()
                .filter(post -> post.isHas_promo() == true)
                .count();
        return new CountPostDiscountDTO(user.getUser_id(), user.getUser_name(), countPostDiscount);
    }

    /* Ejercicio US 0012 get posts isHas_promo */
    @Override
    public PostDiscountListDTO getDiscountPostAtSeller(long userId) {
        User user = userDbService.findById(userId);

        //List <PostsDiscountDTO> postsDiscountDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        List <PostsDiscountDTO> postsDiscountDTO = user.getPosts().stream()
                .filter(post -> post.isHas_promo() == true)
                .map(p -> new PostsDiscountDTO(
                            user.getUser_id(),
                            p.getPost_id(),
                            dateFormatter.format(p.getDate()).toString(),
                            mapper.convertValue(p.getProduct(), ProductDTO.class),
                            p.getCategory() + "",
                            p.getPrice(),
                            p.isHas_promo(),
                            p.getDiscount()
                        )
                ).collect(Collectors.toList());

        return new PostDiscountListDTO(user.getUser_id(), user.getUser_name(), postsDiscountDTO);
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
