package com.hw1.springhw1.repository.selectprovider;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String selectRolesByUserIdSql(String userId) {
        return new SQL(){{
            SELECT("r.id, r.role_name");
            FROM("school.roles r");
            INNER_JOIN("school.account_role ur ON r.id = ur.role_id");
            WHERE("ur.id = '" + userId +"'");
        }}.toString();
    }

    public String selectUserByUsernameSql() {
        return new SQL(){{
            SELECT("*");
            FROM("school.account");
            WHERE("account_name = #{username}");
        }}.toString();
    }

    public String selectIdByUserId() {
        return new SQL(){{
            SELECT("id");
            FROM("school.account");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String createUserRolesSql() {
        return new SQL(){{
            INSERT_INTO("school.account_role");
            VALUES("account_id", "#{user.id}");
            VALUES("role_id", "#{role.id}");
        }}.toString();
    }

    public String insertUserSql() {
        return new SQL(){{
            // Define SQL
            INSERT_INTO("school.account");
            VALUES("account_name", "#{username}");
            VALUES("password", "#{password}");
        }}.toString();
    }

}
