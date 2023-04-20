package zian.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import zian.example.service.UserService;

/**
 * Created by zian on 2017/12/28.
 * 当我向ioc容器中注入这个webSercurityConfig时，可以通过重写一些方法改变默认配置
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // inde.html对应的url允许所任人访问
                .antMatchers("/").permitAll()
                // user.html对应的url，则需要用户有USER的角色才可以访问
                .antMatchers("/index").hasRole("USER")
                .and()
                .formLogin();
    }

    @Bean
    public UserDetailsService securityService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("$2a$10$Ja4.C5MlGWxKHVyx/lMMteAfeu3.i6doayW7PIowjwdPBPd1COAZ6").roles("USER").build());
//        return username -> userService.loadUserByUsername(username);
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
