package com.assignment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	@Query("Select u from User u where u.userName=?1")
	Optional<User> findByUserName(String UserName);

}
