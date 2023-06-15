package com.example.recaptcha.user;

import com.example.recaptcha.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

}