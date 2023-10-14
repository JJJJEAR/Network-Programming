import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server implements Runnable {
    
    Socket s = null;
    volatile static HashMap<String , String> map = new HashMap<String , String>();

    public Server(Socket s) { this.s = s; }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            
            String command = br.readLine();
            String studentId;
            String studentName;

            if (command.equals("add")) {
                studentId = br.readLine();
                studentName = br.readLine();
                map.put(studentId, studentName);
                pw.println("OK");    
                pw.flush();
            } else if (command.equals("search")) {   
                studentId = br.readLine();    
                String IdCheck = map.get(studentId);          
                if(IdCheck != null){
                    pw.println(IdCheck); 
                    pw.flush();
                }else{
                    pw.println("N/A");
                    pw.flush();
                }            
            } else {
                System.out.println("Command not found");
            }

            pw.flush();
            pw.close();
            br.close();
            s.close();

        } catch (Exception e) { }
    }

    public static void main(String[] args) {
        ServerSocket serv = null;
        ExecutorService es = Executors.newFixedThreadPool(15);

        try {
            serv = new ServerSocket(23410);

        } catch (Exception e) {
            System.exit(1);
        }

        while (true) {
            try {
                Socket s = serv.accept();
                Server st = new Server(s);
                es.execute(st);
            } catch (Exception e) {
            }
        }
    }
}
