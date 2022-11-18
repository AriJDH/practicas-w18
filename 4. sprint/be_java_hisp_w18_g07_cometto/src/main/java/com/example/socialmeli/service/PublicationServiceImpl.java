package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PublicationPromotionRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.PublicationPromotionCountResponse;
import com.example.socialmeli.dto.response.PublicationPromotionSumResponse;
import com.example.socialmeli.dto.response.PublicationResponse;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;
import com.example.socialmeli.entity.PublicationEntity;
import com.example.socialmeli.entity.UserEntity;
import com.example.socialmeli.exception.NotFoundException;
import com.example.socialmeli.repository.IProductRepository;
import com.example.socialmeli.repository.IPublicationRepository;
import com.example.socialmeli.repository.IUserRepository;
import com.example.socialmeli.util.PublicationMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements IPublicationService {

    private final IPublicationRepository publicationRepository;
    private final IProductRepository productRepository;
    private final IUserRepository userRepository;

    private final ObjectMapper mapper = new ObjectMapper();


    /**
     * US 0005: URL=/products/post
     * @param publicationRequest json with publication data and product data
     */
    @Override
    public void registerPublication(PublicationRequest publicationRequest) {
        UserEntity entity = userRepository.getEntityById(publicationRequest.getUserId());
        productRepository.getEntityById(publicationRequest.getProductRequest().getId());
        PublicationEntity publication = PublicationMapper.publicationRequest2PublicationEntity(publicationRequest);
        publicationRepository.addEntity(publication);
        entity.getPublicationList().add(publication.getId());
    }

    /**
     * US 010 Permite agregar una publicacion en promocion
     * @param publicationPromotionRequest
     */
    @Override
    public void registerPublicationPromotion(PublicationPromotionRequest publicationPromotionRequest) {
        if (!userRepository.exist(publicationPromotionRequest.getUserId())) {
            throw new NotFoundException("No existe usuario con ID: " + publicationPromotionRequest.getUserId());
        }

        else {

            UserEntity entity = userRepository.getEntityById(publicationPromotionRequest.getUserId());
            productRepository.getEntityById(publicationPromotionRequest.getProductRequest().getId());
            PublicationEntity publication = PublicationMapper.publicationRequest2PublicationPromotionEntity(publicationPromotionRequest);
            publicationRepository.addEntity(publication);
            entity.getPublicationList().add(publication.getId());
            System.out.println("Desde el servicio OK");
        }
    }

    /**
     * Corresponde a la US 011 donde se debe contar la cantidad de publicaciones que son promocion.
     * @param userId Usuario a buscar
     * @return Cantidad de elementos que son promocion. Puede devolver 0 porque el vendedor no posee publicaciones
     * en promocion
     */
    @Override
    public PublicationPromotionCountResponse countPublicationPromotionById(Integer userId){
        if (!userRepository.exist(userId)) {
            throw new NotFoundException("No existe usuario con ID: " + userId);
        }

        if (!userRepository.isSeller(userId)) {
            throw new NotFoundException("El usuario con ID: " + userId + " no es vendedor");
        }

        Integer count= Math.toIntExact(userRepository.getEntityById(userId).getPublicationList().stream()
                .filter(p -> publicationRepository.getEntityById(p).isHasPromo() == true ).count());

        return new PublicationPromotionCountResponse(userId, userRepository.getEntityById(userId).getName(),count);
    }

    /**
     * US 012 Corresponde a la suma de productos en oferta de un vendedor
     * @param userId Usuario a buscar
     * @return devuelve la suma del precio de los productos que tiene el vendedor. Puede devolver 0 porque el vendedor no posee publicaciones
     * en promocion
     */

    @Override
    public PublicationPromotionSumResponse sumPublicationPromotionById(Integer userId){
        double sum = 0;
        if (!userRepository.exist(userId)) {
            throw new NotFoundException("No existe usuario con ID: " + userId);
        }

        if (!userRepository.isSeller(userId)) {
            throw new NotFoundException("El usuario con ID: " + userId + " no es vendedor");
        }else{
            for(Integer element : userRepository.publicationListById(userId)){
                sum += publicationRepository.getEntityById(element).getPrice();
            }
        }
        int result = (int)sum;
        return new PublicationPromotionSumResponse(userId,userRepository.getEntityById(userId).getName(),result);
    }

    /**
     * US 0006: Obtain a list of the publications made by the sellers that a
     * user follows in the last two weeks (ordering by date).
     *
     * @param userId    user identification number
     * @param order     publication response order by date: name_asc=ascending; name_desc=descending
     * @return          user followed publication response DTO
     */
    @Override
    public UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order) {
        int recentDaysDelta = 14; // get publications from today to this many days ago
        mapper.registerModule(new JavaTimeModule());

        UserEntity userEntity = userRepository.getEntityById(userId);
        List<Integer> followedList = userEntity.getFollowedList();

        // get all publications from all followed users (list of list of publications)
        List<List<PublicationEntity>> publicationListList = followedList.stream()
                .map(userRepository::getEntityById)
                .map(userEntity1 -> userEntity1.getPublicationList().stream()
                        .map(publicationRepository::getEntityById)
                        .filter(publicationEntity ->
                                publicationEntity.getDate().until(LocalDate.now(), ChronoUnit.DAYS) <= recentDaysDelta)
                        .collect(Collectors.toList())
                ).collect(Collectors.toList());

        // get all response DTOs - map publications to response to list
        List<PublicationResponse> publicationResponseList = new ArrayList<>();
        for (List<PublicationEntity> publicationEntities : publicationListList) {
            for (PublicationEntity publicationEntity : publicationEntities) {
                publicationResponseList.add(mapper.convertValue(publicationEntity, PublicationResponse.class));
            }
        }

        if (order.equals("date_desc")) {
            publicationResponseList = publicationResponseList.stream()
                    .sorted(Comparator.comparing(PublicationResponse::getDate).reversed())
                    .collect(Collectors.toList());
        } else {
            publicationResponseList = publicationResponseList.stream()
                    .sorted(Comparator.comparing(PublicationResponse::getDate))
                    .collect(Collectors.toList());
        }

        return new UserFollowedPublicationResponse(userId, publicationResponseList);
    }

}
