package com.broadcom.userservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RolePrivilegesMapDao {

    @Select("SELECT group_id FROM privilege_role_map WHERE role_id=#{roleId}")
    public List<Integer> getRolePrivileges(@Param("roleId") long roleId);

    @Select("SELECT group_id FROM privilege_role_map WHERE user_id=#{privilegesId}")
    public List<Integer> getRoleOfPrivilege(@Param("privilegesId") long privilegesId);

    @Insert("insert into privilege_role_map (role_id, privilege_id) values (#{roleId}, #{privilegeId})")
    public void addPrivilegeToRole(@Param("roleId") int roleId, @Param("privilegeId") int privilegeId);

    @Delete("delete from privilege_role_map where privilege_id =#{privilegeId}")
    public void deletePrivilegeRoleMappingByPrivilegeId(@Param("privilegeId") long privilegeId);

    @Delete("delete from privilege_role_map where role_id =#{roleId}")
    public void deletePrivilegeRoleMappingByRoleId(@Param("roleId") long roleId);

}
