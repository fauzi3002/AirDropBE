package AirDropBE.AirDrop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Mengaktifkan broker internal untuk broadcast pesan kembali ke klien
        config.enableSimpleBroker("/topic");
        
        // Prefix untuk arah pesan dari klien masuk ke controller backend (/app/...)
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint koneksi utama yang akan ditembak oleh React
        registry.addEndpoint("/ws-airdrop")
                .setAllowedOriginPatterns("*") // Izinkan semua koneksi dari HP & Laptop di jaringan lokal
                .withSockJS(); // Fallback jika browser HP versi lama tidak support websocket murni
    }
}