import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public void run() throws IOException {
        int port= 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);

        while(true) {
            Socket acceptConnection = socket.accept();
//            acceptConnection.setSoTimeout(10000);
            try {
                PrintWriter toClient = new PrintWriter(acceptConnection.getOutputStream(),true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptConnection.getInputStream()));
                toClient.println("Hello from server" + acceptConnection.getRemoteSocketAddress());
//                toClient.flush();
                System.out.println(fromClient.readLine());
                fromClient.close();
                toClient.close();
                acceptConnection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        try{
            server.run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}