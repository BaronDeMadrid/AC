import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Departamentos {

	public static void main(String[] args) {
		
		File bin = new File( System.getProperty("user.home")+"/bin/departamento.dat");
		Departamentos departamento =new Departamentos();
		try {
			bin.createNewFile();
		
		Properties configuracionProps = new Properties();
		
		String nombreArchivo = null;
		try {

		  configuracionProps.load(new FileInputStream(System.getProperty("user.home")
				  +"/bin"+"configuracion.props"));
		  nombreArchivo = configuracionProps.getProperty("nombrearchivo");
		  ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream
				  (new File(System.getProperty("user.home")+"/bin"+nombreArchivo)));
		  oos.writeObject(departamento);
		
		  oos.close();
		  
		  ObjectInputStream ois = new ObjectInputStream(new FileInputStream
				  (new File(System.getProperty("user.home")+"/bin/"+nombreArchivo)));
		 Departamentos obj = (Departamentos) ois.readObject();
		 System.out.println(obj.);
		  ois.close();
		}catch(Exception e ){}

}}
