package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.dto.request.PromoPostDTORequest;
import com.sprint1.be_java_hisp_w18_g03.dto.response.*;
import com.sprint1.be_java_hisp_w18_g03.repository.ICategoryRepository;
import com.sprint1.be_java_hisp_w18_g03.repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.Category;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.entity.Product;
import com.sprint1.be_java_hisp_w18_g03.exception.CreationException;
import com.sprint1.be_java_hisp_w18_g03.exception.NoFoundException;
import com.sprint1.be_java_hisp_w18_g03.exception.ParamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public ResponseDTO createPost(RequestPostDTO request) {
        User user = iUserRepository.findById(request.getUserId());
        if (user == null) throw new NoFoundException("The user hasn't being found");
        Integer sizeList = iPostRepository.getPostsSizeList() + 1;
        Category category = iCategoryRepository.findCategoryById(request.getCategory());
        if (category == null) throw new NoFoundException("The category hasn't being found");
        Product product = new Product(
                request.getProduct().getProductId(),
                request.getProduct().getProductName(),
                request.getProduct().getType(),
                request.getProduct().getBrand(),
                request.getProduct().getColor(),
                request.getProduct().getNotes(),
                category,
                request.getPrice()
        );

        Post newPost = new Post(
                sizeList,
                user,
                request.getDate(),
                product,
                false,
                0f
        );
        boolean responseAdd = iPostRepository.addPost(newPost);
        if (responseAdd == false) throw new CreationException("Error adding the post");
        return new ResponseDTO("Post added successfully", 200);
    }

    @Override
    public ResponseDTO createPromoPost(PromoPostDTORequest request) {
        User user = iUserRepository.findById(request.getUserId());
        if (user == null) {
            throw new NoFoundException("User not found");
        }

        Category category = iCategoryRepository.findCategoryById(request.getCategory());
        if (category == null) {
            throw new NoFoundException("Category not found");
        }

        if (request.getDiscount() > 0 || request.getDiscount() < 1|| request.getHasPromo()){
            throw new ParamException("Invalid params discount");
        }

            Integer postId = iPostRepository.getPostsSizeList() + 1;

        Product product = new Product(
                request.getProduct().getProductId(),
                request.getProduct().getProductName(),
                request.getProduct().getType(),
                request.getProduct().getBrand(),
                request.getProduct().getColor(),
                request.getProduct().getNotes(),
                category,
                request.getPrice()
        );


        Post newPost = new Post(
                postId,
                user,
                request.getDate(),
                product,
                request.getHasPromo(),
                request.getDiscount()
        );

        boolean responseAdd = iPostRepository.addPost(newPost);

        if (!responseAdd) {
            throw new CreationException("Error creating post");
        }

        return new ResponseDTO("Post added succesfully", 200);
    }

    @Override
    public SellersPostDTO getPostSellers(Integer userId, String order) {

        User user = iUserRepository.findById(userId);

        if (user == null) {
            throw new NoFoundException("The user hasn't being found");
        }

        if (user.getListFollowed().isEmpty()) {
            throw new NoFoundException("The people followed hasn't being found");
        }

        List<Post> postSell = new ArrayList<>();

        for (User userFollowed : user.getListFollowed()) {
            List<Post> postUser = iPostRepository.findByUser(userFollowed.getUserId());
            postSell.addAll(postUser);
        }

        //Obtener post que este entre las dos semanas y la actual
        LocalDate fechaSin2Semana = LocalDate.now().minusDays(14);

        List<Post> recentPost = postSell.stream()
                .filter(x -> x.getDate().isAfter(fechaSin2Semana))
                .collect(Collectors.toList());

        if (recentPost.isEmpty()) {
            throw new NoFoundException("The posts hasn't being found");
        }

        List<ResponsePostDTO> responsePostDTOs = new ArrayList<>();

        for (Post post : recentPost) {

            ResponsePostDTO responsePostDTO = new ResponsePostDTO();
            responsePostDTO.setUserId(post.getUser().getUserId());
            responsePostDTO.setPostId(post.getPostId());
            responsePostDTO.setDate(post.getDate());
            responsePostDTO.setCategory(post.getProducto().getCategory().getCategoryId());
            responsePostDTO.setPrice(post.getProducto().getPrice());

            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProductId(post.getProducto().getProductId());
            productResponseDTO.setProductName(post.getProducto().getProductName());
            productResponseDTO.setType(post.getProducto().getType());
            productResponseDTO.setBrand(post.getProducto().getBrand());
            productResponseDTO.setColor(post.getProducto().getColor());
            productResponseDTO.setNotes(post.getProducto().getNotes());

            responsePostDTO.setProduct(productResponseDTO);

            responsePostDTOs.add(responsePostDTO);
        }

        if (order != null) {
            switch (order) {
                case "date_asc":
                    responsePostDTOs = responsePostDTOs.stream().sorted((x, y) -> x.getDate().compareTo(y.getDate())).collect(Collectors.toList());
                    break;
                case "date_desc":
                    responsePostDTOs = responsePostDTOs.stream().sorted((x, y) -> y.getDate().compareTo(x.getDate())).collect(Collectors.toList());
                    break;
                default:
                    throw new ParamException("Ther order variable does not allow the value:" + order);
            }
        }

        return new SellersPostDTO(user.getUserId(), responsePostDTOs);
    }

    @Override
    public PromoPostCountDTO getPostPromoCount(Integer userId) {
        User user = iUserRepository.findById(userId);

        if (user == null) {
            throw new NoFoundException("User Not Found");
        }

        List<Post> posts = iPostRepository.findPromoPostsByUser(userId);


        return new PromoPostCountDTO(user.getUserId(), user.getUserName(), posts.size());
    }

    @Override
    public List<PromoPostDTORes> getPromoPostFollowed(Integer userId) {
        User user = iUserRepository.findById(userId);
        if (user == null) {
            throw new NoFoundException("User not found");
        }

        if (user.getListFollowed().size() == 0) {
            throw new NoFoundException("Followeds not found");
        }

        List<User> usersFollowed = user.getListFollowed();
        List<Post> postsFollowed = new ArrayList<>();

        for (User userFollowed : usersFollowed) {
            postsFollowed.addAll(iPostRepository.findPromoPostsByUser(userFollowed.getUserId()));
        }

        return postsFollowed.stream()
                .map(post ->
                        new PromoPostDTORes(
                                userId,
                                post.getDate(),
                                new ProductResponseDTO(
                                        post.getProducto().getProductId(),
                                        post.getProducto().getProductName(),
                                        post.getProducto().getBrand(),
                                        post.getProducto().getColor(),
                                        post.getProducto().getNotes(),
                                        post.getProducto().getType()
                                ),
                                post.getProducto().getCategory().getCategoryId(),
                                post.getProducto().getPrice(),
                                post.getPostId(),
                                post.isHasPromo(),
                                post.getDiscount()

                        )
                ).collect(Collectors.toList());
    }
}
