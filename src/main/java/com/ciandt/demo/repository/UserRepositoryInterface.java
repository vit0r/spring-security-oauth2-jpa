package com.ciandt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciandt.demo.models.User;

@Repository("UserRepository")
public interface UserRepositoryInterface extends JpaRepository<User, Integer> {
	User findByLogin(String login);
}
