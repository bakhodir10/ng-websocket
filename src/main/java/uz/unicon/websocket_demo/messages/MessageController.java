package uz.unicon.websocket_demo.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MessageController {

    private SimpMessagingTemplate simpMessagingTemplate;
    private MessageService messageService;

    @Autowired
    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping(value = "/message")
    public void sendMessage(IncomingMessage incomingMessage, Principal principal) {
        Message message = messageService.save(incomingMessage, principal);
        simpMessagingTemplate.convertAndSend("/user/" + message.getReceiver().getUsername() + "/queue/private", incomingMessage.getText());
    }

    @ResponseBody
    @GetMapping(value = "api/users/messages/{receiverId}")
    public Iterable<Message> findAll(@PathVariable Long receiverId, MessageDto dto, Principal principal) {
        return messageService.findAll(receiverId, principal);
    }
}
