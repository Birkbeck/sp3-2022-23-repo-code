import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@UtilityClass
public class Server {
    public void main(String... args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: Server <port>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port " + port);
        while (true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress());
            // accept incoming connections
            // create a new thread to handle the connection
            Thread.ofVirtual().start(() -> {
                try (
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // handle the connection
                ) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Received message: " + inputLine);
                        out.println(inputLine);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
