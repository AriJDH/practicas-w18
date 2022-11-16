package com.bootcamp.be_java_hisp_w18_g06.dto.request;
import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class PostDTO {
    //US-005
    private int post_id;
    private int user_id;
    private LocalDate date;
    private Product product;
    private String category;
    private double price;
}
