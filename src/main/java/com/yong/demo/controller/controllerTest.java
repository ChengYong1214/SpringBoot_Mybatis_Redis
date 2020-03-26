package com.yong.demo.controller;

import com.yong.demo.pojo.User;
import com.yong.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class controllerTest {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/operation")
    public String operation(Model model){
        List<User> list=userService.selectAllUsers();
        model.addAttribute("userList", list);
        return "operation";
    }


    @RequestMapping("/selectAllUsers")
    @ResponseBody
    public List<User> selectAllUsers(){
        return userService.selectAllUsers();
    }

    @RequestMapping("/selectOneById")
    @ResponseBody
    public User selectOneById(Integer id){
        return userService.selectOneById(id);
    }

    @RequestMapping("/deleteUserById/{id}")
    public String deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "redirect:/operation";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public Integer insertUser(User user){
        return userService.insertUser(user);
    }

    @RequestMapping("/updateUserById/{id}")
    public String updateUserById(@PathVariable Integer id,Model model ){
        User user=userService.selectOneById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        System.out.println("updateUser");
        userService.updateUser(user);
        return "redirect:/operation";
    }
}
