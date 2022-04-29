package games.linkin.service;

import games.linkin.pojo.People;
import games.linkin.pojo.PeopleBean;

import java.util.List;

public interface PeopleService {

    List<People> selectAll();

    boolean add(People people);

    boolean deleteByIds(int[] ids);

    boolean deleteById(String id);

    boolean update(People people);

    PeopleBean<People> selectByPage(int begin, int size);

    PeopleBean<People> selectByCardId(String cardId);



}
