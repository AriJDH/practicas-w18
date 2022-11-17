package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.UserDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.UserListDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.SellerFollowersCountDTO;
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
        List<String> res = new ArrayList<>();
        FollowDtoRes followDtoRes = new FollowDtoRes();
        res = userRepository.follow(followDtoReq.getUserId(), followDtoReq.getUserIdToFollow());
        if (res == null) {
            throw new NotFoundUserException("There is no user with the ID " + followDtoReq.getUserId() + " or " +
                    followDtoReq.getUserIdToFollow());
        }
        followDtoRes.setStatusCode(200);
        followDtoRes.setMessage(res.get(0) + " is following " + res.get(1));
        return followDtoRes;
    }


    @Override
    public FollowedDTO getFollowed(Integer userId, String order) {
        User user = userRepository.getUserByID(userId);
        if(user == null)
            throw new NotFoundUserException("There is no user with the ID " + userId);
        FollowedDTO response = new FollowedDTO();
        response.setUser_id(user.getUser_id());
        response.setUser_name(user.getUser_name());
        response.setFollowed(createUserDTOList(user.getFollowed(), order));
        return response;
    }

    private List<UserDTO> createUserDTOList(List<Seller> followed, String order) {
        List<UserDTO> sellers = new ArrayList<>();
        for (Seller s : followed) {
            UserDTO aux = new UserDTO(s.getUser_id(), s.getUser_name());
            sellers.add(aux);
        }
        if(order != null)
            changeOrder(sellers, order);
        return sellers;
    }

    private void changeOrder(List<UserDTO> list, String order) {
        Comparator<UserDTO> compareByName =
                Comparator.comparing(UserDTO::getUser_name);
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
    public SellerFollowersCountDTO findAllFollowersQuantity(Integer id) {
        Seller seller = userRepository.findSellerById(id);

        if(seller == null){
            throw new NullPointerException();
        }
        int quantity = seller.getFollowers().size();
        return new SellerFollowersCountDTO(seller.getUser_id(),seller.getUser_name(), quantity);
    }

    @Override
    public UserListDTO findUserListBySeller(Integer id, String order) {
        Seller seller = userRepository.findSellerById(id);
        if (seller == null)
            throw new NotFoundUserException("El usuario no fue encontrado");
        UserDTO userDto = new UserDTO();
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User s : seller.getFollowers()) {
            userDto.setUser_id(s.getUser_id());
            userDto.setUser_name(s.getUser_name());
            usersDTO.add(userDto);
        }
        if(order != null)
            changeOrder(usersDTO, order);
        UserListDTO userListDTO = new UserListDTO(seller.getUser_id(), seller.getUser_name(), usersDTO);
        return userListDTO;
    }

    public List<Seller> getFollowedByUserId(Integer userId) {
        List<Seller> lista = userRepository.getUserByID(userId).getFollowed();
        if (lista.isEmpty())
            throw new NotFoundUserException("Not found User with id : " + userId);
        return lista;
    }

}
