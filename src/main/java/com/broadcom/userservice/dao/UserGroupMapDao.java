package com.broadcom.userservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserGroupMapDao {

    @Select("SELECT group_id FROM user_group_map WHERE user_id=#{userId}")
    public List<Integer> getUserGroups(@Param("userId") long userId);

    @Select("SELECT userId_id FROM user_group_map WHERE group_id=#{groupId}")
    public List<Long> getUsersOfGroup(@Param("groupId") long groupId);

    @Insert("insert into user_group_map (user_id, group_id) values (#{userId}, #{groupId})")
    public void addUserToGroup(@Param("userId") long userId, @Param("groupId") int groupId);

    @Delete("delete from user_group_map where user_id =#{userId}")
    public void deleteUserGroupMappingByUserId(@Param("userId") long userId);

    @Delete("delete from user_group_map where group_id =#{groupId}")
    public void deleteUserGroupMappingByGroupId(@Param("groupId") long groupId);

}
