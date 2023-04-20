package zian.example.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService{

    /**
     * 登录
     * @param username
     * @param password
     * @return 用户名，登录失败返回空指针
     */
    public String login(String username, String password);


    /**
     * 为UserDetailsService 提供的方法，获取UserDetails ----用于获取用户信息
     * @param usename
     * @return
     */
    public UserDetails loadUserByUsername(String usename);
}
