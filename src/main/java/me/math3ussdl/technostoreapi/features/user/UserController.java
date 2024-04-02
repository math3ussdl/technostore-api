package me.math3ussdl.technostoreapi.features.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import me.math3ussdl.technostoreapi.features.user.dto.UserCreateDto;
import me.math3ussdl.technostoreapi.features.user.dto.UserDto;

@Controller
public class UserController {

    @Autowired
    private UserService service;
    
    @QueryMapping
    public List<UserDto> getUsers() {
        return service.getUsers();
    }

    @QueryMapping
    public Optional<UserDto> getUserById(@Argument UUID id) {
        return service.getUser(id);
    }

    @MutationMapping
    public UserDto createUser(@Argument UserCreateDto user) throws Exception {
        return service.createUser(user);
    }

    @MutationMapping
    public UserDto updateUser(@Argument UserDto user) throws Exception {
        return service.updateUser(user);
    }

    @MutationMapping
    public boolean deleteUserById(@Argument UUID id) {
        return service.deleteUser(id);
    }
}
