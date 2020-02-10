package com.broadcom.userservice.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.broadcom.userservice.beans.Role;

public interface RoleDao {

    @Select("SELECT id, name FROM user_role WHERE id=#{roleId}")
    public Role getRole(@Param("roleId") int roleId);

    @Select("SELECT id, name FROM user_role WHERE name=#{roleName}")
    public Role getRole(@Param("roleName") String roleName);

    @Update("update group set name = #{Name}  WHERE id=#{roleId}")
    public void setName(@Param("roleId") int groupId, @Param("name") String name);

    @Insert("insert into user_role (name) values (#{role.name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addRole(Role role);

    @Delete("delete from user_role where id =#{roleId}")
    public void deleteRole(@Param("roleId") int roleId);

}
