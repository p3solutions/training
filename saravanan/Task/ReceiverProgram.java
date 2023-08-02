

import java.io.*;

import java.net.*;

 

public class ReceiverProgram {

    public static void main(String[] args) {

        try {

            int receiverPort = 52545;
            ServerSocket serverSocket = startReceiver(receiverPort);
            System.out.println("Receiver program is listening on port " + receiverPort);
            Socket socket = acceptConnection(serverSocket);
            Object receivedObject = receiveObject(socket);
            processReceivedObject(receivedObject);
            sConnection(socket, serverSocket);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ServerSocket startReceiver(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        return serverSocket;
ServerSocket.close();
    }
    public static Socket acceptConnection(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();
        return socket;
Socket.close();
    }
    public static Object receiveObject(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Object receivedObject = inputStream.readObject();
        inputStream.close();
        return receivedObject;
    } 
    public static void processReceivedObject(Object receivedObject) {
        if (receivedObject instanceof String[]) {
            String[] namesList = (String[]) receivedObject;
            System.out.println("List of names received:");
            for (String name : namesList) {
                System.out.println(name);
            }
        } else {
            System.out.println("Error: Invalid data format received.");
        }

    }

	}