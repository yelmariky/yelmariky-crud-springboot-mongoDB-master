package fr.bnpparibas.prevoyance.poc.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import fr.bnpparibas.prevoyance.poc.document.UserDocument;
import fr.bnpparibas.prevoyance.poc.model.User;

public interface UserService {



	public User createUser(User user);


    public Collection<User> getAllUsers();


    public User findUserById(int id);
    
    List<User> findByUsername(String username);

    public void deleteUserById(int id);


    public void deleteAllUsers();
}
