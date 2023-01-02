package com.mercadolibre.pf_be_java_hisp_w18_g1.entity;

import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.ApplicationRol;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mercadolibre.pf_be_java_hisp_w18_g1.enums.ApplicationRol.BUYER;


@Data
@Entity
@EqualsAndHashCode
public class Buyer extends ApplicationUser {
    public Buyer(Long id, String userName, String password) {
        super(id, userName,password, new ArrayList<>(Arrays.asList(new ApplicationRol[]{BUYER})));
    }

    public Buyer( String userName, String password) {
        super(userName,password, new ArrayList<>(Arrays.asList(new ApplicationRol[]{BUYER})));
    }

    public Buyer() {
        super();
    }
}
