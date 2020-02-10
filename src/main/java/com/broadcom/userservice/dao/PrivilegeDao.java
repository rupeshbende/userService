package com.broadcom.userservice.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.broadcom.userservice.beans.Privilege;

public interface PrivilegeDao {

    @Select("SELECT id, name FROM user_privilege WHERE id=#{privilegeId}")
    public Privilege getPrivilege(@Param("privilegeId") int privilegeId);

    @Select("SELECT id, name FROM user_privilege WHERE id=#{privilegeName}")
    public Privilege getPrivilege(@Param("privilegeName") String privilegeName);

    @Update("update user_privilege set name = #{Name}  WHERE id=#{groupId}")
    public void setName(@Param("privilegeId") int groupId, @Param("name") String name);

    @Insert("insert into user_privilege (name) values (#{privilege.name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addPrivilege(Privilege privilege);

    @Delete("delete from user_privilege where id =#{privilegeId}")
    public void deletePrivilege(@Param("privilegeId") int privilegeId);

}
