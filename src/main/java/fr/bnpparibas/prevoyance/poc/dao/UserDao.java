package fr.bnpparibas.prevoyance.poc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.bnpparibas.prevoyance.poc.document.UserDocument;

@Repository
public interface UserDao extends MongoRepository<UserDocument, Integer> {
     List<UserDocument> findByUsername(String username);

}
