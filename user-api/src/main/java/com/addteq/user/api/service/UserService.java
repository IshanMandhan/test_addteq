package com.addteq.user.api.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addteq.user.api.dataaccess.UserRepository;
import com.addteq.user.api.dataaccess.entities.UserEntity;
import com.addteq.user.api.domain.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUserNamesFromDB() {
		List<UserEntity> userList = userRepository.findAll();
		return userList.stream()
				.map(UserEntity::getUserName)
				.map(User::new)
				.collect(Collectors.toList());
	}

	public int saveUsersToDatabase() {
		 File userFile = new File("");
		 List<UserEntity> usersList = new ArrayList<>();
		 
		 try(BufferedReader reader = new BufferedReader(new FileReader(userFile))){
				String userName = reader.readLine();
				while(userName != null) {
					usersList.add(new UserEntity(userName));
					userName = reader.readLine();
				}
			} catch (Exception e) {
				return 0;
			}
		return  userRepository.saveAll(usersList).size();
	}
	
	

}
