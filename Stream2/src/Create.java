import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Base64;

public class Create
{


	public static void main(String[] args) {
		Create create;
		Departamento dep = new Departamento();
		try {
		File file = new File("departamento.dat");
		if(file.exists()!= true)
		file.createNewFile();
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
	private void checksIfExists(String contains,File file,String replace) throws IOException{
		byte [] modify = new byte[20];
		String compare = null;
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		while (raf.getFilePointer()<file.length())
		raf.seek(raf.getFilePointer()+4);
			for(int i = 0 ;i<10;i++)
			{
				modify[i] +=raf.readByte();
			}
			compare = Base64.getEncoder().encodeToString(modify);
		if(contains.contentEquals(compare))
		{
			modify(raf.getFilePointer()-20,replace,file);
		}else{System.out.println("doesn't exist");}
	
	
	}
	void modify (long pointer,String replace,File file) throws IOException{
		RandomAccessFile raf = new RandomAccessFile(file,"w");
		byte[] bytes = replace.getBytes();
		raf.seek(pointer);
		for(int i = 0;i<bytes.length;i++) 
		{
			raf.write(bytes[i]);
		}
	}
	
}

