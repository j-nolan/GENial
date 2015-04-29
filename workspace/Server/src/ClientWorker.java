/*
 * Moret Jérôme 
 * 29 avr. 2015
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jérôme
 */
public class ClientWorker implements Runnable {
    private Socket socket;
    BufferedReader reader;
    PrintWriter writer;

    public ClientWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true) {
            writer.println("Salut James !");
            writer.flush();
        }
    }
    
    
}