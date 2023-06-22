package org.zerock.b5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

// 자동으로 SpringBoot가 구성을 읽음
@Configuration
@Log4j2

// Controller에서 PreAuthorize로 권한을 주려고
@EnableMethodSecurity
public class CustomSecurityConfig {

    // PassWord Encoder => 암호화
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    // 리턴타입을 Bean으로 등록
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {

        log.info("-----------------------configuration---------------------");


        // Login 설정을 커스텀하겠다.
        http.formLogin(Customizer.withDefaults());

        // Login이 안되면 페이지 못넘어가게 막고 다시 Login창으로 보내는 코드
        // http.authorizeHttpRequests(requests -> {

        //     requests.anyRequest().authenticated();

        // });


        return http.build();
    }

}
