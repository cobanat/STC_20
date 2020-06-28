package homework.part1.lesson10.client;

import homework.part1.lesson10.Listener;
import homework.part1.lesson10.server.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 27.05.2020
 */
public class Client {
    public static final Integer CLIENT_PORT = 6227;

    public static void main(String[] args) {

        Listener listenerThread = new Listener(CLIENT_PORT);
        listenerThread.start();

        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(10));
        DatagramSocket socket;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String message = scanner.nextLine();
                byte[] data = message.getBytes();
                InetAddress addr = InetAddress.getByName("127.0.0.1");
                socket = new DatagramSocket();
                DatagramPacket packet = new DatagramPacket(data, data.length, addr, Server.SERVER_PORT);
                socket.send(packet);
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
