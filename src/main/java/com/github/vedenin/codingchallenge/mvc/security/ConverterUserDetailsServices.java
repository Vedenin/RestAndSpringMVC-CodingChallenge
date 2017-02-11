package com.github.vedenin.codingchallenge.mvc.security;

import com.github.vedenin.codingchallenge.persistence.UserEntity;
import com.github.vedenin.codingchallenge.persistence.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by slava on 11.02.17.
 */
@Service
public class ConverterUserDetailsServices implements UserDetailsService {
    @Inject
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(s);
        if(userEntity == null) {
            throw new UsernameNotFoundException(s);
        } else {
            return userEntity;
        }
    }
}
