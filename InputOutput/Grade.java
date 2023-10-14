import java.io.*;

public class Grade{
    public static void main(String []args){	
    	
	try{
	int num = Integer.parseInt(args[0]); 
    	if( num < 0 || num > 100 ){
        	System.out.println("Please enter 0-100 ");
        	System.exit(1);
	}else if(num >= 80){
	System.out.println("A");
	}else if(num >= 70){
	System.out.println("B");
	}else if(num >= 60){
	System.out.println("C");
	}else if(num >= 50){
	System.out.println("D");
	}else{
	System.out.println("F");
	}
	}catch(NumberFormatException ee){System.out.println("Please enter integer number");
	}catch(ArrayIndexOutOfBoundsException e){System.out.println("Please enter your score");}
    	 
}
}