package trs;

import example.data.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import trs.controller.Controller;
import trs.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testing {
    @Autowired
    Controller controller;

    @Test
    public void contextLoads() throws Exception {
        
    }

    @Test
    public void createUser(){
        Controller c = new Controller();
        UserController uc = new UserController(c);
        uc.createUser("TestUser","TestPw");
        Assert.assertEquals(true, uc.createUser("TestUser","TestPw"));
    }

    @Test
    public void createSameUserTwice(){
        Controller c = new Controller();
        UserController uc = new UserController(c);
        uc.createUser("TestUser","TestPw");
        uc.createUser("TestUser","TestPw");
        Assert.assertEquals(false, uc.createUser("TestUser","TestPw"));
    }

    @Test
    public void createUserAndSearch(){
        Controller c = new Controller();
        UserController uc = new UserController(c);
        uc.createUser("TestUser","TestPw");
        Assert.assertEquals("TestUser", uc.searchUser("TestUser"));
    }



}