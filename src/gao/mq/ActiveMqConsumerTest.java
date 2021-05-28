package gao.mq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * <b>ActiveMQ 学习消费者</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/7/9 16:50
 */
public class ActiveMqConsumerTest {
    /**
     *Topic 订阅模式，监听器接收，该消费者要在生产者发布消息是保持连接（保持在线、运行状态）。除非增加持久化
     * @throws JMSException
     */
    @Test
    public void topicConsumerListenerTest() throws JMSException {
        //创建连接工厂，默认端口61616，使用tcp 连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //创建连接对象
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("clientId_1");
        //连接消息中间件
        connection.start();
        //创建session，是否开启事务，设置应答模式
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        //持久化需要制定clientID
        //创建主题，发布订阅测试
        Topic topic = session.createTopic("topic");
        //创建订阅者，并起名
        TopicSubscriber client_subscriber = session.createDurableSubscriber(topic, "client_Subscriber");
        client_subscriber.setMessageListener(message -> {
            if (message instanceof TextMessage){
                TextMessage textMessage = (TextMessage) message;
                try {
                    //应答
                    textMessage.acknowledge();
                    System.out.println("接收到消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        client_subscriber.close();
        session.close();
        connection.close();
        //防止程序结束
//        while (true){
//
//        }
//        MessageConsumer consumer = session.createConsumer(topic);
        //监听器接收模式
//        consumer.setMessageListener(message -> {
//            if(message instanceof TextMessage){
//                TextMessage textMessage = (TextMessage) message;
//                try {
//                    System.out.println(textMessage.getText());
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
    /**
     * Topic 订阅模式，receive接收
     * @throws JMSException
     */
    @Test
    public void topicConsumerTest() throws JMSException {
        Connection connection = getConnection();
        //创建session，是否开启事务，设置应答模式。默认自动应答
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建主题，topic 是PB模式，发布订阅模式。Queue是P2P 点对点模式
        Topic topic = session.createTopic("topic");
        MessageConsumer consumer = session.createConsumer(topic);
        int i=0;
        do {
            i++;
            //接收，每次接收一个
            TextMessage receive = (TextMessage) consumer.receive();
            String text = receive.getText();
            if ("消息2".equals(text)) {
                receive.acknowledge();
                System.out.println(text);
            } else {
                //消息默认可以重发6次 可以修该配置
                session.recover();
                System.out.println("失败重发");
            }
        } while (i<100);
    }

    /**
     * Queue队列,点对点，receive接收
     * @throws JMSException
     */
    @Test
    public void queueConsumerTest() throws JMSException {
        Connection connection = getConnection();
        //创建session，是否开启事务，设置应答模式。默认自动应答
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列。是Queue是P2P 点对点模式。
        Queue message = session.createQueue("message");
        MessageConsumer consumer = session.createConsumer(message);
        while (true) {
            TextMessage receive = (TextMessage) consumer.receive();
            String text = receive.getText();
            if ("queueMessage".equals(text)) {
                receive.acknowledge();
                System.out.println(text);
            } else {
                session.recover();
                System.out.println("失败重发");
            }
        }
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
