package com.broadcom.userservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserRoleMapDao {

    @Select("SELECT group_id FROM user_role_map WHERE user_id=#{userId}")
    public List<Integer> getUserRoles(@Param("userId") long userId);

    @Select("SELECT user_id FROM user_role_map WHERE role_id=#{roleId}")
    public List<Long> getUsersofRole(@Param("roleId") long roleId);

    @Insert("insert into user_role_map (user_id, group_id) values (#{userId}, #{roleId})")
    public void addRoleToUser(@Param("userId") long userId, @Param("roleId") int roleId);

    @Delete("delete from user_role_map where user_id =#{userId}")
    public void deleteUserRoleMappingByUserId(@Param("userId") long userId);

    @Delete("delete from user_role_map where user_id =#{userId}")
    public void deleteUserRoleMappingByRoleId(@Param("roleId") long roleId);

}
