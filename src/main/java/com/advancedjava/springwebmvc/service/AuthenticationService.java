package com.advancedjava.springwebmvc.service;

import com.advancedjava.springwebmvc.entity.PrincipalUser;
import com.advancedjava.springwebmvc.entity.User;
import com.advancedjava.springwebmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findById(s).isPresent() ? userRepository.findById(s).get() : null;
        UserDetails userDetails = new PrincipalUser(user);
        return userDetails;
    }
}
