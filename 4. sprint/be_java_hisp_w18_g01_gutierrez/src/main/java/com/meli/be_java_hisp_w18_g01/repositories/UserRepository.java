package com.meli.be_java_hisp_w18_g01.repositories;

import com.meli.be_java_hisp_w18_g01.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository extends ListRepository<User>{
    public Optional<User> findById(long id) {
        return super.list.stream().filter(e->e.getUser_id()==id).findFirst();
    }

}
