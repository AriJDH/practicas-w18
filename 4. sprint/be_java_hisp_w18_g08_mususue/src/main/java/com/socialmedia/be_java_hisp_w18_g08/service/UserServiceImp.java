package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.response.*;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import com.socialmedia.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia.be_java_hisp_w18_g08.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.UserRepositoryImp;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImp(UserRepositoryImp repo) {
        this.userRepository = repo;
    }

    @Override
    public FollowDtoRes follow(FollowDtoReq followDtoReq) {
        String res;
        FollowDtoRes followDtoRes = new FollowDtoRes();
        res = userRepository.follow(followDtoReq.getUserId(), followDtoReq.getUserIdToFollow());
        if (res == null) {
            throw new NotFoundUserException("Something was wrong");
        }
        followDtoRes.setStatusCode(200);
        followDtoRes.setMessage(res);
        return followDtoRes;
    }

    @Override
    public FollowedDto getFollowed(Integer userId, String order) {
        User user = userRepository.getUserByID(userId);
        if(user == null)
            throw new NotFoundUserException("There is no user with the ID " + userId);
        FollowedDto response = new FollowedDto();
        response.setUser_id(user.getUser_id());
        response.setUser_name(user.getUser_name());
        response.setFollowed(createUserDTOList(user.getFollowed(), order));
        return response;
    }

    private List<UserDto> createUserDTOList(List<Seller> followed, String order) {
        List<UserDto> sellers = new ArrayList<>();
        for (Seller s : followed) {
            UserDto aux = new UserDto(s.getUser_id(), s.getUser_name());
            sellers.add(aux);
        }
        if(order != null)
            changeOrder(sellers, order);
        return sellers;
    }

    private void changeOrder(List<UserDto> list, String order) {
        Comparator<UserDto> compareByName =
                Comparator.comparing(UserDto::getUser_name);
        switch (order){
            case "name_asc":
                Collections.sort(list, compareByName);
                break;
            case "name_desc":
                Collections.sort(list, compareByName.reversed());
                break;
        }
    }

    @Override
    public SellerFollowersCountDto findAllFollowersQuantity(Integer id) {
        Seller seller = userRepository.findSellerById(id);

        if(seller == null){
            throw new NotFoundUserException("Not found User with id " + id );
        }
        int quantity = seller.getFollowers().size();
        return new SellerFollowersCountDto(seller.getUser_id(),seller.getUser_name(), quantity);
    }

    @Override
    public UserListDto findUserListBySeller(Integer id, String order) {
        Seller seller = userRepository.findSellerById(id);
        if (seller == null)
            throw new NotFoundUserException("Not found User with id " + id );
        List<UserDto> usersDTO = new ArrayList<>();
        for (User s : seller.getFollowers()) {
            UserDto userDto = new UserDto();
            userDto.setUser_id(s.getUser_id());
            userDto.setUser_name(s.getUser_name());
            usersDTO.add(userDto);
        }
        if(order != null)
            changeOrder(usersDTO, order);
        UserListDto userListDTO = new UserListDto(seller.getUser_id(), seller.getUser_name(), usersDTO);
        return userListDTO;
    }

    public List<Seller> getFollowedByUserId(Integer userId) {
        User user = userRepository.getUserByID(userId);
        if(user == null)
            throw new NotFoundUserException("Not found User with id : " + userId);
        List<Seller> lista = user.getFollowed();
        if (lista.isEmpty())
            throw new NotFoundUserException("Not found followed");
        return lista;
    }

    @Override
    public String unFollow(Integer userId, Integer userIdToUnfollow) {
        String message = userRepository.unFollow(userId,userIdToUnfollow);
        if(message == null)
            throw new NotFoundUserException("User or Seller not Found");
        return message;
    }

    @Override
    public SellerDtoRes getSellerById(Integer userId) {
        Seller seller = userRepository.getSellerById(userId);
        if(seller == null)
            throw new NotFoundUserException("Seller not Found");
        SellerDtoRes sellerDtoRes = new SellerDtoRes(seller.getUser_id(), seller.getUser_name(), seller.getFollowed(), seller.getPosts(), seller.getFollowers());
        return sellerDtoRes;
    }


}
