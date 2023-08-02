import java.util.Scanner;
import java.io.*;
import java.net.*;

public class SenderProgram {
    public static void main(String[] args) {
        try {
            String receiverIp = "localhost";
            int receiverPort = 52545;

            String[] listOfNames = getUserInput();
            sendDataToReceiver(receiverIp, receiverPort, listOfNames);

            System.out.println("Data sent successfully to the Receiver.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] listOfNames = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            listOfNames[i] = sc.nextLine();
        }

        sc.close();
        return listOfNames;
    }

    public static void sendDataToReceiver(String receiverIp, int receiverPort, String[] data) throws IOException {
        Socket socket = new Socket(receiverIp, receiverPort);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(data);
        outputStream.close();
        socket.close();
    }
}
