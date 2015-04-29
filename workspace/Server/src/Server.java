/*
 * Moret Jérôme 
 * 29 avr. 2015
 * 
 * 
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jérôme
 */
public class Server {

    private int port;
    private boolean shouldRun;
    private ServerSocket serverSocket;
    private Thread serverThread;
    

    public Server(int port) {
        this.port = port;
        
        try {
            serverSocket = new ServerSocket(port);
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                shouldRun = true;
                while (shouldRun) {
                    try {
                        System.out.println("Listening for client connection on " + serverSocket.getLocalSocketAddress());
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("New client has arrived ...");
                        ClientWorker worker = new ClientWorker(clientSocket);
                        System.out.println("Delegating work to client worker...");
                        Thread clientThread = new Thread(worker);
                        clientThread.start();
                    } catch (IOException ex) {
                        System.out.println("IOException in main server thread, exit: " + ex.getMessage());
                        shouldRun = false;
                    }
                }
            }
        });
        serverThread.start();
    }
    
    public void stopServer() throws IOException {
        shouldRun = false;
        serverSocket.close();
    }
    
    public static void main(String[] args) {
        final int PORT = 7777;
        Server server = new Server(PORT); 
    }

}