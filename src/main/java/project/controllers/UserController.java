package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.models.UserEntity;
import project.service.UserServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceInterface userServiceInterface;

    @PutMapping(value = "/updateUserP/{id}")
    public UserEntity updateUserPut (@PathVariable int id , @RequestBody UserEntity user)
    {
        return userServiceInterface.updateUserPut(id,user) ;

    }
    @DeleteMapping(value ="/delete/{Id}" )
    public void deleteUser(@PathVariable int Id) {
        userServiceInterface.deleteUser(Id) ;
    }

    @GetMapping(value = "/getAllUsers")
    public List<UserEntity> getAllUsers()
    {
        return userServiceInterface.getListUsers();

    }

    @GetMapping(value = "getUserById/{id}")
    public UserEntity getUserById(@PathVariable int id)
    {
        return userServiceInterface.getById(id);

    }


    @GetMapping(value = "/getUseerByUN/{un}")
    public UserEntity getUserByUN(@PathVariable String un)
    {
        return userServiceInterface.getUserByUsername(un);

    }


    @PostMapping(value = "/addWTUN")
    public String addUserWTUN(@RequestBody UserEntity user)
    {
        return userServiceInterface.addUserWTUN(user);
    }





}
