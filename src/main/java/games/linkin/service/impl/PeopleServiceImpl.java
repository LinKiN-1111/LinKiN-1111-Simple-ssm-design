package games.linkin.service.impl;

import games.linkin.dao.PeopleDao;
import games.linkin.pojo.People;
import games.linkin.pojo.PeopleBean;
import games.linkin.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    @Override
    public List<People> selectAll() {
        List<People> peoples = peopleDao.selectAll();
        return peoples;
    }

    @Override
    public boolean add(People people) {
        peopleDao.add(people);
        return true;
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        peopleDao.deleteByIds(ids);
        return true;
    }

    @Override
    public boolean deleteById(String id) {
        peopleDao.delete(id);
        return true;
    }

    @Override
    public boolean update(People people) {
        peopleDao.update(people);
        return true;
    }

    @Override
    public PeopleBean<People> selectByPage(int currentPage, int pageSize) {
        //计算开始索引与查询条目数
        int begin = (currentPage -1)*pageSize;
        int size = pageSize;

        List<People> rows = peopleDao.selectByPage(begin, size);
        int totalCount = peopleDao.selectTotalcount();
        //封装PageBean对象
        PeopleBean<People> pageBean = new PeopleBean<>();
        pageBean.setRow(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    @Override
    public PeopleBean<People> selectByCardId(String cardId) {
        People peopleselect =  peopleDao.selectByCardId(cardId);
        List<People> row = new ArrayList<>();;
        row.add(peopleselect);
        //封装PageBean对象
        PeopleBean<People> pageBean = new PeopleBean<>();
        pageBean.setRow(row);
        pageBean.setTotalCount(1);
        return pageBean;
    }
}
