package com.Dat109.WasteWise.Services;

import com.Dat109.WasteWise.Entities.User;

import java.util.List;

public interface UserService {

    // List<UserDto> findAll();

    List<User> findAll();
    User findByEmail(String email);



    void saveUser(User user);

    User findUserById(int userId);

    //void updateUser(User user);

    boolean userExists(int userId);

    boolean userExists(String email);

    User fetchUser(String email);

    void deleteById(int userId);
}