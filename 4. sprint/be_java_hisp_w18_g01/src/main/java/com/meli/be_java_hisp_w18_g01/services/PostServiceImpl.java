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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private long postCount = 0;
    @Autowired
    private UserDbService userDbService;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public PostPromoCounterDTO getPromoPostCountForSeller(long user_id){
        User user = userDbService.findById((user_id));
        int postPromoCount = user.getPosts().stream().filter(p -> p.isPromotion() == true).
                collect(Collectors.toList()).
                size();
        return new PostPromoCounterDTO(user_id, user.getUser_name(), postPromoCount);

    }


    //Defino el metodo addPostpromo, el cual recibe por parametro un PostPromoDTO
   @Override
   public void addPostPromo(PostPromoDTO postPromoDTO){
       User user = userDbService.findById(postPromoDTO.getUser_id());
       postCount++;
       Post post;
       ObjectMapper mapper = new ObjectMapper();

       try {
           post = new Post(postCount,
                   user,
                   LocalDate.parse(postPromoDTO.getDate(),dateFormatter),
                    mapper.convertValue(postPromoDTO.getProduct(), Product.class),
                    postPromoDTO.getCategory(),
                    postPromoDTO.getPrice(),
                    postPromoDTO.isHas_promo(),
                    postPromoDTO.getDiscount()
           );

       }
       catch (Exception e) {
           postCount--;
           throw new BadRequestException("No se creo el Post en promoción ya que los parametros ingresados son invalidos");
       }
        user.addPost(post);
   }



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
    public List<SellerDTO> getRecentPostsFromFollowed(long userId, String order) {
        User user = userDbService.findById(userId);
        List<User> sellers = user.getFollowed().stream()
                .filter(seller -> seller.getPosts().stream().anyMatch(post -> post.isRecent()))
                .collect(Collectors.toList());

        LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        MapperPostToPostDTO mapperPostToPostDTO = new MapperPostToPostDTO();
        return sellers.stream().map(seller -> {
                    List<Post> sortedPosts = this.sortPosts(seller.getPosts().stream().filter(post -> post.isRecent()).collect(Collectors.toList()), order);

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
