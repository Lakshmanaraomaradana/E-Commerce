package com.mlr.mart.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mlr.mart.entity.Customer;
import com.mlr.mart.entity.Product;
import com.mlr.mart.entity.SecurityUser;
import com.mlr.mart.entity.User;
import com.mlr.mart.service.CustomerService;
import com.mlr.mart.service.ProductService;
import com.mlr.mart.service.SecurityUserService;
import com.mlr.mart.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private SecurityUserService securityuserservice;
	
	@Autowired
	private ProductService productservice;
	
	
	//private PasswordEncoder encoder;
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		
		Customer customer=new Customer();
		customer.setFirstName(user.getFirstName());
		customer.setLastName(user.getLastName());
		customer.setEmail(user.getEmail());
		customer.setContactNo(user.getContactNo());
		
		SecurityUser securityuser=new SecurityUser();
		securityuser.setUserName(user.getUserName());
		securityuser.setPassword(user.getPassword());
		securityuser.setRoles(null);
		
		customerservice.addCustomer(customer);
		userservice.addUser(user);
		securityuserservice.addSecurityUser(securityuser);
		
		return new ResponseEntity<>("User added",HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addProductToCart/{productId}")
	public ResponseEntity<?>addProductToCart(@PathVariable int productId, Principal principle){
		
		Product product=productservice.findProductById(productId);
		if(product==null) {
			return new ResponseEntity<>("No products found with this id: "+productId,HttpStatus.NOT_FOUND); 
		}
		String username=principle.getName();
		try{
			User user=userservice.findUser(username);
			String response=userservice.addProductToCart(user, product);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/findUserByUserName/{username}")
	public ResponseEntity<?> findUserByUserName(@PathVariable String username) {
		try {
		User user=userservice.findUser(username);
		return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
    
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/allCartProducts")
	public ResponseEntity<?>getAllCartProductByUser(Principal principle){
		
		String username=principle.getName();
		User user=userservice.findUser(username);
		if(user==null) {
			return new ResponseEntity<>("User is empty",HttpStatus.NOT_FOUND);
		}
		List<Product>products=user.getProducts();
		if(products==null) {
			return new ResponseEntity<>("Cart is empty",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
}        
