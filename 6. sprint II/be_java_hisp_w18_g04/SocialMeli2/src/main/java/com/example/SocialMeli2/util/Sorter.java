package com.example.SocialMeli2.util;

import com.example.SocialMeli2.dto.respose.PostDTORes;
import com.example.SocialMeli2.dto.respose.UserDTORes;

import java.util.Comparator;
import java.util.List;

public class Sorter {
    public static void sortedByName(List<UserDTORes> list, String order) {
        if (order.equals("name_asc"))
            list.sort(Comparator.comparing(UserDTORes::getUser_name));
        if (order.equals("name_desc"))
            list.sort(Comparator.comparing(UserDTORes::getUser_name).reversed());
    }

    public static void sortByDate(List<PostDTORes> list, String order) {
        if (order.equals("date_asc"))
            list.sort(Comparator.comparing(PostDTORes::getDate));
        if (order.equals("date_desc"))
            list.sort(Comparator.comparing(PostDTORes::getDate).reversed());
    }
}
