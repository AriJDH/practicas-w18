package com.example.BE_java_hisp_w18_g04.service;


import com.example.BE_java_hisp_w18_g04.dto.respose.FollowedListDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PostDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PostFollowedByDateDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.UserDTORes;
import com.example.BE_java_hisp_w18_g04.entity.Post;
import com.example.BE_java_hisp_w18_g04.entity.UserBuyer;
import com.example.BE_java_hisp_w18_g04.entity.UserSeller;
import com.example.BE_java_hisp_w18_g04.exception.BadRequestException;
import com.example.BE_java_hisp_w18_g04.repository.IUserBuyerRepository;
import com.example.BE_java_hisp_w18_g04.repository.IUserSellerRepository;
import com.example.BE_java_hisp_w18_g04.util.Sorter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserBuyerServiceImp implements IUserBuyerService{
    private final IUserBuyerRepository userBuyerRepository;
    private final IUserSellerRepository userSellerRepository;

    public UserBuyerServiceImp(IUserBuyerRepository userBuyerRepository, IUserSellerRepository userSellerRepository) {
        this.userBuyerRepository = userBuyerRepository;
        this.userSellerRepository = userSellerRepository;
    }

    private Boolean validateBuyer(Integer id){ //Metodos auxiliares para ahorrar codigo
        Boolean valid = false;
        List<UserBuyer> buyers = userBuyerRepository.findAll();
        for(UserBuyer buyer: buyers){
            if(buyer.getUser_id().equals(id)){
                valid = true;
            }
        }
        return valid;
    }
    private Boolean validateSeller(Integer id){ //Metodos auxiliares para ahorrar codigo
        Boolean valid = false;
        List<UserSeller> sellers = userSellerRepository.findAll();
        for(UserSeller seller: sellers){
            if(seller.getUser_id().equals(id)){
                valid = true;
            }
        }
        return valid;
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
        //Agregamos a un comprador a la lista de seguidos de un vendedor, validamos que no se pueda seguir mas de una (1) vez
            if(validateBuyer(userId) && validateSeller(userIdToFollow)) {
                UserBuyer buyer = userBuyerRepository.findById(userId);
                UserSeller seller = userSellerRepository.findById(userIdToFollow);
                if (!(buyer.getFollowed().contains(seller)) && !(seller.getFollowers().contains(buyer))) {
                    buyer.getFollowed().add(seller);
                    seller.getFollowers().add(buyer);
                } else {
                    throw new BadRequestException("The user " + userIdToFollow + " is already in your follow list");
                }
            } else{
                throw new BadRequestException("The user_id not exist");
            }
        }


    @Override
    public FollowedListDTORes getFollowed(Integer userId, String order) {
        //Obtenemos a los vendedor que sigue un comprador, tambien ordenamos segun {order}
        if(validateBuyer(userId)) {
            UserBuyer buyer = userBuyerRepository.findById(userId);
            List<UserSeller> sellers = buyer.getFollowed();
            List<UserDTORes> userDTOResList = sellers.stream().map(e -> new UserDTORes(e)).collect(Collectors.toList());
            if (!order.equals("invalid"))
                Sorter.sortedByName(userDTOResList, order);
            else
                throw new BadRequestException("Enter 'name_asc' for ascending alphabetical ordering or 'name_desc' for descending ordering.");
            return new FollowedListDTORes(buyer.getUser_id(), buyer.getUser_name(), userDTOResList);
        } else {
            throw new BadRequestException("The user_id not exist");
        }
    }

    @Override
    public PostFollowedByDateDTORes getLastPosts(Integer userId, String order) {
        //Obtenemos los posts de cuyos vendedor un usuario siga, filtrando que no hayan pasado mas de 2 semanas y ordenandolo segun {order}
        if(validateBuyer(userId)) {
            UserBuyer buyer = userBuyerRepository.findById(userId);
            List<UserSeller> followed = buyer.getFollowed();
            List<PostDTORes> postsFollowed = new ArrayList<>();
            getPostListSeller(followed, postsFollowed);

            List<PostDTORes> filterList = filterPostByDate(postsFollowed);

            if (!order.equals("invalid"))
                Sorter.sortByDate(filterList, order);
            return new PostFollowedByDateDTORes(buyer.getUser_id(), filterList);
        } else {
            throw new BadRequestException("The user_id not exist");
        }
    }

    private List<PostDTORes> filterPostByDate(List<PostDTORes> postDTOResList){
        return postDTOResList.stream().
                //Conseguimos la fecha del postDTO y le preguntamos si ya paso 2 semanas
                filter(postDTORes->postDTORes.getDate().isAfter(LocalDate.now().minusWeeks(2)))

                .collect(Collectors.toList());

    }
    private void getPostListSeller(List<UserSeller> followed, List<PostDTORes> postsFollowed){
        for (UserSeller seller: followed) {
            for ( Post post: seller.getPosts()) {
                postsFollowed.add(new PostDTORes(seller.getUser_id(),post));
            }
        }
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {
        if(validateBuyer(userId) && validateSeller(userIdToUnfollow)) {     //Validamos que existan los usuarios que se comunicaran
        UserBuyer buyer = userBuyerRepository.findById(userId); //Encontramos al comprador
        UserSeller seller = userSellerRepository.findById(userIdToUnfollow); //Encontramos al vendedor
        if (buyer.getFollowed().contains(seller) && (seller.getFollowers().contains(buyer))) {
            buyer.getFollowed().remove(seller);
            seller.getFollowers().remove(buyer);    // Si en sus respectivas listas de seguidos y seguidores existen estos usuarios, seran removidos de ahi
        } else {
            throw new BadRequestException("The user "+userIdToUnfollow+" is not in your following list");
        }       //De no ser encontrados tiraran alguna de estas dos excepciones segun el caso
    } else {
            throw new BadRequestException("The user_id not exist");
        }}
}
