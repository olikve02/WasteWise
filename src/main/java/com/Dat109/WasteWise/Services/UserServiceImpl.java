package com.Dat109.WasteWise.Services;

import com.Dat109.WasteWise.Entities.User;
import com.Dat109.WasteWise.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
    }
    */

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    /*
    private UserDto mapToUserDto(User user) {
        UserDto userDto = UserDto.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .postalCode(user.getPostalCode())
                .city(user.getCity())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        return userDto;
    }

    */



    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }



    @Override
    public User findUserById(int userId) {
        Optional<User> result = userRepository.findById(userId);

        User user = null;
        if(result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not fin the user id - " + userId);
        }
        return user;

    }




    @Override
    public boolean userExists(int userId) {
        return false;
    }

    @Override
    public boolean userExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public User fetchUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }

    /*
    private User mapToUser(UserDto user) {
        User userDto = User.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .postalCode(user.getPostalCode())
                .city(user.getCity())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        return userDto;
    }
    */
}
