
package codigo;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConsultaXArticulo extends JDialog{
	
    //Declaracion de elementos que usará el JDialog
    private JComboBox comboBox;
    private ManejaTablaH tabla;
    private JLabel lblClave, lblNombre,lblExistencia, lblPrecio, lblMarca;
	
    //Constructor
    public ConsultaXArticulo(Menu f, ManejaTablaH tabla) {
        super(f, "Consulta por Artículo", true); //Llama a la clase padre y le pasa como parámetros un objeto Menu, un titulo y establece como modal
        setLayout(null); //Se le asigna un FlowLayout nulo
	setSize(330, 200); //Se le asigna las dimensiones del JDialog
	setLocationRelativeTo(null); //Se establece el centro de la pantalla cuando es llamado
	setResizable(false); //Bloquea el redimensionamiento del JFrame
		
	String[] listaArticulos =  tabla.regresaNombre(); //Arreglo de String con los nombres que el usuario ha agregado en los artículos
        String[][] datos = tabla.getTabla(); //Arreglo de String que servirá para llenar los datos cuando el JDialog se abre por primera vez
        
	comboBox = new JComboBox(listaArticulos); //Crea un objeto de tipo JComboBox y se añaden todos los nombres de los artículos que el usuario ha añaddido
		
	//Creación de los JLabel que servirán para mostrarle la información de los distintos atributos de los artículos al usuario
	JLabel clave = new JLabel("Clave:");
	JLabel nombre = new JLabel("Nombre:");
	JLabel existencia = new JLabel("Existencia:");
	JLabel precio = new JLabel("Precio:");
	JLabel marca = new JLabel("Marca:");
        
        //Reciben los datos del Articulo que esta por defecto cuando se abre el JDialog
	lblClave = new JLabel(datos[0][0]);
	lblNombre = new JLabel(datos[0][1]);
	lblExistencia = new JLabel(datos[0][2]);
	lblPrecio = new JLabel(datos[0][3]);
	lblMarca = new JLabel(datos[0][4]);
		
	//Establecimiento de su locación y sus dimenciones
	comboBox.setBounds(5,5,100,20);
	lblClave.setBounds(100,35,100,15);
	nombre.setBounds(5, 60, 50, 15);
	clave.setBounds(5, 35, 50, 15);
	existencia.setBounds(5,85,90,15);
	precio.setBounds(5, 110, 90, 15);
	marca.setBounds(5, 135, 90, 15);
	lblNombre.setBounds(100,60,100,15);
	lblExistencia.setBounds(100, 85, 100,15);
	lblPrecio.setBounds(100, 110, 100, 15);
	lblMarca.setBounds(100, 135, 100, 15);
		
	this.tabla = tabla; //Declaración de un objeto ManejaTablaH que servirá para hacer referencia en la clase de manejo de eventos
		
	EventosXArticulos manejador = new EventosXArticulos(this, this.tabla); //Creación del objeto que manejará los eventos, recibe como parámetros esta clase y el objeto ManejaTablaH
	comboBox.addItemListener(manejador); //Asigna el manejador al objeto comboBox

	//Agrega los objetos al JDialog
	add(comboBox);
	add(clave);
	add(lblClave);
	add(nombre);
        add(lblNombre);
	add(existencia);
	add(lblExistencia);
	add(precio);
	add(lblPrecio);
	add(marca);
	add(lblMarca);
	
    }

    //Getters y Setters
    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JLabel getLblClave() {
        return lblClave;
    }

    public void setLblClave(String lblClave) {
        this.lblClave.setText(lblClave);
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(String lblNombre) {
        this.lblNombre.setText(lblNombre);
    }

    public JLabel getLblExistencia() {
        return lblExistencia;
    }

    public void setLblExistencia(String lblExistencia) {
        this.lblExistencia.setText(lblExistencia);
    }

    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    public void setLblPrecio(String lblPrecio) {
        this.lblPrecio.setText(lblPrecio);
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public void setLblMarca(String lblMarca) {
        this.lblMarca.setText(lblMarca);
    }
	
}
