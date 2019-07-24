package com.tricon.LoginService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tricon.LoginService.entity.Login;

@Repository
public interface LoginRepository extends MongoRepository<Login, String> {

}
