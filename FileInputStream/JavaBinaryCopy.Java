import java.io.*;

public class JavaBinaryCopy {
    public static void main(String[] args) {
    try{   
        if(args.length != 2){
            System.out.println("Usage : JavaBinaryCopy <source file> <Destination file>");
            System.exit(1);
        }
        
        File f = new File(args[0]);
        File Des = new File(args[1]);       
        int n;
        byte[] b = new byte[16];     
        FileInputStream fin = new FileInputStream(f);   
        FileOutputStream fout = new FileOutputStream(Des);
        
        while((n = fin.read(b)) > 0){          
            fout.write(b,0,n);
        }

        fin.close();
        fout.close();
    
    }catch(Exception e){ System.out.println("Usage : JavaBinaryCopy <source file> <Destination file>"); }
        
    }
    
}