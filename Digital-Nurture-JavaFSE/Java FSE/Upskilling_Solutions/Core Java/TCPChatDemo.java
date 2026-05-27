
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPChatDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Mode:");
        System.out.println("1. Run as Server");
        System.out.println("2. Run as Client");
        System.out.print("Enter choice: ");
        int c = sc.nextInt();
        sc.nextLine();

        if (c == 1) {
            runServer(sc);
        } else if (c == 2) {
            runClient(sc);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void runServer(Scanner sc) {
        try {
            System.out.println("Starting Server on port 5000...");
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Waiting for client connection...");
            Socket s = ss.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            Thread r = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Client: " + msg);
                    }
                } catch (Exception e) {
                    System.out.println("Connection closed.");
                }
            });
            r.start();

            System.out.println("Type your messages below:");
            while (true) {
                String msg = sc.nextLine();
                out.println(msg);
            }
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static void runClient(Scanner sc) {
        try {
            System.out.print("Enter server IP (default localhost): ");
            String ip = sc.nextLine();
            if (ip.trim().isEmpty()) ip = "localhost";

            System.out.println("Connecting to server on " + ip + ":5000...");
            Socket s = new Socket(ip, 5000);
            System.out.println("Connected to server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            Thread r = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Server: " + msg);
                    }
                } catch (Exception e) {
                    System.out.println("Connection closed.");
                }
            });
            r.start();

            System.out.println("Type your messages below:");
            while (true) {
                String msg = sc.nextLine();
                out.println(msg);
            }
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
