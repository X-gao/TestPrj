package gao.mq;



import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * <b>消息队列学习生产者</b></br>
 *
 * @Company 子虚</br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/7/9 16:14
 */
public class ActiveMqProducerTest {
    /**
     * topic  发布订阅模式，订阅者（消费者）需要保持连接，才能消费
     * @throws JMSException
     */
    @Test
    public void topicMqTest() throws JMSException {

        Connection connection = getConnection();
        //创建session，是否开启事务，设置应答模式。默认自动应答
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        //创建主题，topic 是PB模式，发布订阅模式。Queue是P2P 点对点模式
        Topic topic = session.createTopic("topic");
        MessageProducer producer = session.createProducer(topic);
        //消息传送模式，持久的，非持久的，默认持久。持久化消息
//        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //持久化存活时间。持久化的相关设置可以单独使用producer.setDeliveryMode、setTimeToLive等，还可以在发送时send方法增加持久化
//        producer.setTimeToLive(1000*10);
        TextMessage message = session.createTextMessage("生产者的消息2");
        //消息，持久化，优先级，持久化有效时间
        //,DeliveryMode.PERSISTENT,1,1000*60
        producer.send(message,DeliveryMode.PERSISTENT,1,1000*20);
        //持久化方式发送消息
///        producer.send(message,DeliveryMode.PERSISTENT,1,1000*10);
        System.out.println("生产者生产消息："+message.getText());
        //发送消息后需要关闭，否则可能造成消息丢失
        producer.close();
        session.close();
        connection.close();
    }

    @Test
    public void queueMqTest() throws JMSException, InterruptedException {
        Connection connection = getConnection();
        //创建session，是否开启事务，设置应答模式。默认自动应答
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建消息队列
        Queue queue = session.createQueue("message");
        MessageProducer producer = session.createProducer(queue);
        //消息传送模式，持久的，非持久的，默认持久。持久化消息
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //测试发送消息100次
        int messageCount = 3;
        for (int i = 0; i < messageCount; i++) {
            TextMessage message = session.createTextMessage("消息"+i);
            producer.send(message);
            Thread.sleep(1000);
            System.out.println("生产者生产消息："+message.getText());
        }
        //发送消息后需要关闭，否则可能造成消息丢失
        producer.close();
        session.close();
        connection.close();
    }
    Connection getConnection() throws JMSException {
        //创建连接工厂，默认端口61616，使用tcp 连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //创建连接对象
        Connection connection = connectionFactory.createConnection();
        //连接消息中间件
        connection.start();
        return connection;
    }
}
