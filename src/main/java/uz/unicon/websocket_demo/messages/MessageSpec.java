package uz.unicon.websocket_demo.messages;


import org.springframework.data.jpa.domain.Specification;
import uz.unicon.websocket_demo.user.User_;

public abstract class MessageSpec {
    public static Specification<Message> findAll(Long receiverId, Long senderId) {
        return (root, criteriaQuery, cb) -> cb.or(
                cb.and(cb.equal(root.get(Message_.sender).get(User_.id), senderId),
                        cb.equal(root.get(Message_.receiver).get(User_.id), receiverId)),
                cb.and(cb.equal(root.get(Message_.sender).get(User_.id), receiverId),
                        cb.equal(root.get(Message_.receiver).get(User_.id), senderId))
        );
    }
}
