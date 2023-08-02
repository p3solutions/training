import java.io.*;
import java.net.*;

 

public class ReceiverPrgm{
    public static void main(String[] args) {
        try {
            int receiverPort = 50972;
            ServerSocket serverSocket = startReceiver(receiverPort);

 

            System.out.println("Receiver program is listening on port " + receiverPort);

 

            Socket socket = acceptConnection(serverSocket);

 

            Object receivedObject = receiveObject(socket);

 

            processReceivedObject(receivedObject);

 

            closeConnection(socket, serverSocket);

 

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

 

    public static ServerSocket startReceiver(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        return serverSocket;
    }

 

    public static Socket acceptConnection(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();
        return socket;
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

 

    public static void closeConnection(Socket socket, ServerSocket serverSocket) throws IOException {
        socket.close();
        serverSocket.close();
    }
}