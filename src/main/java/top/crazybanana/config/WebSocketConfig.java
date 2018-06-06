package top.crazybanana.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
//        普通模式
//        registry.enableSimpleBroker("/topic");

        // Use this for enabling a Full featured broker like RabbitMQ
        registry.enableStompBrokerRelay("/topic")
                .setRelayHost("192.168.127.99")
                .setRelayPort(61613)
                .setClientLogin("test")
                .setClientPasscode("test");
    }
}
