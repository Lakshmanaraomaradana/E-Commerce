package com.mlr.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mlr.mart.entity.SecurityUser;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Integer>{

}
