package io.inzi.springsecurityold.service;

import io.inzi.springsecurityold.model.MyUser;
import io.inzi.springsecurityold.model.UserEntity;
import io.inzi.springsecurityold.reository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Username does not exist"));
        return user.map(MyUser::new).get();
    }
}
