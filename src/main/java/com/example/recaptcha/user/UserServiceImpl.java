package com.example.recaptcha.user;
import java.util.List;

import com.example.recaptcha.user.IUserService;
import com.example.recaptcha.user.User;
import com.example.recaptcha.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repo;

    @Override
    public Integer createUser(User user) {
        Integer userId= repo.save(user).getId();
        return userId;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users= repo.findAll();
        return users;
    }

}