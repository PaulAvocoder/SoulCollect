package com.pavel.SoulCollect.services;

import com.pavel.SoulCollect.models.User;
import com.pavel.SoulCollect.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("Username not found");
        }
        return user;
    }

}
