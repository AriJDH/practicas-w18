package com.example.socialmeli2.util;

import com.example.socialmeli2.dto.response.PublicationResponse;
import com.example.socialmeli2.entity.PublicationEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PublicationFactory {

    public static List<PublicationEntity> getPublicationsReturn() {
        PublicationEntity publication1 = new PublicationEntity
                (1, LocalDate.of(2022, 11, 25), 2, 1, 1, 99.99);
        PublicationEntity publication2 = new PublicationEntity
                (2, LocalDate.of(2022, 11, 26), 2, 2, 1, 199.99);
        List<PublicationEntity> publicationList = new ArrayList<>();
        publicationList.add(publication1);
        publicationList.add(publication2);

        return publicationList;
    }

    public static List<PublicationResponse> createListOfPublicationsOrderAsc() {
        PublicationResponse publication1 = new PublicationResponse
                (1, LocalDate.of(2022, 11, 25), 2, 1, 1, 99.99);
        PublicationResponse publication2 = new PublicationResponse
                (2, LocalDate.of(2022, 11, 26), 2, 2, 1, 199.99);
        List<PublicationResponse> publicationList = new ArrayList<>();
        publicationList.add(publication1);
        publicationList.add(publication2);

        return publicationList;
    }

    public static List<PublicationResponse> createListOfPublicationsOrderDesc() {
        PublicationResponse publication1 = new PublicationResponse
                (1, LocalDate.of(2022, 11, 25), 2, 1, 1, 99.99);
        PublicationResponse publication2 = new PublicationResponse
                (2, LocalDate.of(2022, 11, 26), 2, 2, 1, 199.99);
        List<PublicationResponse> publicationList = new ArrayList<>();
        publicationList.add(publication2);
        publicationList.add(publication1);

        return publicationList;
    }

    public static List<PublicationEntity> getPublicationsInLastFourWeeks() {
        LocalDate todayDate = LocalDate.now();
        PublicationEntity publication1 = new PublicationEntity
                (1, todayDate.minusDays(1), 2, 1, 1, 99.99);
        PublicationEntity publication2 = new PublicationEntity
                (2, todayDate.minusDays(38), 2, 2, 1, 199.99);
        PublicationEntity publication3 = new PublicationEntity
                (3, todayDate.minusDays(10), 2, 2, 1, 199.99);
        PublicationEntity publication4 = new PublicationEntity
                (4, todayDate.minusDays(18), 2, 2, 1, 199.99);
        List<PublicationEntity> publicationList = new ArrayList<>();
        publicationList.add(publication1);
        publicationList.add(publication2);
        publicationList.add(publication3);
        publicationList.add(publication4);

        return publicationList;
    }

    public static List<PublicationResponse> getPublicationsInLastTwoWeeks() {
        LocalDate todayDate = LocalDate.now();
        PublicationResponse publication1 = new PublicationResponse
                (1, todayDate.minusDays(1), 2, 1, 1, 99.99);
        PublicationResponse publication3 = new PublicationResponse
                (3, todayDate.minusDays(10), 2, 2, 1, 199.99);
        List<PublicationResponse> publicationResponseList = new ArrayList<>();
        publicationResponseList.add(publication1);
        publicationResponseList.add(publication3);

        return publicationResponseList;
    }

}
