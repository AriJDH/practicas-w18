package com.example.BE_java_hisp_w18_g04.service;


import com.example.BE_java_hisp_w18_g04.dto.request.PostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.request.PromoPostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.respose.*;
import com.example.BE_java_hisp_w18_g04.entity.Post;
import com.example.BE_java_hisp_w18_g04.entity.PromoPost;
import com.example.BE_java_hisp_w18_g04.entity.UserBuyer;
import com.example.BE_java_hisp_w18_g04.entity.UserSeller;
import com.example.BE_java_hisp_w18_g04.exception.BadRequestException;
import com.example.BE_java_hisp_w18_g04.repository.IPostRepository;
import com.example.BE_java_hisp_w18_g04.repository.IUserSellerRepository;
import com.example.BE_java_hisp_w18_g04.util.Mapper;
import com.example.BE_java_hisp_w18_g04.util.Sorter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSellerServiceImp implements IUserSellerService{
    private final IUserSellerRepository sellerRepository;
    private final IPostRepository postRepository;

    public UserSellerServiceImp(IUserSellerRepository sellerRepository, IPostRepository postRepository) { //Inyectamos los repositorios
        this.sellerRepository = sellerRepository;
        this.postRepository = postRepository;
    }


    @Override
    public FollowerCountDTORes followersCount(Integer userId) {
        if(validateSeller(userId)) {    //Validamos que el usuario exista
            UserSeller seller = sellerRepository.findById(userId);
            return new FollowerCountDTORes(seller.getUser_id(), seller.getUser_name(), seller.getFollowers().size());   //Encontramos y retornamos el DTO
        } else {
            throw new BadRequestException("The user_id not exist"); // En caso de que no exista, lanzamos excepcion
        }
    }
    private Boolean validateSeller(Integer id){
        Boolean valid = false;
        List<UserSeller> sellers = sellerRepository.findAll();
        for(UserSeller seller: sellers){
            if(seller.getUser_id().equals(id)){
                valid = true;
            }
        }
        return valid;           //Buscamos al usuario en nuestra 'Base de datos' para validar su existencia
    }
    @Override
    public FollowerListDTORes getFollowers(Integer userId, String order) {
        if(validateSeller(userId)) {
            UserSeller seller = sellerRepository.findById(userId);  //Obtenemos al vendedor
            List<UserBuyer> buyers = seller.getFollowers(); //Obtenemos los seguidores del vendedor
            List<UserDTORes> userDTOResList = buyers.stream().map(buyer -> new UserDTORes(buyer)).collect(Collectors.toList());   // Creamos el DTO
            if (!order.equals("invalid"))
                Sorter.sortedByName(userDTOResList, order);  //Ordenamos segun el parametro recibido
            else
                throw new BadRequestException("Enter 'name_asc' for ascending alphabetical ordering or 'name_desc' for descending ordering.");
            //Excepcion en caso de recibir un parametro incorrecto
            return new FollowerListDTORes(seller.getUser_id(), seller.getUser_name(), userDTOResList); //Retornamos el DTO ordenado
        } else {
            throw new BadRequestException("The user_id not exist");
        }
    }

    @Override
    public void publishPost(PostDTOReq postDTOReq) {        //Con ayuda de ObjectMapper convertimos el DTO en una entidad Post y la agregamos a la 'Base de datos'
        Post post= Mapper.createObjectMapper().convertValue(postDTOReq, Post.class);
        postRepository.createPost(post);
        UserSeller seller = sellerRepository.findById(postDTOReq.getUser_id());
            seller.getPosts().add(post);
    }

    @Override
    public void publishPromoPost(PromoPostDTOReq promoPostDTOReq) {

        PromoPost post = Mapper.createObjectMapper().convertValue(promoPostDTOReq, PromoPost.class);
        postRepository.createPromoPost(post);
    }

public PromoPostCountDTORes promoPostCount(Integer user_id){ //Me quede sin tiempo y me puse a comentar u.u


        return null;
}


}
