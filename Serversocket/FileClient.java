import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Command not found");
            System.exit(1);
        }

        String command = args[0];
        File file = null;

        if (command.equals("upload") && args.length != 2) {
            System.out.println("error");
            System.exit(1);
        }

        if (command.equals("download") && args.length != 2) {
            System.out.println("error");
            System.exit(1);
        }

        try {
            Socket s = new Socket("127.0.0.1", 6789);
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            PrintWriter pw = new PrintWriter(out);
            
            pw.println(command);
            pw.flush();

            if (command.equals("list")) {
                String filename;
                while((filename = br.readLine()) != null) {
                    System.out.println(filename);
                }
            } else if (command.equals("upload")) {
                String filename = args[1];
                file = new File(filename);

                pw.println(filename);
                pw.flush();

                String response = br.readLine();
                if(response.equals("OK")) {
                    FileInputStream fin = new FileInputStream(file);
                    byte[] buffer = new byte[65536];
                    int size;
                    while((size = fin.read(buffer)) != -1) {
                        out.write(buffer, 0, size);
                    }
                    out.flush();
                    fin.close();
                } else {
                    System.out.println(filename + " not found");
                }
            } else if (command.equals("download")) {
                String filename = args[1];
                file = new File(filename);

                pw.println(filename);
                pw.flush();

                String res = br.readLine();
                if(res.equals("OK")) {
                    FileOutputStream fout = new FileOutputStream(file);
                    byte[] bufferr = new byte[65536];
                    int sizes;
                    while((sizes = in.read(bufferr)) != -1) {
                        fout.write(bufferr, 0, sizes);
                    }
                    fout.close();
                } else {
                    System.out.println(filename + " not found");
                }
            } else {
                String msg = br.readLine();
                System.out.println(msg);
            }
            pw.close();
            in.close();
            out.close();
            s.close();
        } catch (Exception e) { e.printStackTrace(); }
    } 
}