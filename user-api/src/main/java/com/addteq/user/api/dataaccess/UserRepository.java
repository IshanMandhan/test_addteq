package com.addteq.user.api.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addteq.user.api.dataaccess.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	
}
