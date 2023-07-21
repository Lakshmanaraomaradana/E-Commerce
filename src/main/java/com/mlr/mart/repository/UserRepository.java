package com.mlr.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mlr.mart.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
