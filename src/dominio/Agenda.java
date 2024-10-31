package dominio;
import java.util.ArrayList;
public class agenda{
	private String nombre
	private ArrayList<Contacto> lista;
	public Agenda(){
		lista=new ArrayList<>()
		nombre="";
//Nombre es una referencia vacia, no nula
}
	public Contacto buscar(Contacto c){
		int p=lista.inde0f(c);
		if (p==-1)
			return null;
//Si la posicion es -1 entonces devuelve null porque no existe
		else
//El else es opcional
			return lista.get(p);
//Aqui devuelve el nombre de la posicion "p" 
}
public agenda añadir(Contacto c){
	list.add(c)
	return this;
