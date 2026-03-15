import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket s = ss.accept();
            System.out.println("Client connected.");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msgin = "", msgout = "";

            while (!msgin.equals("exit")) {
                msgin = din.readUTF();
                System.out.println("Client: " + msgin);

                msgout = br.readLine();
                dout.writeUTF(msgout);
                dout.flush();
            }

            s.close();
            ss.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}