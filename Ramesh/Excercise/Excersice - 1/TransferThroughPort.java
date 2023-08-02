import java.io.IOException;

import java.net.InetAddress;

import java.net.ServerSocket;

import java.net.UnknownHostException;

 

public class TransferThroughPort {

    public static void main(String[] args) {

        ip();

        port();

    }

        public static void ip() {

            try {

                InetAddress localHost = InetAddress.getLocalHost();

                String ipAddress = localHost.getHostAddress();

                System.out.println("IP Address: " + ipAddress);

            } catch (UnknownHostException e) {

                e.printStackTrace();

            }

        }

            

            

             public static void port() {

                try {

                    ServerSocket serverSocket = new ServerSocket(0);

                    int port = serverSocket.getLocalPort();

                    serverSocket.close();

                    System.out.println("Port: " + port);

                } catch (IOException d) {

                    d.printStackTrace();

                }

        }

            

}