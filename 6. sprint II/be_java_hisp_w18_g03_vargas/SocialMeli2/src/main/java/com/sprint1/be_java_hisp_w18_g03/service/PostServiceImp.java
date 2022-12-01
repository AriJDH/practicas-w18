package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.ICategoryRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ProductResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponsePostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;
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
        var product = new Product(
                request.getProduct().getProductId(),
                request.getProduct().getProductName(),
                request.getProduct().getType(),
                request.getProduct().getBrand(),
                request.getProduct().getColor(),
                request.getProduct().getNotes(),
                category,
                request.getPrice(),
                request.getHasPromo(),
                request.getDiscount()
        );
        Post newPost = new Post(
                sizeList,
                user,
                request.getDate(),
                product
        );
        boolean responseAdd = iPostRepository.addPost(newPost);
        if (responseAdd == false) throw new CreationException("Error adding the post");
        return new ResponseDTO("Post added successfully", 200);
    }

    @Override
    public SellersPostDTO getPostSellers(Integer userId, String order) {

        User user = iUserRepository.findById(userId);

        if (user == null) {
            throw new NoFoundException("The user hasn't being found");
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
        responsePostDTOs = getOrderedPostsByDate(order,responsePostDTOs);
        return new SellersPostDTO(user.getUserId(), responsePostDTOs);
    }

    public List<ResponsePostDTO> getOrderedPostsByDate(String order,List<ResponsePostDTO> responsePostDTOs){
        if (order == null) {return responsePostDTOs;}

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
        return responsePostDTOs;

    }

}
