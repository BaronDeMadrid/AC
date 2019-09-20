import java.io.Serializable;

public class Departamento implements Serializable{
int numeroDepartamento ;
String nombre;
String localidad;
Departamento(){
	numeroDepartamento=4;nombre = "roberto";localidad="localidad";
}
int getnumeroDepartamento(){return numeroDepartamento;}
String getnombre (){return nombre;}
String getlocalidad(){return localidad;}
}
