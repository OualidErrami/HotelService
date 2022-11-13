package org.sid.hotelservice.Config;

import org.sid.hotelservice.Auth.JwtFilterRequest;
import org.sid.hotelservice.Auth.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    private final JwtFilterRequest jwtFilterRequest;

    public SecurityConfiguration(UserService userService, JwtFilterRequest jwtFilterRequest) {
        this.userService = userService;
        this.jwtFilterRequest = jwtFilterRequest;
    }

    @Override
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userService);
    }


    @Override

    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.authorizeRequests().antMatchers("/hotel/SignIn","/hotel/SignUp").permitAll().anyRequest().authenticated().and().csrf().disable();
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



}
