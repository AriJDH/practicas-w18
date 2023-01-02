package com.mercadolibre.pf_be_java_hisp_w18_g1.entity;

import javax.persistence.*;

import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.ApplicationRol;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mercadolibre.pf_be_java_hisp_w18_g1.enums.ApplicationRol.AGENT;

@Data
@Entity
@EqualsAndHashCode
public class Agent extends ApplicationUser {
    public Agent(Long id, String userName, String password) {
        super(id, userName, password,new ArrayList<>(Arrays.asList(new ApplicationRol[]{AGENT})));
    }

    public Agent(String userName, String password) {
        super(userName, password, new ArrayList<>(Arrays.asList(new ApplicationRol[]{AGENT})));
    }

    public Agent() {
        super();
    }

}
