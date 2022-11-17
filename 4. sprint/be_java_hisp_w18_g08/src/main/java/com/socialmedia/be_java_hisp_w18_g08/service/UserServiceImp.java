package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.SellerDTO;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import com.socialmedia.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia.be_java_hisp_w18_g08.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService{

    IUserRepository userRepository;

    public UserServiceImp(UserRepositoryImp repo){
        this.userRepository = repo;
    }

    @Override
    public FollowDtoRes follow(FollowDtoReq followDtoReq) {
        List<String> res = new ArrayList<>();
        FollowDtoRes followDtoRes = new FollowDtoRes();
        res = userRepository.follow(followDtoReq.getUserId(), followDtoReq.getUserIdToFollow());
        if (res == null) {
            throw new NotFoundUserException("There is no user with the ID " + followDtoReq.getUserId() + " or " + followDtoReq.getUserIdToFollow());
        }
        followDtoRes.setStatusCode(200);
        followDtoRes.setMessage(res.get(0) + " is following " + res.get(1));
        return followDtoRes;
    }


    @Override
    public FollowedDTO getFollowed(Integer userId) {
        User user =  userRepository.getUserByID(userId);
        FollowedDTO response = new FollowedDTO();
        response.setUser_id(user.getUser_id());
        response.setUser_name(user.getUser_name());
        response.setFollowed(createSellerDTOList(user.getFollowed()));
        return response;
    }

    private List<SellerDTO> createSellerDTOList(List<Seller> followed) {
        List<SellerDTO> sellers = new ArrayList<>();
        for(Seller s : followed){
            SellerDTO aux = new SellerDTO(s.getUser_id(), s.getUser_name());
            sellers.add(aux);
        }
        return sellers;
    }

    public List<Seller> getFollowedByUserId(Integer userId){
      List<Seller> lista = userRepository.getUserByID(userId).getFollowed();
      if(lista.isEmpty())
          throw new NotFoundUserException("Not found User with id : " + userId );
      return  lista;
    }

}
