import java.io.Serializable;

public class Departamento implements Serializable{
int numeroDepartamento ;
String nombre;
String localidad;
Departamento(int numeroDepartamento ,
String nombre,
String localidad){
	this.numeroDepartamento=numeroDepartamento;
	this.nombre = nombre;
	this.localidad=localidad;
}
int getnumeroDepartamento(){return numeroDepartamento;}
String getnombre (){return nombre;}
String getlocalidad(){return localidad;}
void setnumeroDepartamento(int numeroDepartamento){ this.numeroDepartamento=numeroDepartamento;}
void setnombre (String nombre){this.nombre=nombre;}
void setlocalidad(String localidad){this.localidad=localidad;}
}
