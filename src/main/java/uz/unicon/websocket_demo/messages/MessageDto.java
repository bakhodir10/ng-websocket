package uz.unicon.websocket_demo.messages;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
    private String text;
    private Long receiverId;
}
