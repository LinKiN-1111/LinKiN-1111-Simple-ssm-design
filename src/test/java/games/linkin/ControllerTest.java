package games.linkin;

import games.linkin.config.SpringConfig;
import games.linkin.dao.PeopleDao;
import games.linkin.pojo.People;
import games.linkin.pojo.User;
import games.linkin.service.PeopleService;
import games.linkin.service.UserService;
import games.linkin.service.impl.PeopleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PeopleDao peopleDao;

    @Autowired
    private PeopleService peopleService;

//    @Test
//    public void login(){
//        User user = new User();
//        user.setUsername("linkin");
//        user.setPassword("123123");
//        System.out.println(userService.selectUser(user));
//    }

    @Test
    public void test(){
        People people = new People();
        people.setId(21);
        people.setName("21");
        people.setCovidTest("21");
        people.setCardId("21");
        people.setSex("21");
        people.setVaccination("21");
        int[] id = {17,18,19};
        System.out.println(peopleService.selectByCardId("123123123123123"));
    }

}
