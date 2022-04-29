package games.linkin.dao;

import games.linkin.pojo.People;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PeopleDao")
public interface PeopleDao {

    @Select("select * from people")
    @ResultMap("peopleResultMap")
    List<People> selectAll();

    @Insert("insert into people values (null,#{name},#{sex},#{cardId},#{covidTest},#{vaccination})")
    void add(People people);

    @Delete("delete from people where id = #{id}")
    void delete(String id);

    @Update("update people set name = #{name},sex=#{sex},card_id=#{cardId},covid_test=#{covidTest},Vaccination=#{vaccination} where id = #{id}")
    void update(People people);

    void deleteByIds(@Param("ids") int[] ids);

    @Select("select * from people limit #{begin},#{size}")
    @ResultMap("peopleResultMap")
    List<People> selectByPage(@Param("begin")int begin,@Param("size")int size);

    @Select("select count(*) from people")
    int selectTotalcount();

    @Select("select * from people where card_id=#{cardId}")
    @ResultMap("peopleResultMap")
    People selectByCardId(@Param("cardId")String cardId);
}
