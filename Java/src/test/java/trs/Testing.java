package trs;

import trs.data.User;
import org.junit.Assert;
import org.junit.Before;
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

    @Before
    public void init() {
        this.controller.getPollRepo().deleteAll();
        this.controller.getUserRepo().deleteAll();
    }

    @Test
    public void createUser(){
        Assert.assertTrue(controller.getUserController().createUser("TestUser", "TestPw"));
    }

    @Test
    public void createSameUserTwice(){
        controller.getUserController().createUser("TestUserTwice","TestPw");
        Assert.assertFalse(controller.getUserController().createUser("TestUserTwice", "TestPw"));
    }

    @Test
    public void createUserAndSearchAssertSameName(){
        User user = new User("TestFindUser", "TestPw");
        controller.getUserController().createUser(user);
        Assert.assertEquals("TestFindUser", controller.getUserController().searchUser("TestFindUser").getName());
    }

    @Test
    public void createUserAndSearchAssertSamePassword(){
        User user = new User("TestFindUser", "TestPw");
        controller.getUserController().createUser(user);
        Assert.assertEquals("TestPw", controller.getUserController().searchUser("TestFindUser").getPassword());
    }

    @Test
    public void loginUser(){
        User testUser = new User("TestUser", "TestPw");
        controller.getUserController().createUser(testUser);
        controller.getUserController().login(testUser.getName(),testUser.getPassword());
        Assert.assertEquals(testUser.getName(), controller.getCurrentUser().getName());
    }

    @Test
    public void loginNotExistingUser(){
        controller.getUserController().login("Abc","TestPw");
        Assert.assertNull(controller.getCurrentUser());
    }

    @Test
    public void logoutUser(){
        User testUser = new User("TestUser", "TestPw");
        controller.getUserController().createUser(testUser);
        controller.getUserController().login(testUser.getName(),testUser.getPassword());
        Assert.assertNull(controller.getCurrentUser());
    }



}