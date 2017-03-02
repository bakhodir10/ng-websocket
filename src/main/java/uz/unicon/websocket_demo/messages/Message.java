package uz.unicon.websocket_demo.messages;


import lombok.*;
import uz.unicon.websocket_demo.base.BaseEntity;
import uz.unicon.websocket_demo.user.User;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "messages")
public class Message extends BaseEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "seen")
    private Boolean seen = Boolean.TRUE;

    @Column(name = "sent_time")
    private Date sentTime = new Date();

    @Column(name = "received_time")
    private Date receivedTime;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
}
