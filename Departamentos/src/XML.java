import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

public class XML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XStream xs = new XStream();
		Registro registro = new Registro();
		xs.alias("Departamentos", Departamentos.class);
		try {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		xs.addImplicitCollection(Registro.class, "estacion");
		xs.addImplicitCollection(Registro.class, "registro");
		while((registro=(Registro)xs.fromXML(new FileReader("registros.xml")))!= null)
		{
			registros.add(registro);
			registro = null;
		}
		int temperatura = 0;
		int humedad=0;
		for(int i =0;i<registros.size();i++)
		{
			temperatura += registros.get(i).temperatura;
			humedad += registros.get(i).humedad;
		}
		System.out.println("temperatura: "+temperatura/registros.size());
		System.out.println("humedad: "+humedad/registros.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
