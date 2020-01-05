package com.youyuan;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author zhangy
 * @version 1.0
 * @description spring整合activemq消费者
 * @date 2019/12/26 21:36
 */
@Service
public class JmsConsumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) throws JMSException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建消费者
        JmsConsumer jmsConsumer = (JmsConsumer) applicationContext.getBean("jmsConsumer");
        //消费消息
        String str = (String) jmsConsumer.jmsTemplate.receiveAndConvert();
        System.out.println("消费者接收到的消息是:" + str);
    }

}
