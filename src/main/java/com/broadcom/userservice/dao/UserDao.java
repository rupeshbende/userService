package com.broadcom.userservice.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.broadcom.userservice.beans.User;

public interface UserDao {

    @Select("SELECT id, email, firstname as firstName, lastname as lastName FROM users WHERE id=#{userId}")
    public User getUser(@Param("userId") long userId);

    @Update("update users set firstname = #{firstName}  WHERE id=#{userId}")
    public void setFirstName(@Param("userId") long userId, @Param("firstName") String firstName);

    @Update("update users set lastname = #{lastName}  WHERE id=#{userId}")
    public void setLastName(@Param("userId") long userId, @Param("lastName") String lastName);

    @Insert("insert into users (email, firstname, lastname) values (#{email}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addUser(Map<String, Object> map);

    @Delete("delete from users where id =#{userId}")
    public void deleteUser(@Param("userId") long userId);

}
