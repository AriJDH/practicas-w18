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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private long postCount = 0L;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Autowired
    MapperPostToPostDTO mapperPostToPostDTO;
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
    public void addPostPromo(PostPromoDTO postPromoDTO) {
        if (!postPromoDTO.isHas_promo()){
            throw new BadRequestException("Ocurrió un problema al crear la publicación. La promoción no está otorgada.");
        } else if(postPromoDTO.getDiscount() <= 0 || postPromoDTO.getDiscount() > 1){
            throw new BadRequestException("Ocurrió un problema al crear la publicación. El valor del descuento no corresponde.");
        }

        User user = userDbService.findById(postPromoDTO.getUser_id());
        postCount++;
        Post post;
        ObjectMapper mapper = new ObjectMapper();

        try {
            post = new Post(postCount,
                    user,
                    LocalDate.parse(postPromoDTO.getDate(), dateFormatter),
                    mapper.convertValue(postPromoDTO.getProduct(), Product.class),
                    postPromoDTO.getCategory(),
                    postPromoDTO.getPrice(),
                    postPromoDTO.isHas_promo(),
                    postPromoDTO.getDiscount()
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
                    List<Post> sortedPosts = this.sortPosts(seller.getPosts().stream().filter(post -> post.isRecent()).collect(Collectors.toList()), order);

                    return new SellerDTO(seller.getUser_id(),
                            sortedPosts.stream().map(post -> mapperPostToPostDTO.convertValue(post, PostDTO.class))
                                    .collect(Collectors.toList()));
                })
                .collect(Collectors.toList());

    }

    @Override
    public PostPromoCountDTO getPostPromoCount(long userId) {
        User user = userDbService.findById(userId);
        List<Post> post = user.getPosts().stream().filter(p -> p.isHas_promo() == true).collect(Collectors.toList());

        return new PostPromoCountDTO(user.getUser_id(), user.getUser_name(), post.size());
    }

    @Override
    public SellerPostPromoDTO getSellerPostPromo(long userId) {
        User user = userDbService.findById(userId);
        ObjectMapper mapper = new ObjectMapper();
        List<Post> post = user.getPosts().stream().filter(p -> p.isHas_promo() == true).collect(Collectors.toList());
        List<PostPromoIdDTO> postDto = post.stream().map(p ->
                new PostPromoIdDTO(p.getUser().getUser_id(),
                        p.getPost_id(),
                        p.getDate().format(dateFormatter),
                        mapper.convertValue(p.getProduct(), ProductDTO.class),
                        p.getCategory(),
                        p.getPrice(),
                        p.isHas_promo(),
                        p.getDiscount()
        )).collect(Collectors.toList());

        return new SellerPostPromoDTO(user.getUser_id(), user.getUser_name(), postDto);
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
