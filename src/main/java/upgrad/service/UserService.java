package upgrad.service;

import org.springframework.stereotype.Service;
import upgrad.model.User;

@Service
public class UserService {

    public boolean login(User user) {
        if(user.getUsername().equals("abc")) {
            return true;
        }
        else {
            return false;
        }
    }

}