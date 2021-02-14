package com.kodillatask.library.mapper;

import com.kodillatask.library.domian.Order;
import com.kodillatask.library.domian.OrderDto;
import com.kodillatask.library.domian.Users;
import com.kodillatask.library.domian.UsersDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersMapper {
    public Users mapToUsers (final UsersDto users){
        return new Users(users.getId(), users.getUserName(), users.getUserSurname(), users.getAccountDate());//,users.getOrderList());
    }

    public UsersDto mapToUsersDto (final Users users){
        return new UsersDto(users.getId(), users.getUserName(), users.getUserSurname(), users.getAccountDate());//,users.getOrderList());
    }

    public List<UsersDto> mapToUsersList(final List<Users> usersList){
        return usersList.stream().map(this::mapToUsersDto).collect(Collectors.toList());
    }
}

