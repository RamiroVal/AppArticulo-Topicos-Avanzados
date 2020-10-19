package codigo;

public class Articulo {
	
    //Declaración de los atributos del objeto Articulo
    private int existencia;
    private String nombre, marca;
    private double precio;

    //Método Constructor
    public Articulo(int existencia, String nombre, String marca, double precio) {
        this.existencia = existencia;
	this.nombre = nombre;
	this.marca = marca;
	this.precio = precio;
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

    public void setCantidad(int cantidad) {
        this.existencia = cantidad;
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