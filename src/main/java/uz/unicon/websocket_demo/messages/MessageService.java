package uz.unicon.websocket_demo.messages;


import uz.unicon.websocket_demo.base.BaseService;

import java.awt.print.Pageable;
import java.security.Principal;

public interface MessageService extends BaseService<Message>{
    Message create(IncomingMessage message, Principal principal);
    Iterable<Message>findAll(Long receiverId, Principal principal);
}
