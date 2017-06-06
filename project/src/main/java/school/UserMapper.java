package school;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import school.AutoUser;

import java.util.List;

public interface UserMapper

{
    @Select("SELECT * from user WHERE email = #{email}")
    AutoUser findByEmail(String email);

    @Select("SELECT * from user")
    List<AutoUser> findAll();

    @Insert("INSERT into user (email,name,password,surname) values (#{email}, #{name}, #{password}, #{surname})" )
    void saveUser(AutoUser user);

    @Delete("DELETE from user where surname = #{surname}")
    void deleteUser(String surname);
}