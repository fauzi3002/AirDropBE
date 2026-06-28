package AirDropBE.AirDrop.model;

public class SignalMessage {
    private String type;     // "join", "offer", "answer", "candidate", "leave"
    private String sender;   // ID unik atau nama perangkat (misal: "Laptop-Fauzi")
    private String receiver; // ID perangkat tujuan (opsional, untuk komunikasi privat)
    private String data;     // Payload teks/JSON dari WebRTC
    private String roomId;   // ID jaringan/Wi-Fi untuk mengelompokkan user

    public SignalMessage() {}

    // Getter dan Setter
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getReceiver() { return receiver; }
    public void setReceiver(String receiver) { this.receiver = receiver; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
}