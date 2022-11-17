package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.UserDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.UserListDTO;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import com.socialmedia.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia.be_java_hisp_w18_g08.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.SellerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImp implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImp(UserRepositoryImp repo) {
        this.userRepository = repo;
    }

    @Override
    public FollowedDTO getFollowed(Integer userId) {
        User user = userRepository.getUserByID(userId);
        FollowedDTO response = new FollowedDTO();
        response.setUser_id(user.getUser_id());
        response.setUser_name(user.getUser_name());
        response.setFollowed(createSellerDTOList(user.getFollowed()));
        return response;
    }

    private List<SellerDTO> createSellerDTOList(List<Seller> followed) {
        List<SellerDTO> sellers = new ArrayList<>();
        for (Seller s : followed) {
            SellerDTO aux = new SellerDTO(s.getUser_id(), s.getUser_name());
            sellers.add(aux);
        }
        return sellers;
    }

    @Override
    public UserListDTO findUserListBySeller(Integer id) {
        Seller seller = userRepository.findUserListBySeller(id);
        if (seller == null)
            throw new NotFoundUserException("El usuario no fue encontrado");
        UserDTO userDto = new UserDTO();
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User s : seller.getFollowers()) {
            userDto.setUser_id(s.getUser_id());
            userDto.setUser_name(s.getUser_name());
            usersDTO.add(userDto);
        }
        UserListDTO userListDTO = new UserListDTO(seller.getUser_id(), seller.getUser_name(), usersDTO);
        return userListDTO;
    }
}
