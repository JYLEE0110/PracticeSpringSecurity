package org.zerock.b5.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUserName : " + username);
        UserDetails user = User.builder()
        .username(username)
        .password("$2a$10$aqa2.NpvDL.VAEeaTHd78esrQAaLRk/bd3xEbnjl.VcEWvK9Kg/GC")
        .authorities("ROLE_USER","ROLE_G1")
        .build();

        return user;
    }
    
}
