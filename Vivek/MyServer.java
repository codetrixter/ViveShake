import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

    public static void main(String[] args) {
        connectToServer();
    }

    private static void connectToServer() {
        //Try connect to the server on an unused port eg 9991. A successful connectin will return a socket
        try(ServerSocket serverSocket = new ServerSocket(9991)) {

            Socket connectionSocket = serverSocket.accept();

            //Create I/O streams for the connection
            InputStream inputToServer = connectionSocket.getInputStream();
            OutputStream outputFromServer = connectionSocket.getOutputStream();

            Scanner scanner = new Scanner(inputToServer, "UTF-8");
            PrintWriter serverPrintOut = new PrintWriter(
                new OutputStreamWriter(outputFromServer, "UTF-8"), true
            );

            serverPrintOut.println("Hello World! Enter Peace to exti.");

            //Have the server take input from the client and echo it back
            //This should be placed in a loop that listens for a terminator text e.g. by

            boolean done = false;

            while(!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                serverPrintOut.println("Echo from Vivek Server: "+line);

                if(line.toLowerCase().trim().equals("peace")) {
                    done = true;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    
}
