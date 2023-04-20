package zian.example.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import zian.example.config.GenUserDetails;
import zian.example.pojo.User;
import zian.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String login(String username, String password) {

        return username;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        return null;
    }
}
