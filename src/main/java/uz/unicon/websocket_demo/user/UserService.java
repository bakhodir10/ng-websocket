package uz.unicon.websocket_demo.user;


import java.security.Principal;

public interface UserService {
    User findByUserName(String userName);
    Iterable<User> findAll();
    User findOne(Long id);
    User makeFriend(Long telNumber, Principal principal);
}
