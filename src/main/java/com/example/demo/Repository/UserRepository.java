package com.example.demo.Repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.example.demo.Entity.User;
public interface UserRepository extends Neo4jRepository < User, Long > {
	//afficher l'utilisateur qui a pour id
	@Query("match(ex:User{id:{0} }) return ex;")User getUserByid(long id);//lister les utilisateurs
	@Query("match(cc) return cc;")
	Collection<User> getAllUsers();//recherche un utilisateur a partir de 
	@Query("match (n:User) where n.Username={0} return n;")
	User findByUsername(String username );//chercher un utilisateur a partir de sone-mail
	@Query("match (cc:User{Email_User:{0}} )return cc;")
	User findByEmail(String Email_User);
}
