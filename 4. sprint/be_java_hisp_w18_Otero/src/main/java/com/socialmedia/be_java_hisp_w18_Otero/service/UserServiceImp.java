package com.socialmedia.be_java_hisp_w18_Otero.service;

import com.socialmedia.be_java_hisp_w18_Otero.dto.response.UserDto;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.UserListDto;
import com.socialmedia.be_java_hisp_w18_Otero.dto.request.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.FollowDtoRes;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.FollowedDto;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.SellerFollowersCountDto;
import com.socialmedia.be_java_hisp_w18_Otero.entity.Seller;
import com.socialmedia.be_java_hisp_w18_Otero.entity.User;
import com.socialmedia.be_java_hisp_w18_Otero.exception.NotFoundException;
import com.socialmedia.be_java_hisp_w18_Otero.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_Otero.repository.UserRepositoryImp;

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
            throw new NotFoundException("Something was wrong");
        }
        followDtoRes.setStatusCode(200);
        followDtoRes.setMessage(res);
        return followDtoRes;
    }

    @Override
    public FollowedDto getFollowed(Integer userId, String order) {
        User user = userRepository.getUserByID(userId);
        if(user == null)
            throw new NotFoundException("There is no user with the ID " + userId);
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
            throw new NotFoundException("Not found User with id " + id );
        }
        int quantity = seller.getFollowers().size();
        return new SellerFollowersCountDto(seller.getUser_id(),seller.getUser_name(), quantity);
    }

    @Override
    public UserListDto findUserListBySeller(Integer id, String order) {
        Seller seller = userRepository.findSellerById(id);
        if (seller == null)
            throw new NotFoundException("Not found User with id " + id );
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
            throw new NotFoundException("Not found User with id : " + userId);
        List<Seller> lista = user.getFollowed();
        if (lista.isEmpty())
            throw new NotFoundException("Not found followed");
        return lista;
    }

    @Override
    public String unFollow(Integer userId, Integer userIdToUnfollow) {
        String message = userRepository.unFollow(userId,userIdToUnfollow);
        if(message == null)
            throw new NotFoundException("User or Seller not Found");
        return message;
    }
}
