package com.example.APICreation;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    Map<Integer , Users> users = new HashMap<>();

    @GetMapping("/get__users")
    public List<Users> getUsers(){
        List<Users> ans = new ArrayList<>();
        for(Users u : users.values()){
            ans.add(u);
        }

        return ans;
    }

    @PostMapping("/add__users")
    public void createUser(@RequestParam("id") int id ,
                           @RequestParam("name") String name ,
                           @RequestParam("country") String country ,
                           @RequestParam("age") int age){
        Users user = new Users(id , name , country , age);

        users.put(id , user);
    }

    @PutMapping("/update__users")
    public boolean updateUsers(@RequestParam("id") int id ,
                            @RequestParam("name") String name ,
                            @RequestParam("country") String country ,
                            @RequestParam("age") int age){

        if(!users.containsKey(id)){
            System.out.println("Sorry! the user doesn't exist in the database");
            return false;
        }
        else{
            Users user = new Users(id , name , country , age);
            users.put(id , user);
        }
        return true;
    }

    @DeleteMapping("delete__users")
    public boolean deleteUsers(@RequestParam("id") int id){
        if(!users.containsKey(id)){
            System.out.println("Sorry ! this user doesn't exist in the database...");
            return false;
        }
        else{
            users.remove(id);
        }
        return true;
    }

}
