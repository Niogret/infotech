package sender;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueConnectionFactory;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySender {

	public static void main(String[] args) {
		
		try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			// connection au message broker
			QueueConnection connection = factory.createQueueConnection();
			// ouvrir session sans transaction (1 seul message) et acquitement automatique
			QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();
			// créer et envoyer message
			TextMessage message = session.createTextMessage("Queue Message");
			QueueSender sender = session.createSender(queue);
			sender.send(message);
			
			session.close();
			connection.close();
			
			
			TopicConnectionFactory factory2 = (TopicConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Topic topic = (Topic) applicationContext.getBean("topic");
			// connection au message broker
			TopicConnection connection2 = factory2.createTopicConnection();
			// ouvrir session sans transaction (1 seul message) et acquitement automatique
			TopicSession session2 = connection2.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			connection2.start();
			// créer et envoyer message
			TextMessage message2 = session2.createTextMessage("Topic Message");
			TopicPublisher publisher = session2.createPublisher(topic);
			publisher.send(message2);
			
			
			session2.close();
			connection2.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}



	}

}
