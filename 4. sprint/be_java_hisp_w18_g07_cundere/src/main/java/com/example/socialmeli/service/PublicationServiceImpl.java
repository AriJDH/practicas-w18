package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PublicationPromoRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.PublicationPromoCountResponse;
import com.example.socialmeli.dto.response.PublicationResponse;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;
import com.example.socialmeli.entity.PublicationEntity;
import com.example.socialmeli.entity.PublicationPromoEntity;
import com.example.socialmeli.entity.UserEntity;
import com.example.socialmeli.repository.IProductRepository;
import com.example.socialmeli.repository.IPublicationRepository;
import com.example.socialmeli.repository.IUserRepository;
import com.example.socialmeli.util.PublicationMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
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
     *
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
     * This method create a PublicationPromoEntity, this class inherits from PublicationEntity
     * and its behavior is the same as registerPublication but adapted
     *
     * @param publicationPromoRequest json with publication data and product data
     */
    @Override
    public void registerPublicationPromo(PublicationPromoRequest publicationPromoRequest) {
        UserEntity entity = userRepository.getEntityById(publicationPromoRequest.getUserId());
        productRepository.getEntityById(publicationPromoRequest.getProductRequest().getId());
        PublicationPromoEntity publicationPromo = PublicationMapper.publicationPromoRequest2PublicationPromoEntity(publicationPromoRequest);
        publicationRepository.addEntity(publicationPromo);
        entity.getPublicationList().add(publicationPromo.getId());
    }

    /**
     * US 0006: Obtain a list of the publications made by the sellers that a
     * user follows in the last two weeks (ordering by date).
     *
     * @param userId user identification number
     * @param order  publication response order by date: name_asc=ascending; name_desc=descending
     * @return user followed publication response DTO
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

    /**
     * This method returns a list of all PublicationEntity if no parameters are given.
     * You can enter a minimum, a maximum or both and set a price range
     *
     * @param minPrice value to filter the list of all publications
     * @param maxPrice value to filter the list of all publications
     * @return responseList the list of all PublicationEntity in the repository
     */
    @Override
    public List<PublicationResponse> getPublicationResponseListByPriceRange(Integer minPrice, Integer maxPrice) {
        List<PublicationEntity> entityList = new ArrayList<>(publicationRepository.getAllEntity().values());
        List<PublicationResponse> responseList = new ArrayList<>();

        for (PublicationEntity entity : entityList) {

            if (entity.getClass() == PublicationPromoEntity.class) {
                responseList.add(PublicationMapper.anyTypeOfPublicationEntity2PublicationResponse(
                        entity, productRepository.getEntityById(entity.getProductId()), entity.getPrice() * ((PublicationPromoEntity) entity).getDiscount()));
            }

            if (entity.getClass() == PublicationEntity.class) {
                responseList.add(PublicationMapper.anyTypeOfPublicationEntity2PublicationResponse(
                        entity, productRepository.getEntityById(entity.getProductId()), entity.getPrice()));
            }
        }

        if (minPrice > 0) {

            responseList = responseList
                    .stream()
                    .filter(publicationResponse -> publicationResponse.getPrice() >= minPrice)
                    .collect(Collectors.toList());
        }

        if ((maxPrice > 0) && (maxPrice > minPrice)) {

            responseList = responseList
                    .stream()
                    .filter(publicationResponse -> publicationResponse.getPrice() <= maxPrice)
                    .collect(Collectors.toList());
        }

        return responseList;
    }

    /**
     *
     * This method returns the number of PublicationPromo that a user has.
     * followed by your id and name
     *
     * @param userId value to find a user
     * @return response object response conforme by user_id, user_name and number of PublicationPromoEntity
     */
    @Override
    public PublicationPromoCountResponse getPublicationPromoCountByUserId(Integer userId) {
        Integer publicationPromoCounter = 0;
        PublicationPromoCountResponse response;
        if (userRepository.exist(userId)) {
            List<Integer> publicationIdList = userRepository.getEntityById(userId).getPublicationList();
            for (Integer publication : publicationIdList) {
                if (publicationRepository.getEntityById(publication).getClass() == PublicationPromoEntity.class) {
                    publicationPromoCounter++;
                }
            }
            response = new PublicationPromoCountResponse();
            response.setUserId(userId);
            response.setUserName(userRepository.getEntityById(userId).getName());
            response.setPublicationPromoCount(publicationPromoCounter);
        } else {
            response = new PublicationPromoCountResponse(userId, null, 0);
        }

        return response;
    }

}
