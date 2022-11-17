package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.ICategoryRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.exception.NoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        var user = iUserRepository.findById(request.getUserId());
        if (user==null) return null;
        Integer sizeList = iPostRepository.getPostsSizeList() + 1;
        var category = iCategoryRepository.findCategoryById(request.getCategory());
        if (category == null) return null;;
        Post newPost = new Post(
                sizeList,
                request.getProduct().getProductName(),
                request.getProduct().getType(),
                request.getProduct().getBrand(),
                request.getProduct().getColor(),
                request.getProduct().getNotes(),
                category,
                request.getPrice(),
                request.getProduct().getHasPromo(),
                request.getProduct().getDiscount()
        );
        boolean responseAdd = iPostRepository.addPost(newPost);
        if (responseAdd == false) return null;
        return new ResponseDTO("Post agregado correctamente", 200);
    }

    @Override
    public SellersPostDTO getPostSellers(Integer userId) {

        User user = iUserRepository.findById(userId);

        if (user == null){
            throw new NoFoundException("The user hasn't being found");
        }

        if (user.getListFollowed().isEmpty()) {
            throw new NoFoundException("The people followed hasn't being found");
        }

        List<Post> postSell = new ArrayList<>();

        for (User userFollowed : user.getListFollowed()) {

        }
        List<Post> postUser = iPostRepository.findByUser(userId);

        if (postUser.isEmpty()) {
            throw new NoFoundException("The posts hasn't being found");
        }

        //Obtener post que este entre las dos semanas y la actual
        LocalDate fechaSistema = LocalDate.now();



        return null;
    }
}
