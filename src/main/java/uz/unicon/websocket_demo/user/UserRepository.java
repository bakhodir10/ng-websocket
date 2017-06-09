package uz.unicon.websocket_demo.user;


import uz.unicon.websocket_demo.base.BaseRepository;

public interface UserRepository extends BaseRepository<User> {
    User findByUsername(String userName);
    User findByNumber(Long number);
}
