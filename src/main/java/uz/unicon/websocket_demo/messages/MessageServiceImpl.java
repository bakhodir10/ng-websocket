package uz.unicon.websocket_demo.messages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.unicon.websocket_demo.base.BaseServiceImpl;
import uz.unicon.websocket_demo.user.User;
import uz.unicon.websocket_demo.user.UserRepository;

import java.security.Principal;
import java.util.Date;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {

    private MessageRepository messageRepository;
    private UserRepository userRepository;

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Message create(IncomingMessage incomingMessage, Principal principal) {
        User sender = userRepository.findByUsername(principal.getName());
        User receiver = userRepository.findOne(incomingMessage.getReceiverId());
        Message message = Message.builder().sender(sender).receiver(receiver).seen(Boolean.FALSE).
                sentTime(new Date()).text(incomingMessage.getText()).build();
        return messageRepository.save(message);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Message> findAll(Long receiverId, Principal principal) {
        User sender = userRepository.findByUsername(principal.getName());
        return messageRepository.findAll(MessageSpec.findAll(receiverId, sender.getId()));
    }
}
