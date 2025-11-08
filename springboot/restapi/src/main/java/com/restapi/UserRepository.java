package com.restapi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
