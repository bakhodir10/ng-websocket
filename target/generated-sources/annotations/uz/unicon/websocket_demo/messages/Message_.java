package uz.unicon.websocket_demo.messages;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uz.unicon.websocket_demo.user.User;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Message.class)
public abstract class Message_ extends uz.unicon.websocket_demo.base.BaseEntity_ {

	public static volatile SingularAttribute<Message, User> receiver;
	public static volatile SingularAttribute<Message, User> sender;
	public static volatile SingularAttribute<Message, Date> receivedTime;
	public static volatile SingularAttribute<Message, Date> sentTime;
	public static volatile SingularAttribute<Message, String> text;
	public static volatile SingularAttribute<Message, Boolean> seen;

}

