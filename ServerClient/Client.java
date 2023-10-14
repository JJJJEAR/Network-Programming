import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 23410);

            BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());

            String command = args[0].toLowerCase();
            String studentId;
            String studentName;          

            if (command.equals("add")) {
                if (args.length < 3) {
                    System.out.println("Usage: add <student_id> <student_name>");
                    System.exit(1);
                }

                studentId = args[1];
                studentName = args[2];
                
                pw.println(command);
                pw.println(studentId);
                pw.println(studentName); 
                
            } else if (command.equals("search")) {
                if (args.length < 2) {
                    System.out.println("Usage: search <student_id>");
                    System.exit(1);
                }

                studentId = args[1];
                pw.println(command);
                pw.println(studentId);
               
            } else {
                System.out.println("Command not found");
            }
            
            pw.flush();

            String response = br.readLine();
            System.out.println("Result = " + response); 
 
            br.close();
            pw.close();
            s.close();

        } catch (Exception e) {
        }
    }
}
