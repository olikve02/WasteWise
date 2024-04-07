package com.Dat109.WasteWise.Repositories;


import com.Dat109.WasteWise.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    User findByEmail(String email);


}