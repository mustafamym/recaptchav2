package com.example.recaptcha.user;

import java.util.List;


public interface IUserService {

    Integer createUser(User user);
    List<User> getAllUsers();
}