package uz.unicon.websocket_demo.user;



public interface UserService {
    User findByUserName(String userName);
    Iterable<User> findAll();
    User findOne(Long id);
}
