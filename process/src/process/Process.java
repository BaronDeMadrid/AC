package process;
import java.io.*;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

public class Process {
	public static void main(String [] args) 
	{try {
		ProcessBuilder pb =
				 new ProcessBuilder("java","sum", "4", "6");
				 pb.directory(new File(System.getProperty("user.dir")));
				 File log = new File("log");
				 pb.redirectErrorStream(true);
				 pb.redirectOutput(Redirect.appendTo(log));
				 pb.start();
				 BufferedReader bf =new BufferedReader(new FileReader(new File(
				 System.getProperty("user.dir")+"/log")));
				 while (bf.readLine() != null) {
				 System.out.println(bf.readLine());}
				 bf.close();
				 
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}
