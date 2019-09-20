package process;
import java.io.*;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;
import java.util.Properties;

public class Process {

		public static void main(String[] args) {
			try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("file.dat"))); 
			
				dos.write(3);
				dos.writeChars("String");
				DataInputStream dos = new DataOutputStream(new FileOutputStream(new File("file.dat"))); 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			Properties configuracion = new Properties();
			try {
			
			 configuracion.load(new FileInputStream("../AccessRead/configuracion.props"),"Fichero de configuración");
			 String s_name = configuracion.getProperty("name");
			  String s_firstName = configuracion.getProperty("firstName");
			  String s_class = configuracion.getProperty("class");
			  System.out.println(s_name);
			  System.out.println(s_firstName);
			  System.out.println(s_class);
			} catch (FileNotFoundException fnfe ) {  fnfe.printStackTrace(); 
			} catch (IOException ioe) { 
			  ioe.printStackTrace();
			}
			*/

		/*
		try {
		String fileName = null;
		String s_fileNameWithDirectoryFromHome = null;
		File fileNameWithDirectoryFromHome = new File("fileNameWithDirectoryFromHome");
		ProcessBuilder bashLocateFile = new ProcessBuilder("locate ",fileName)
		.bashLocateFile.redirectOutput(Redirect.appendTo(fileNameWithDirectoryFromHome));
		.start();
		
		if (bashLocateFile. != null)
		ProcessBuilder java =
				 new ProcessBuilder("java","sum", "4", "6");
				 java.directory(new File(System.getProperty("user.dir")));
				
				 
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
}}
