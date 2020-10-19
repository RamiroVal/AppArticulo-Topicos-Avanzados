package codigo;

import java.util.Enumeration;
import java.util.Hashtable;

public class ManejaTablaH {
	
	//Creación de la tabla hash
	private Hashtable<Integer, Articulo> htTabla = new Hashtable<Integer, Articulo>();
	
	//Método que se encarga de agregar los artículos a la tabla hash
	public void agregaArticulo(int clave, String nombre, String marca, int existencia, double precio) {
		Articulo art = new Articulo(existencia, nombre, marca, precio);
		htTabla.put(clave, art);
		
	}
	
	//Método que regresa el nombre de los artículos en un arreglo 
	public String[] regresaNombre() {
		String[] datos = new String[htTabla.size()];
		Enumeration<Integer> e = htTabla.keys();
		int con = 0;
		while (e.hasMoreElements()) {
			int clave = e.nextElement();
			Articulo a = htTabla.get(clave);
			datos[con] = a.getNombre();
			con++;
		}
		return datos;
	}
	
	//Método que sirve para obtener la tabla hash en una matríz
	public String[][] getTabla(){
		String[][] datos = new String[htTabla.size()][5];
		Enumeration<Integer> e = htTabla.keys();
		int con = 0;
		while (e.hasMoreElements()) {
			int clave = e.nextElement();
			Articulo a = htTabla.get(clave);
			datos[con][0] = Integer.toString(clave);
			datos[con][1] = a.getNombre();
			datos[con][2] = a.getMarca();
			datos[con][3] = Integer.toString(a.getExistencia());
			datos[con][4] = "$" + Double.toString(a.getPrecio());
			con++;
		}
		return datos;
	}

	//Método get que regresa la tabla hash
	public Hashtable<Integer, Articulo> getHtTabla() {
		return htTabla;
	}
	
}