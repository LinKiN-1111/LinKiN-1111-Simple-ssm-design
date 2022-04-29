package games.linkin.dao;

import games.linkin.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public interface UserDao {

    @Select("select * from user where username=#{username} and password = #{password}")
    public User selectUser(User user);

}
