package codigo;

import java.util.Enumeration;
import java.util.Hashtable;

public class ManejaTablaH {
	
    //Creación de la tabla hash
    private Hashtable<Integer, Articulo> htTabla = new Hashtable<Integer, Articulo>();
	
    //Método que se encarga de agregar los artículos a la tabla hash
    public void agregaArticulo(int clave, String nombre, String marca, int existencia, double precio, String siempreExistencia) {
        Articulo art = new Articulo(existencia, nombre, marca, precio, siempreExistencia);
        htTabla.put(clave, art);
		
    }
    
    //Método que regresa las veces que una marca determinada se repite entre los artículos
    public int getUsoMarca(String marca) {
        String[][] datos = getTabla();
	int vecesMarca = 0;
	for (int i = 0; i < htTabla.size(); i++) {
            if (datos[i][2].equals(marca))
                vecesMarca++;
            }
	return vecesMarca;
    }
    
    //Método para cambiar la existencia de un artículo a través de su clave
    public void setExistencia(int clave, int existencia) {
        htTabla.get(clave).setExistencia(existencia);
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
    
    //Método que sirve para ubicar la posición donde estan guardados los atributos por medio del nombre de un artículo
    public int regresaIndex(String nombre) {
        int index = 0;
	String[][] tabla1 = getTabla();
	for (int i=0;i<htTabla.size();i++) {
            if (tabla1[i][1].equalsIgnoreCase(nombre)) {
                index = i;
		break;
            }
	}
	return index;
    }
	
    //Método que sirve para obtener la tabla hash en una matríz
    public String[][] getTabla(){
        String[][] datos = new String[htTabla.size()][6];
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
            datos[con][5] = a.getSiempreExistencia();
            con++;
        }
        return datos;
    }
    
    //Método que sirve para comprobar si una clave es repetida o no
    public boolean esRepetido(int clave) {
        if (htTabla.containsKey(clave)) {
            return true;
	}else {
            return false;
        }
	
    }

}