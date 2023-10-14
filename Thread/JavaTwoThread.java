import java.io.*;

public class JavaTwoThread implements Runnable {
    int num1;
    int num2;
    int Result = 0;

    public JavaTwoThread(int num1,int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getResult() {
        return Result;
    }

    public void run() {
        for( int i = num1 ; i <= num2 ; i++ ) {
            Result += i;
        }
    }

    public static void main(String[] args) {
        int t = 0;
        JavaTwoThread j1 = new JavaTwoThread(1, 5000);
        JavaTwoThread j2 = new JavaTwoThread(5001, 10000);
        Thread t1 = new Thread(j1);
        Thread t2 = new Thread(j2);
        try {
            t1.start();
            Thread.sleep(5000);
            t2.start();
            Thread.sleep(10000);
            t1.join(); t2.join();
            t = j1.getResult() + j2.getResult();
        } catch(Exception e) { }
        System.out.println("Result = " + t);
    }

}