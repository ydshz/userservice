package com.socialnetwork.userservice.config;

import com.socialnetwork.userservice.rabbit.UserserviceServer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class RabbitConfig {
    private static class ServerConfig {
        @Bean
        public Queue queue(){
            return new Queue("socialmedia.rpc.requests");
        }

        @Bean
        public DirectExchange exchange() {
            return new DirectExchange("socialmedia.rpc");
        }

        @Bean
        public Binding binding(DirectExchange exchange, Queue queue){
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with("rpc");
        }

        @Bean
        public UserserviceServer server() {
            return new UserserviceServer();
        }
    }
}
