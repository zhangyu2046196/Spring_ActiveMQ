package com.youyuan;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author zhangy
 * @version 1.0
 * @description spring整合activemq的生产者  消息模型是队列
 * @date 2019/12/26 21:01
 */
@Service
public class JmsProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取当前对象
        JmsProducer jmsProducer = (JmsProducer) applicationContext.getBean("jmsProducer");
        //发送消息
        jmsProducer.jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("spring整合activemq消息");
                return textMessage;
            }
        });


        System.out.println("生产者发送消息完成");
    }
}
