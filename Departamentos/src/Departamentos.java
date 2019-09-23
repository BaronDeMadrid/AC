import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Departamentos {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Departamentos departamentos = new Departamentos();
		departamentos.createsBinWithPropsyDatInHomeDir();
		
		
		//1.
		System.out.println(System.getProperty("user.home")+"/bin/configuracion.props");
		Scanner sc = new Scanner(System.in);
		System.out.println(System.getProperty("user.home"));
		ArrayList<Departamento> departamentos = new ArrayList<>();	
		Departamentos departamento =new Departamentos();
		boolean eliminado = false;
		String binAbsoluteDirOfConfiguracionProps = System.getProperty("user.home")+"/bin/configuracion.props";
		
		try {
		
			Properties configuracionProps = new Properties();
			configuracionProps.load(new FileInputStream(binAbsoluteDirOfConfiguracionProps));
			String nombrearchivo = configuracionProps.getProperty("nombrearchivo");
			String binAbsoluteDirOfDepartamentoDat =  
			System.getProperty("user.home")+"/bin/"+nombrearchivo;
			
			System.out.println(nombrearchivo);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombrearchivo));
		Departamento d1 = new Departamento(2,"a","a");
		oos.writeObject(d1);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
		configuracionProps.getProperty(binAbsoluteDirOfDepartamentoDat)));
		departamentos.add((Departamento)ois.readObject());
		//2
		for(int i = 0;departamentos.size()>i;i++)
		{
			System.out.println(departamentos.get(i).getnumeroDepartamento());
			System.out.println(departamentos.get(i).getnombre());
			System.out.println(departamentos.get(i).getlocalidad());
		}
		System.out.println("poner numero de departamento que desea eliminar");
		//3
		for(int i = 0;departamentos.size()>i;i++)
		{
			if(sc.nextInt()==departamentos.get(i).getnumeroDepartamento())
			{
				System.out.println("numero de departamento");
				departamentos.get(i).setnumeroDepartamento(sc.nextInt());
				System.out.println("nombre");
				departamentos.get(i).setnombre(sc.next());
				System.out.println("localidad");
				departamentos.get(i).setlocalidad(sc.next());
				
			}
		}
		//4
		for(int i = 0;departamentos.size()>i;i++)
		{
			if(sc.nextInt()==departamentos.get(i).getnumeroDepartamento())
			{
			departamentos.remove(i);
			System.out.println("este departamento fue eliminado correctamente");
			eliminado = true;
			break;
			}else {eliminado = false;}
		}
		if(eliminado == false)
		System.out.println("este numero de departamento no existe");
		oos.close();
		sc.close();
		}catch(Exception e ){}
		

}
	void createsBinWithPropsyDatInHomeDir() throws FileNotFoundException, IOException{
		File bin = new File("bin");
		File configuracionProps = new File("configuracion.Props");
		File departamentoDat = new File("departamento.dat");
		String s = null;
		Properties properties = new Properties();
		bin.mkdir();
		properties.setProperty("nombrearchivo", "departamento.dat");
		properties.store(new FileOutputStream(configuracionProps),"conf");
		
		Process chmodoequalsrw = Runtime.getRuntime().exec
				("chmod o=rw bin");
			Process mvFiles = Runtime.getRuntime().exec
				("mv configuracion.props departamentos.dat  bin");
			Process mvDir = Runtime.getRuntime().exec
				("mv bin/ /home/rb"); 
	        
		
		
		
	}	
}

