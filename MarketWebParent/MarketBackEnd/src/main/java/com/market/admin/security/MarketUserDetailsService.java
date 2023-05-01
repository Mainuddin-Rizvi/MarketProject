package com.market.admin.security;

import com.market.admin.user.UserRepository;
import com.market.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MarketUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if (user!=null){
            return new MarketUserDetails(user);
        }

        throw new UsernameNotFoundException("Could not found user with email "+email);
    }
}
