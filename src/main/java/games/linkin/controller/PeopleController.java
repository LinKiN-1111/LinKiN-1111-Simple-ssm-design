package games.linkin.controller;

import games.linkin.pojo.People;
import games.linkin.pojo.PeopleBean;
import games.linkin.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @PostMapping
    public boolean add(@RequestBody People people){
        peopleService.add(people);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        peopleService.deleteById(id);
        return true;
    }

    @DeleteMapping
    public boolean deletes(@RequestBody int[] ids){
        peopleService.deleteByIds(ids);
        return true;
    }

    @PutMapping
    public boolean update(@RequestBody People people){
        peopleService.update(people);
        return true;
    }

    @GetMapping("/{currentPage}/{pageSige}")
    public PeopleBean selectByPage(@PathVariable int currentPage,@PathVariable int pageSige){
        PeopleBean peopleBean = peopleService.selectByPage(currentPage,pageSige);
        return peopleBean;
    }

    @GetMapping("/cardId/{cardId}")
    public PeopleBean selectByCardId(@PathVariable String cardId){
        PeopleBean people = peopleService.selectByCardId(cardId);
        return people;
    }

}
