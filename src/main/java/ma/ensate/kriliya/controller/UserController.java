package ma.ensate.kriliya.controller;

import ma.ensate.kriliya.model.User;
import ma.ensate.kriliya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("kriliya/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> get() { return userService.getAllUsers(); }

    @DeleteMapping("users/{id}")
    public void delete(@PathVariable Integer id){
        userService.RemoveUser(id);
    }
}
