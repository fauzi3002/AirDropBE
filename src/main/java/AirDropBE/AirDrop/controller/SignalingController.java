package AirDropBE.AirDrop.controller;

import AirDropBE.AirDrop.model.SignalMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SignalingController {

    private final SimpMessagingTemplate messagingTemplate;

    // Dependency Injection untuk mengirim pesan secara manual ke broker
    public SignalingController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Klien (React) mengirim data ke: /app/signal/{roomId}
    @MessageMapping("/signal/{roomId}")
    public void handleAirDropSignal(@DestinationVariable String roomId, @Payload SignalMessage message) {
        System.out.println("LOG AirDrop: Menerima tipe [" + message.getType() + "] dari " + message.getSender() + " untuk Room: " + roomId);
        
        // Server meneruskan pesan ke semua perangkat yang subscribe ke /topic/room/{roomId}
        messagingTemplate.convertAndSend("/topic/room/" + roomId, message);
    }
}