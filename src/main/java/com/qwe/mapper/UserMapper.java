package com.qwe.mapper;

import com.qwe.pojo.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface UserMapper {
    List<User> selectAllUser();
}
