package com.example.socialmeli2.util;

import com.example.socialmeli2.dto.response.PublicationResponse;
import com.example.socialmeli2.dto.response.UserBasicResponse;
import com.example.socialmeli2.exception.InvalidParameterException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListSorterByOrder {

    public static List<UserBasicResponse> userSortedByName(List<UserBasicResponse> userList, String order) {
        List<String> validOrder = Arrays.asList("name_asc", "name_desc");

        if (!validOrder.contains(order)) {
            throw new InvalidParameterException("Ordenamiento inexistente");
        }
        if (order.equals("name_asc")) {
            userList.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        }
        if (order.equals("name_desc")) {
            userList.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));
        }

        return userList;
    }

    public static List<PublicationResponse> publicationSortedByDate(List<PublicationResponse> publicationResponseList, String order) {
        List<String> validOrder = Arrays.asList("date_asc", "date_desc", "");
        List<PublicationResponse> sortedList;

        if (!validOrder.contains(order)) {
            throw new InvalidParameterException("Ordenamiento inexistente");
        }

        if (order.equals("date_desc")) {
            sortedList = publicationResponseList.stream()
                    .sorted(Comparator.comparing(PublicationResponse::getDate).reversed())
                    .collect(Collectors.toList());
        } else {
            sortedList = publicationResponseList.stream()
                    .sorted(Comparator.comparing(PublicationResponse::getDate))
                    .collect(Collectors.toList());
        }

        return publicationResponseList;
    }

}
