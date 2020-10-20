package persistencia;

public class Articulo {
	
    //Declaración de los atributos del objeto Articulo
    private int existencia;
    private String nombre, marca;
    private double precio;
    private String siempreExistencia;

    //Método Constructor
    Articulo(int existencia, String nombre, String marca, double precio, String siempreExistencia) {
        this.existencia = existencia;
	this.nombre = nombre;
	this.marca = marca;
	this.precio = precio;
        this.siempreExistencia = siempreExistencia;
    }

    //toString
    @Override
    public String toString() {
        return "Articulo [cantidad=" + existencia + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + "]";
    }

    //Getters y Setters
    public int getExistencia() {
        return existencia;
    }
    
    public void setExistencia(int cantidad){
        this.existencia = cantidad;
    }
    
    public String getSiempreExistencia(){
        return siempreExistencia;
    }
    
    public void setSiempreExistencia(String a){
        siempreExistencia = a;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}