
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Serializable {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5056);
        Socket s;
        while ((s = ss.accept()) != null) {
            try {
                //s = ss.accept(); 
                System.out.println("A new client is connected : " + s);
                ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream os = new ObjectInputStream(s.getInputStream());
                System.out.println("Assigning new thread for this client");
                Thread t = new ClientHandler(s, os, dos);
                System.out.println("yeeehoooo");
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
        ss.close();
    }
}
