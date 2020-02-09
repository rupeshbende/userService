package com.broadcom.userservice.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.broadcom.userservice.beans.Group;

public interface GroupDao {

    @Select("SELECT id, name FROM user_group WHERE id=#{groupId}")
    public Group getGroup(@Param("groupId") int groupId);

    @Update("update group set name = #{Name}  WHERE id=#{groupId}")
    public void setName(@Param("groupId") int groupId, @Param("name") String name);

    @Insert("insert into user_group (name) values (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addGroup(Map<String, Object> map);

    @Delete("delete from user_group where id =#{groupId}")
    public void deleteUser(@Param("groupId") int groupId);

}
