package homework.part1.lesson10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 27.05.2020
 */
public class Listener extends Thread{
    private DatagramSocket socket;
    private byte[] data = new byte[256];
    private int port;


    public Listener(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println(message);
                if (message.equals("buy")) {
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
