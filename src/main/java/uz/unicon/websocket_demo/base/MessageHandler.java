package uz.unicon.websocket_demo.base;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.support.SimpAnnotationMethodMessageHandler;

public class MessageHandler extends SimpAnnotationMethodMessageHandler {

    public MessageHandler(SubscribableChannel clientInboundChannel, MessageChannel clientOutboundChannel, SimpMessageSendingOperations brokerTemplate) {
        super(clientInboundChannel, clientOutboundChannel, brokerTemplate);
    }

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        System.out.println(message);
    }
}
