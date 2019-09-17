package process;

public class sum {

public static void main(String [] args) {
		int x = 0;
		try {
		for (int i = 0;args.length>=1;i++){x+=Integer.parseInt(args[i]);}
		System.out.print(x);
		}catch(Exception e){}
	}

}
