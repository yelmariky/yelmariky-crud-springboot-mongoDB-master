package fr.bnpparibas.prevoyance.poc.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.bnpparibas.prevoyance.poc.api.UsersApiDelegate;
import fr.bnpparibas.prevoyance.poc.model.User;
import fr.bnpparibas.prevoyance.poc.service.UserService;

@Service
public class UserApiDelegateImpl implements UsersApiDelegate {
	
	 @Autowired
	 UserService serv;
	 
	@Override
    public ResponseEntity<User> getUserByName(String username) {
        List<User> users = serv.findByUsername(username);
        User userResult=users.isEmpty()?null:users.get(0);

        return ResponseEntity.ok(userResult);
    }
	@Override
	public ResponseEntity<Void> createUser(User user) {
			       
        serv.createUser(user);
        
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
	
}
