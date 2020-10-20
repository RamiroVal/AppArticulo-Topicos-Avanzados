package persistencia;

public class GuardaMarca {
	
    private Marca[] arregloMarca;
    private int posicion = 0;
	
    //Método constructor
    public GuardaMarca(){
	arregloMarca = new Marca[10];
    }
	
    //Método que guarda las marcas en un arreglo
    public boolean guardaMarcas(int idMarca, String nombre, String datosProveedor) {
        boolean salir = false;
        Marca marca = new Marca(idMarca, nombre, datosProveedor);
	if (posicion<10) {
            arregloMarca[posicion] = marca;
            posicion++;
            salir = true;
	}
            return salir;
    }
    
    //Método para eliminar una marca
    public boolean eliminaMarca(String nombre) {
        String[][] tabla = getTabla();
	int longitud = posicion;
	int pos = 0;
	boolean elimino = false;
		
	for (int i = 0; i < longitud; i++) {
            if (arregloMarca[i].getNombre().equalsIgnoreCase(nombre)) {
                posicion -= 1;
		elimino = true;
                continue;
            }else {
		arregloMarca[pos].setDatosProveedor(tabla[i][2]);
		arregloMarca[pos].setNombre(tabla[i][1]);
		arregloMarca[pos].setIdMarca(Integer.parseInt(tabla[i][0]));
		pos++;
            }
	}
	return elimino;
    }
	
    //Método que comprueba si la "memoria" de artículos está llena
    public boolean estaLleno() {
        if (posicion == 10) {
            return true;
	}else {
            return false;
	}
    }
	
    //Método para obtener la tabla de marcas
    public String[][] getTabla() {
        String[][] datos = new String[posicion][3];
        for (int i=0;i<posicion;i++) {
            datos[i][0] = Integer.toString(arregloMarca[i].getIdMarca());
            datos[i][1] = arregloMarca[i].getNombre();
            datos[i][2] = arregloMarca[i].getDatosProveedor();
	}
		
        return datos;
    }
	
    //Método para obtener los nombres de las marcas
    public String[] getNombreMarcas() {
        String[] nombres = new String[posicion];
	for (int i=0;i<posicion;i++) {
            nombres[i] = arregloMarca[i].getNombre();
	}
        return nombres;
    }
    
    //Método que regresa los atributos de una marca a través de su nombre
    public String[] getAtributosNombre(String nombre) {
        String[] atributos = new String[3];
	String[][] marcas = getTabla();
	for (int i = 0; i < posicion; i++) {
            if (marcas[i][1].equals(nombre)) {
                atributos[0] = marcas[i][0];
		atributos[1] = marcas[i][1];
		atributos[2] = marcas[i][2];
            }
	}
		
	return atributos;
    }
	
    //Método que regresa todos los atributos de un índice determinado
    public String getMarcaIndex(int n) {
        return "id " + arregloMarca[n].getIdMarca() + " nombre " + arregloMarca[n].getNombre() + " proveedor " + arregloMarca[n].getDatosProveedor();
    }
	
    //Método para comprobar si un dato esta repetido
    public boolean esRepetido(int id, String nombre, String datos) {
        for (int i=0;i<posicion;i++) {
            if (arregloMarca[i].getNombre().equals(nombre) || arregloMarca[i].getIdMarca() == id || arregloMarca[i].getDatosProveedor().equals(datos)) {
                return true;
            }
        }
        return false;
    }
	
    //Método que comprueba si un Id ya fue ingresado
    public boolean estaID(int id) {
        for (int i=0;i<posicion;i++) {
            if (arregloMarca[i].getIdMarca() == id) {
                return true;
            }
	}
            return false;
    }
	
    //Método que comprueba si un nombre ya fue ingresado
    public boolean estaNombre(String nombre) {
        for (int i=0;i<posicion;i++) {
            if (arregloMarca[i].getNombre().equals(nombre)) {
                return true;
            }
	}
        return false;
    }
	
    //Método que comprueba si un datode proveedor ya fue ingreasdo
    public boolean estaDatos(String datos) {
        for (int i=0;i<posicion;i++) {
            if (arregloMarca[i].getDatosProveedor().equals(datos)) {
                return true;
            }
        }
	return false;
    }
        
}