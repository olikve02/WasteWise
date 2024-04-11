package com.Dat109.WasteWise.Controllers;

import com.Dat109.WasteWise.Entities.User;
import com.Dat109.WasteWise.Services.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    /*
    Controller for the screen with all the users.
     */
    @GetMapping("/user-list")
    public String homeScreen(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "OurUsers";
    }

    /*
    Login Form
     */
    @GetMapping("/login")
    public String login(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session, RedirectAttributes ra) {

        if(userService.userExists(email)) {
            User user = userService.fetchUser(email);
            session.setAttribute("user", user);
            return "redirect:home";
        } else {
            return "loginForm";
        }


    }








    @GetMapping("/register/new")
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "RegisterUser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, HttpSession session) {
        // Save the user
        userService.saveUser(user);

        // Set the user in the session
        session.setAttribute("user", user);
        // Use a redirect to prevent duplicate submissions
        return "redirect:/home";
    }



    // Used to pre-populate a users information when we press the update button
    @GetMapping("/user/edit")
    public String editUser(@RequestParam("userId") int userId, Model model) {

        // Get user from the service
        User user = userService.findUserById(userId);

        // set user in the model to prepopulate the form
        model.addAttribute("user", user);
        // send over to the form

        return "EditUser";
    }


    // Deletes the user.
    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int userId) {

        // Delete the user
        userService.deleteById(userId);

        // Redirect to the OurList page
        return "redirect:/user-list";
    }
}