package com.broadcom.userservice.dao;

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

    @Select("SELECT id, name FROM user_group WHERE name=\"#{groupName}\"")
    public Group getGroupByName(@Param("groupName") String groupName);

    @Update("update group set name = #{Name}  WHERE id=#{groupId}")
    public void setName(@Param("groupId") int groupId, @Param("name") String name);

    @Insert("insert into user_group (name) values (#{group.name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addGroup(Group group);

    @Delete("delete from user_group where id =#{groupId}")
    public void deleteGroup(@Param("groupId") int groupId);

}
