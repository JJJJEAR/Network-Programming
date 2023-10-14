import java.net.*;
import java.util.*;

public class DateTimeServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            Date now = new Date();
            System.out.println("Current Time = " + now.toString());
            while(true){
                byte[] recvBuffer = new byte[8000];
                DatagramPacket dp = new DatagramPacket(recvBuffer, recvBuffer.length);              
                String msg = new String(new Date().toString());
                recvBuffer = msg.getBytes();
                socket.receive(dp);
                System.out.println("Client Connected..");
                DatagramPacket dp2 = new DatagramPacket(recvBuffer,
                                                        recvBuffer.length,
                                                        dp.getAddress(),
                                                        dp.getPort());
                socket.send(dp2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
