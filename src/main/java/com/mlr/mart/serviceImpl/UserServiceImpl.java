package com.mlr.mart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.Product;
import com.mlr.mart.entity.User;
import com.mlr.mart.exception.NoUserFound;
import com.mlr.mart.repository.UserRepository;
import com.mlr.mart.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepository;

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		userrepository.save(user);
		return "added";
	}

	@Override
	public String addProductToCart(User user,Product product) {
		// TODO Auto-generated method stub
		product.setUser(user);
		user.getProducts().add(product);
		userrepository.save(user);
		return "product added to cart";
	}

	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		User user=userrepository.findUserByName(username);
		if(user==null) {
			throw new NoUserFound("No users found with this name :"+username);
		}
		return user;
	}

}
