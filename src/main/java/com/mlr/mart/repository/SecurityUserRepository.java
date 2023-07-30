package com.mlr.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mlr.mart.entity.SecurityUser;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Integer>{

	@Query("SELECT s FROM SecurityUser s WHERE s.userName=:username")
	public SecurityUser getUserByUserName(@Param("username") String name);
}
