import java.io.*;

public class JavaTextCopy {
    public static void main(String[] args) {
    try{   
        if(args.length != 2){
            System.out.println("Usage : JavaTextCopy <source file> <Destination file>");
            System.exit(1);
        }
          
        File f = new File(args[0]);
        File Des = new File(args[1]);
        
        FileInputStream fin = new FileInputStream(f);   
        FileOutputStream fout = new FileOutputStream(Des);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        PrintWriter pout = new PrintWriter(fout);
        
        String msg;
        while ((msg = br.readLine()) != null ){
            pout.print(msg);
        }
        pout.flush();
        fin.close();
        fout.close();
    
    }catch(Exception e){ System.out.println("Usage : JavaTextCopy <source file> <Destination file>"); }
  
    }
    
}