package jp.co.axa.apidemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * <pre>
 * Protect security
 * </pre>
 * @author Yin
 * @version 1.0
 *
 */
@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

 
    /**
     * configure<br>
     * <br>
     * Protect controller end points
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Permit for h2-Console;forbidden CSRF & headers frameOptions
        http.authorizeRequests()
//                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();
    }

    /**
     * userDetailsService<br>
     * <br>
     * create default user in memory
     * 
     * @return Result all the results
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123456")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    /**
     * configure<br>
     * <br>
     * configue the AuthenticationManagerBuilder
     * 
     * @param AuthenticationManagerBuilder
     * 
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}
