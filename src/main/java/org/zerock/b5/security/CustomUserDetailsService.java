package org.zerock.b5.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.b5.dto.MemberDTO;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2

public class CustomUserDetailsService implements UserDetailsService {

    /* 리턴타입이 UserDetails 이므로 Mapper를 통해 MemberDTO로 반환해야한다.  */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUserName : " + username);

        MemberDTO memberDTO = 
        new MemberDTO(username, 
        "$2a$10$aqa2.NpvDL.VAEeaTHd78esrQAaLRk/bd3xEbnjl.VcEWvK9Kg/GC", 
        List.of(new SimpleGrantedAuthority("ROLE_USER")));

        // UserDetails user = User.builder()
        // .username(username)
        // .password("$2a$10$aqa2.NpvDL.VAEeaTHd78esrQAaLRk/bd3xEbnjl.VcEWvK9Kg/GC")
        // .authorities("ROLE_USER","ROLE_G1")
        // .build();

        return memberDTO;
    }
    
}
