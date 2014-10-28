package assignment4;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Num1 {

	public static void main(String[] args) throws IOException{
		String hashedPassword = getHashedPassword("pwd1.txt").toLowerCase();
		//String hashedPassword="10653038";
		String hashedMsg;
		String msg;
		String salt="FP";
		try{
			for(int i=0; i<10; i++){
				msg=salt+"000"+Integer.toString(i);
				hashedMsg=sha1(msg); 
					if(hashedPassword.contains(hashedMsg)){
						System.out.println(hashedMsg);
						System.out.println(salt+i);
						System.out.println("Found the password!!");
						break;
					}
			}
			//System.out.println("first try\n");
			
			for(int i=10; i<100; i++){
				msg=salt+"00"+Integer.toString(i);
				hashedMsg=sha1(msg); 
					if(hashedPassword.contains(hashedMsg)){
						System.out.println(hashedMsg);
						System.out.println("Found the password!!");
						System.out.println(salt+i);
						break;
					}
			}
			//System.out.println("second try\n");
				
			for(int i=100; i<1000; i++){
				msg=salt+"0"+Integer.toString(i);
				hashedMsg=sha1(msg); 
					if(hashedPassword.contains(hashedMsg)){
						System.out.println(hashedMsg);
						System.out.println("Found the password!!");
						System.out.println(salt+i);
						break;
					}
			}
			//System.out.println("third try\n");
			
			for(int i=1000; i<10000; i++){
				msg=salt+Integer.toString(i);
				hashedMsg=sha1(msg); 
					if(hashedPassword.contains(hashedMsg)){
						System.out.println(hashedMsg);
						System.out.println("Found the password!!");
						System.out.println(salt+i);
						break;
					}
			}
			//System.out.println("fourth try\n");
		}
		 catch (NoSuchAlgorithmException e) {
		        System.err.println("I'm sorry, but MD5 is not a valid message digest algorithm");
		    }
		//System.out.println(hashedMsg);
		System.out.println(hashedPassword);
		
		return;
		
	}


	public static String sha1(String input) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.reset();
		md.update(input.getBytes());
		byte[] output = md.digest();
		//System.out.println("input is " +input);
		//System.out.println("output is "+ output);
		//for(int x=0; x < output.length; x++){
			//System.out.println("ouput["+x+"] is "+ output[x]);
		//}
		//Byte to hex
		String hex = byteToHex(output);
		//System.out.println(hex);
		return hex;
		
	}	
	
	public static String byteToHex(byte[] bytes){
		StringBuilder sb = new StringBuilder(bytes.length * 2);  
		  
	    @SuppressWarnings("resource")
		Formatter formatter = new Formatter(sb);  
	    for (byte b : bytes) {  
	        formatter.format("%02x", b);  
	    }  
	  
	    return sb.toString();  
	}  
		

	
	public static String getHashedPassword(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try{
			String line = br.readLine();
			String password;
			//System.out.println(line+"\n");
			
			while (line!=null){
				if(line.startsWith("18703116")){
					password = line.substring(11, 51);
					System.out.println(password);
					return password;
				}
				else{
				line=br.readLine();
				//System.out.println(line+"\n");
				}
			}
		} finally {
			br.close();
		}
		return null;
	}
	


}
