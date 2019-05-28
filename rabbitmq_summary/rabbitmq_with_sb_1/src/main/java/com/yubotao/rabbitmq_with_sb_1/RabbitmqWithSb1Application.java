package com.yubotao.rabbitmq_with_sb_1;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RabbitmqWithSb1Application {

	//===============以下是验证topic Exchange的队列==========
	@Bean
	public Queue queueMessage(){
		return new Queue("topic.message");
	}

	@Bean
	public Queue queueMessages(){
		return new Queue("topic.messages");
	}
	//===============以下是验证topic Exchange的队列==========

	@Bean
	TopicExchange exchange(){
		return new TopicExchange("exchange");
	}

	/**
	 * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
	 * @param queueMessage
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}

	/**
	 * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
	 * @param queueMessages
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange){
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqWithSb1Application.class, args);
	}
}
