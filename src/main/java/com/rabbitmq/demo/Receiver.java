package com.rabbitmq.demo;

import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(4);

  public void receiveMessage(byte[] bytes){
    try{
      System.out.println(new String(bytes, Charset.forName("UTF-8")));
      latch.countDown();
    }catch(Exception e){
      System.err.println(e.getMessage());
    }

  }

  public CountDownLatch getLatch(){
    return latch;
  }
}

