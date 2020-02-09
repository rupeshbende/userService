package com.broadcom.userservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GroupRoleMapDao {

    @Select("SELECT role_id FROM role_group_map WHERE group_id=#{groupId}")
    public List<Integer> getGroupRoles(@Param("userId") long userId);

    @Select("SELECT group_id FROM role_group_map WHERE role_id=#{roleId}")
    public List<Integer> getGroupsOfRole(@Param("roleId") long roleId);

    @Insert("insert into role_group_map (role_id, group_id) values (#{roleId}, #{groupId})")
    public void addRoleToGroup(@Param("roleId") long roleId, @Param("groupId") int groupId);

    @Delete("delete from role_group_map where role_id =#{roleId}")
    public void deleteRoleGroupMappingByRoleId(@Param("roleId") long roleId);

    @Delete("delete from role_group_map where group_id =#{groupId}")
    public void deleteRoleGroupMappingByGroupId(@Param("groupId") long groupId);

}
