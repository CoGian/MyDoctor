import java.io.*;
public class Serialization {
	
	public static void SaveToFile(Registry reg)
	{
		
		try {
			FileOutputStream fileOut = new FileOutputStream("Registry.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(reg);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("finally")
	public static  Registry  ReadFromFile()
	{
		Registry reg = null ; 
		try {
			FileInputStream fileIn = new FileInputStream("Registry.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
		    reg = (Registry) in.readObject();				
			in.close();
			fileIn.close();	
			
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			
			return reg ;
		}
	}
	

}
