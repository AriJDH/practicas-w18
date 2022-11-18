package com.example.socialmeli.service;

import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.PublicationResponse;
import com.example.socialmeli.dto.response.UserFollowedPublicationResponse;
import com.example.socialmeli.entity.PublicationEntity;
import com.example.socialmeli.entity.UserEntity;
import com.example.socialmeli.repository.IPublicationRepository;
import com.example.socialmeli.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements IPublicationService{

    private final IPublicationRepository publicationRepository;
    private final IUserRepository userRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean registerPublication(PublicationRequest publicationRequest) {
        mapper.registerModule(new JavaTimeModule());
        PublicationEntity publication = mapper.convertValue(publicationRequest, PublicationEntity.class);
        return publicationRepository.addPublication(publication);
    }

    @Override
    public UserFollowedPublicationResponse getUserFollowedPublicationsById(Integer userId, String order) {
        int recentDaysDelta = 14;
        mapper.registerModule(new JavaTimeModule());

        UserEntity userEntity = userRepository.getEntityByID(userId);
        List<Integer> followedList = userEntity.getFollowedList();

        List<List<PublicationEntity>> publicationListList = followedList.stream()
                .map(userRepository::getEntityByID)
                .map(userEntity1 -> userEntity1.getPublicationList().stream()
                        .map(publicationRepository::getEntityById)
                        .filter(publicationEntity ->
                                LocalDate.now().compareTo(publicationEntity.getDate()) <= recentDaysDelta)
                        .collect(Collectors.toList())
                ).collect(Collectors.toList());

        List<PublicationResponse> publicationResponseList = new ArrayList<>();
        for (List<PublicationEntity> publicationEntities : publicationListList) {
            for (PublicationEntity publicationEntity : publicationEntities) {
                publicationResponseList.add(mapper.convertValue(publicationEntity, PublicationResponse.class));
            }
        }

        if (order.equals("date_desc")){
            publicationResponseList = publicationResponseList.stream()
                    .sorted(Comparator.comparing(PublicationResponse::getDate).reversed())
                    .collect(Collectors.toList());
        }else{
            publicationResponseList = publicationResponseList.stream()
                    .sorted(Comparator.comparing(PublicationResponse::getDate))
                    .collect(Collectors.toList());
        }

        return new UserFollowedPublicationResponse(userId, publicationResponseList);
    }
}
