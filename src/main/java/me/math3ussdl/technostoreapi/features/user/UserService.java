package me.math3ussdl.technostoreapi.features.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import me.math3ussdl.technostoreapi.features.user.dto.UserCreateDto;
import me.math3ussdl.technostoreapi.features.user.dto.UserDto;
import me.math3ussdl.technostoreapi.features.user.internal.User;
import me.math3ussdl.technostoreapi.features.user.internal.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public UserDto createUser(UserCreateDto user) throws Exception {
        User newUser = UserMapper.INSTANCE.userCreateDtoToUser(user);

        if (newUser == null) {
            throw new Exception("Failed to create user!");
        }

        newUser = repository.save(newUser);

        return UserMapper.INSTANCE.userToUserDto(newUser);
    }

    public List<UserDto> getUsers() {
        return UserMapper.INSTANCE.userListToUserDtoList(repository.findAll());
    }

    public Optional<UserDto> getUser(@NonNull UUID id) {
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            return Optional.of(UserMapper.INSTANCE.userToUserDto(user.get()));
        }

        return null;
    }

    public UserDto updateUser(@NonNull UserDto user) throws Exception {
        User updatedUser = UserMapper.INSTANCE.userDtoToUser(user);

        if (updatedUser == null) {
            throw new Exception("Failed to update user!");
        }

        updatedUser = repository.save(updatedUser);

        return UserMapper.INSTANCE.userToUserDto(updatedUser);
    }

    public boolean deleteUser(@NonNull UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}
