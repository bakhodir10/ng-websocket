package uz.unicon.websocket_demo.example.high;


import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MarcoController {

    @SubscribeMapping(value = "/marco")
    public Shout handShout(Shout incomingMessage) {
//        MessageSendingOperations operations = new SimpMessagingTemplate("");
//        SimpleMessaginTemplate
        System.out.println(incomingMessage.getText());
        return new Shout("salom");
    }
}
