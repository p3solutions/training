import java.util.Scanner;
import java.io.*;
import java.net.*;

 

public class Sender {
    public static void main(String[] args) {
        try {
            
            int receiverPort = 50972;

 

            String[] names = getInput();
            sendData( receiverPort, names);

 

            System.out.println("Data sent successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 

    public static String[] getInput() {
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

 

    public static void sendData( int receiverPort, String[] data) throws IOException {
        Socket socket = new Socket("localhost", receiverPort);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(data);
        outputStream.close();
        socket.close();
    }
}