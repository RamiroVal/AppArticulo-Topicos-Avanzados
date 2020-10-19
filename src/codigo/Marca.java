package codigo;

public class Marca {
	
	//Declaración de los atributos de la clase Marca
	private int idMarca;
	private String nombre;
	private String datosProveedor;
	
	//Constructor de la clase Marca
	Marca(int idMarca, String nombre, String datosProveedor){
		this.idMarca = idMarca;
		this.nombre = nombre;
		this.datosProveedor = datosProveedor;
	}

	//Métodos Getters y Setters
	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDatosProveedor() {
		return datosProveedor;
	}

	public void setDatosProveedor(String datosProveedor) {
		this.datosProveedor = datosProveedor;
	}
	
	public String toString() {
		return "ID de Marca: " + idMarca + " Nombre: " + nombre + "Datos del Proveedor: " + datosProveedor;
	}

}
