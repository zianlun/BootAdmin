package zian.example.mapper;

import zian.example.pojo.User;

public interface UserMapper {
    User queryByUserName(String usename);
}
