package upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import upgrad.model.Post;
import upgrad.model.User;
import upgrad.service.PostService;
import upgrad.service.UserService;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @RequestMapping("users/login")
    public String login(User user) {
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }

//    @RequestMapping(value = "users/login", method= RequestMethod.POST)
//    public String loginUser(User user) {
//        return "redirect:/posts";
//    }

    @RequestMapping(value = "users/logout", method= RequestMethod.POST)
    public String logout(Model model){
        ArrayList<Post> posts=postService.getAllPosts();
        model.addAttribute("posts", posts);

        return "index";
    }


    @RequestMapping(value = "users/registration", method=RequestMethod.POST)
    public String registerUser(User user) {
        return "users/login";
    }

    @RequestMapping(value = "users/login", method=RequestMethod.POST)
    public String loginUser(User user) {
        if(userService.login(user)) {
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }

}
