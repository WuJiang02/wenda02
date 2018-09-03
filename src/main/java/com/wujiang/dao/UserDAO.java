package com.wujiang.dao;

import com.wujiang.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDAO {
    String TABLE_NAME="user";
    String INSERT_FIELDS="name,password,salt,headUrl";
    String SELECT_FIELDS="id,"+INSERT_FIELDS;

    @Select("select "+SELECT_FIELDS+" from "+TABLE_NAME+" where id=#{id}")
    User selectById(int id);

    @Select("select "+SELECT_FIELDS+" from "+TABLE_NAME+" where name=#{username}")
    User selectByName(String username);

    @Insert("insert into "+TABLE_NAME+"("+INSERT_FIELDS+")"+"values(#{name},#{password},#{salt},#{headUrl})")
    int addUser(User user);
}
