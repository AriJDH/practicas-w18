package com.meli.be_java_hisp_w18_g01.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.comparators.LocalDateComparatorDesc;
import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ProductDTO;
import com.meli.be_java_hisp_w18_g01.dtos.ResponseDTO;
import com.meli.be_java_hisp_w18_g01.dtos.SellerDTO;
import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    private long postCount = 1L;

    @Autowired
    LocalDateComparatorDesc localDateComparatorDesc;
    @Autowired
    UserDbService userDbService;

    @Override
    public ResponseDTO addPost(PostDTO postDTO) {
        User user = userDbService.findById(postDTO.getUser_id());
        postCount++;
        Post post;
        ObjectMapper mapper = new ObjectMapper();

        try{
            post = new Post(postCount,
                    user,
                    LocalDate.parse(postDTO.getDate()),
                    mapper.convertValue(postDTO.getProduct(), Product.class),
                    postDTO.getCategory(),
                    postDTO.getPrice()
            );
        }catch(Exception e) {
            throw new BadRequestException("Los parámetros para la creación de la publicación son inválidos");
        }
        user.addPost(post);
        return new ResponseDTO(200, "Operación exitosa");
    }

    @Override
    public List<SellerDTO> getRecentPostsFromFollowed(long userId) {
        User user = userDbService.findById(userId);
        List<User> sellers = user.getFollowed().stream()
                .filter(seller->seller.getPosts().stream().anyMatch(post->post.isRecent()))
                .collect(Collectors.toList());
        ObjectMapper mapper = new ObjectMapper();

        LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        return sellers.stream().map(seller-> new SellerDTO(seller.getUser_id(),
                seller.getPosts().stream().filter(post-> post.isRecent())
                        .sorted((post1, post2)->localDateComparatorDesc.compare(post1.getDate(),post2.getDate()))
                        .map(post->new PostDTO(post.getUser().getUser_id(),post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString(),
                                mapper.convertValue(post.getProduct(), ProductDTO.class)
                                , post.getCategory(), post.getPrice())).collect(Collectors.toList())))
                .collect(Collectors.toList());

    }

}
