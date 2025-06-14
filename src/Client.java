import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public void run() throws Exception {
        int port=8010;
        InetAddress address= InetAddress.getByName("localhost");
        Socket socket= new Socket(address,port);
        try{
            PrintWriter toServer=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader fromServer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toServer.println("Hello from client "+socket.getInetAddress());
            System.out.println(fromServer.readLine());
            toServer.close();
            fromServer.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Client client=new Client();
        client.run();
    }

}
