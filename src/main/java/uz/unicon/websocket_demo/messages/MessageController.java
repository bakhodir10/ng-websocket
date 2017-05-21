package uz.unicon.websocket_demo.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
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

    @ResponseBody
    @RequestMapping("/messages")
    public Iterable<Message> findAll(MessageDto dto, Principal principal) {
        return messageService.findAll(dto.getReceiverId(), principal);
    }

    @MessageMapping(value = "/message")
    public void create(IncomingMessage incomingMessage, Principal principal) {
        Message message = messageService.create(incomingMessage, principal);
        simpMessagingTemplate.convertAndSend("/user/" + message.getReceiver().getUsername() + "/queue/private", incomingMessage.getText());
    }
}
