import java.io.*;
import java.net.*;

public class Client {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 5000);

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msgin = "", msgout = "";

            while (!msgin.equals("exit")) {
                msgout = br.readLine();
                dout.writeUTF(msgout);
                dout.flush();

                msgin = din.readUTF();
                System.out.println("Server: " + msgin);
            }

            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}