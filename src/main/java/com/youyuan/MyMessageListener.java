package com.youyuan;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author zhangy
 * @version 1.0
 * @description  自定义监听器实现MessageListener
 * @date 2019/12/26 22:15
 */
@Component
public class MyMessageListener implements MessageListener {
    public void onMessage(Message message) {
        if (null!=message && message instanceof TextMessage){
            TextMessage textMessage= (TextMessage) message;
            try {
                System.out.println("生产者发送的消息是:"+textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
