package com.meli.be_java_hisp_w18_g01.services.database;

import com.meli.be_java_hisp_w18_g01.entities.User;

public interface UserDbService {
    User findById(long id);
}
