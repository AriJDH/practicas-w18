package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PostProductPromRequest;
import com.example.socialmeli.dto.response.UserPostPromoCountResponse;
import com.example.socialmeli.entity.PostProductPromEntity;
import com.example.socialmeli.entity.UserEntity;
import com.example.socialmeli.repository.interfaces.IProductRepository;
import com.example.socialmeli.repository.interfaces.IPublicationPromoRepository;
import com.example.socialmeli.repository.interfaces.IUserRepository;
import com.example.socialmeli.service.interfaces.IPublicationPromService;
import com.example.socialmeli.util.PublicationPromoMapper;
import com.example.socialmeli.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicationPromServiceImpl implements IPublicationPromService {

    private final IPublicationPromoRepository publicationPromRepository;
    private final IProductRepository productRepository;
    private final IUserRepository userRepository;



    /**
     * US 0005: URL=/products/post
     * @param postProductPromRequest json with publication data and product data
     */
    @Override
    public void registerPublicationProm(PostProductPromRequest postProductPromRequest) {
        UserEntity entity = userRepository.getEntityById(postProductPromRequest.getUserId());
        productRepository.getEntityById(postProductPromRequest.getProductRequest().getId());
        PostProductPromEntity postProductProm = PublicationPromoMapper.publicationPromEntity(postProductPromRequest);
        publicationPromRepository.addEntity(postProductProm);
        entity.getPromProductsList().add(postProductProm.getId());
    }

    /**
     * This method is used to count the number of products in promotion of a User.
     *
     * @param userId the ID of the user to count his products on promotion
     * @return The count of the list of the products in promotion
     */
    @Override
    public UserPostPromoCountResponse getUserPromProductCount(Integer userId) {
        UserEntity userCount = userRepository.getEntityById(userId);
        return UserMapper.userPublicationPromCountResponse(userCount);
    }
}
