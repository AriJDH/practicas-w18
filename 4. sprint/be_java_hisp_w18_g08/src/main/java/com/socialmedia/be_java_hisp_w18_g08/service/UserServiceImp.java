package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.UserDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.UserListDTO;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import com.socialmedia.be_java_hisp_w18_g08.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements IUserService{

    private IUserRepository userRepository;

    public UserServiceImp(UserRepositoryImp userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserListDTO findUserListBySeller(Integer id) {
        Seller seller = userRepository.findUserListBySeller(id);
        if (seller.equals(null))
            throw new NullPointerException();
        UserDTO userDto = new UserDTO();
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User s : seller.getFollowers()){
            userDto.setUser_id(s.getUser_id());
            userDto.setUser_name(s.getUser_name());
            usersDTO.add(userDto);
        }
        UserListDTO userListDTO = new UserListDTO(seller.getUser_id(), seller.getUser_name(), usersDTO);
        return userListDTO;
    }
}
