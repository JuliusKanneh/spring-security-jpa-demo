package com.wisdom.springsecurityjpademo;

import com.wisdom.springsecurityjpademo.models.MyUserDetails;
import com.wisdom.springsecurityjpademo.models.User;
import com.wisdom.springsecurityjpademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUserName(username);

        user.orElseThrow(()-> new UsernameNotFoundException("User not found "+ username));

        return user.map(MyUserDetails::new).get();
    }
}
