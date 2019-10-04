import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Create
{


	public static void main(String[] args) {
		Create create;
		Departamento dep = new Departamento();
		try {
		File file = new File("departamento.dat");
		if(file.exists()== true)
		{
			create = new Create (file);
		}
		else{file.createNewFile();
		create = new Create (file);
		}
		create.write(dep,file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	private void write(Departamento dep,File file){
		RandomAccessFile raf = new RandomAccessFile(file, "w");
		raf.write(dep.getNum());
		raf.write(dep.getName());
	}
	private void modify(String s,File file) throws FileNotFoundException{
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		while 
	}
	
	
}

