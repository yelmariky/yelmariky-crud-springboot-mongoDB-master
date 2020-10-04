package fr.bnpparibas.prevoyance.poc.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bnpparibas.prevoyance.poc.dao.UserDao;
import fr.bnpparibas.prevoyance.poc.document.UserDocument;
import fr.bnpparibas.prevoyance.poc.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;
   private DozerBeanMapper dozerBeanMapper;
	
		
	@Autowired
	public void setDoze(DozerBeanMapper dozer){
		this.dozerBeanMapper=dozer;
	}

    @Override
    public User createUser(User user) {
    	UserDocument userDocument = dozerBeanMapper.map(user, UserDocument.class);
        dao.save(userDocument);
        return user;
    }


    @Override
    public Collection<User> getAllUsers() {
    	List<UserDocument> usersDocuments = (List<UserDocument>) dao.findAll();

		return usersDocuments.stream().map(s -> dozerBeanMapper.map(s, User.class)).collect(Collectors.toList());
    }


    @Override
    public User findUserById(int id) {
    	UserDocument userDoc = dao.findById(id).isPresent()?dao.findById(id).get():null;
    	if(userDoc !=null) {
    		return dozerBeanMapper.map(userDoc, User.class);
    	}else {
    		return null;
    	}
        
    }
    
    @Override
    public void deleteUserById(int id) {
        dao.deleteById(id);
    }


    @Override
    public void deleteAllUsers() {
        dao.deleteAll();
    }

	@Override
	public List<User> findByUsername(String username) {
		List<UserDocument> usersDocuments = (List<UserDocument>) dao.findByUsername(username);

		return usersDocuments.stream().map(s -> dozerBeanMapper.map(s, User.class)).collect(Collectors.toList());
	}
}
