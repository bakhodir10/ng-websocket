package uz.unicon.websocket_demo.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IncomingMessage {
    private String text;
    private Long receiverId;
    private Date sentTime = new Date();
}
