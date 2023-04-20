package zian.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName User
 * @Description
 * @Author ljzhang
 * @Date 2023/4/17 10:42
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class User {

    private Integer userId;

    private String username;

    private String password;

    private Integer age;

    private String phone;

    private String gender;

     public User( String username, String password){
        this.username = username;
        this.password = password;
    }

}
