package com.hw1.springhw1.repository;


import com.hw1.springhw1.repository.dto.RoleDto;
import com.hw1.springhw1.repository.dto.UserDto;
import com.hw1.springhw1.repository.selectprovider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    @InsertProvider(type = UserProvider.class, method = "insertUserSql")
    boolean insert(UserDto userDto) throws PSQLException;

    @InsertProvider(type = UserProvider.class, method = "createUserRolesSql")
    boolean createUserRoles(UserDto user, RoleDto role);

    @SelectProvider(type = UserProvider.class, method = "selectIdByUserId")
    int selectIdById(int Id);

    @SelectProvider(type = UserProvider.class, method = "selectUserByUsernameSql")
    @Results({
            @Result(column = "account_name", property = "username"),
            @Result(column = "id", property = "roles",
            many = @Many(select = "selectRolesByUserId"))
    })
    UserDto selectUserByUsername(String username);

    @Select("select r.id, r.role_name from school.role r\n" +
            "inner join school.account_role ur on r.id = ur.role_id\n" +
            "where ur.account_id = #{id}")
    List<RoleDto> selectRolesByUserId(int id);

}
