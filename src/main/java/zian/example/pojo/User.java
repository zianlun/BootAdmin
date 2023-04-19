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
    private String username;
    private String password;
}
