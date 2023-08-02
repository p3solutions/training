import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SenderProgram {
    public static void main(String[] args) {
        int receiverPort = 52545;
        String[] nameOfPerson = userInput();
        sendobject(receiverPort, nameOfPerson);
        System.out.println("Data is sent successfully");
    }

    public static String[] userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of persons: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character after sc.nextInt()
        String[] personName = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name for person " + (i + 1) + ": ");
            personName[i] = sc.nextLine();
        }
        return personName;
    }

    public static void sendobject(int receiverPort, String[] data) {
        try {
            Socket socket = new Socket("localhost", receiverPort);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(data);
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
