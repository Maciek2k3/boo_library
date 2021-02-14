package com.kodillatask.library.controller;

import com.kodillatask.library.domian.Users;
import com.kodillatask.library.domian.UsersDto;
import com.kodillatask.library.mapper.UsersMapper;
import com.kodillatask.library.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v1")
@CrossOrigin(origins = "*")
public class UsersController {
    private UsersMapper usersMapper;
    private UsersService usersService;

    @Autowired
    public UsersController(UsersMapper usersMapper, UsersService usersService) {
        this.usersMapper = usersMapper;
        this.usersService = usersService;
    }
    @GetMapping("/getUsers")
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersService.findAllUsers();
        return usersMapper.mapToUsersList(users);
    }

    @GetMapping("/getUser")
    @ResponseBody
    public UsersDto getByIdUser(@RequestParam long id) throws NotFoundEeption {
        return usersMapper.mapToUsersDto(usersService.findUserById(id).orElseThrow(NotFoundEeption::new));
    }


    @DeleteMapping("/deleteUser")
    public void deleteByIdUser(@RequestParam long id) {
        usersService.deleteUserById(id);
    }

    @PutMapping("/updateUser")
    public UsersDto udpateUser(@RequestBody UsersDto usersDto) {
        Users user = usersMapper.mapToUsers(usersDto);
        Users savedUser = usersService.saveUser(user);
        return usersMapper.mapToUsersDto(savedUser);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UsersDto usersDto) {
        Users users = usersMapper.mapToUsers(usersDto);
        usersService.saveUser(users);
    }


}
