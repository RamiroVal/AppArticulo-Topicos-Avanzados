
package presentacion;

import LibTexto.LabelDefault;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import persistencia.ManejaTablaH;
import negocio.EventosXArticulos;

public class ConsultaXArticulo extends JDialog{
	
    //Declaracion de elementos que usará el JDialog
    private JComboBox comboBox;
    private ManejaTablaH tabla;
    private LabelDefault lblClave, lblNombre,lblExistencia, lblPrecio, lblMarca, lblSiempreExistencia;
	
    //Constructor
    public ConsultaXArticulo(Menu f, ManejaTablaH tabla) {
        super(f, "Consulta por Artículo", true); //Llama a la clase padre y le pasa como parámetros un objeto Menu, un titulo y establece como modal
        setLayout(null); //Se le asigna un FlowLayout nulo
	setSize(330, 220); //Se le asigna las dimensiones del JDialog
	setLocationRelativeTo(null); //Se establece el centro de la pantalla cuando es llamado
	setResizable(false); //Bloquea el redimensionamiento del JFrame
		
	String[] listaArticulos =  tabla.regresaNombre(); //Arreglo de String con los nombres que el usuario ha agregado en los artículos
        String[][] datos = tabla.getTabla(); //Arreglo de String que servirá para llenar los datos cuando el JDialog se abre por primera vez
        
	comboBox = new JComboBox(listaArticulos); //Crea un objeto de tipo JComboBox y se añaden todos los nombres de los artículos que el usuario ha añaddido
		
	//Creación de los JLabel que servirán para mostrarle la información de los distintos atributos de los artículos al usuario
	LabelDefault clave = new LabelDefault("Clave:");
	LabelDefault nombre = new LabelDefault("Nombre:");
	LabelDefault existencia = new LabelDefault("Existencia:");
	LabelDefault precio = new LabelDefault("Precio:");
	LabelDefault marca = new LabelDefault("Marca:");
        LabelDefault siempreExistencia = new LabelDefault("Siempre en existencia");
        
        //Reciben los datos del Articulo que esta por defecto cuando se abre el JDialog
	lblClave = new LabelDefault(datos[0][0]);
	lblNombre = new LabelDefault(datos[0][1]);
	lblExistencia = new LabelDefault(datos[0][2]);
	lblPrecio = new LabelDefault(datos[0][3]);
	lblMarca = new LabelDefault(datos[0][4]);
        lblSiempreExistencia = new LabelDefault(datos[0][5]);

	//Establecimiento de su locación y sus dimenciones
	comboBox.setBounds(5,5,100,20);
	lblClave.setBounds(160,35,100,15);
	nombre.setBounds(5, 60, 85, 15);
	clave.setBounds(5, 35, 50, 15);
	existencia.setBounds(5,85,90,15);
	precio.setBounds(5, 110, 90, 15);
	marca.setBounds(5, 135, 90, 15);
        siempreExistencia.setBounds(5, 160, 150, 15);
	lblNombre.setBounds(160,60,100,15);
	lblExistencia.setBounds(160, 85, 100,15);
	lblPrecio.setBounds(160, 110, 100, 15);
	lblMarca.setBounds(160, 135, 100, 15);
        lblSiempreExistencia.setBounds(160, 160, 100, 15);

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
        add(siempreExistencia);
        add(lblSiempreExistencia);

    }

    //Getters y Setters    
    public void setLblSiempreExistencia(String texto){
        lblSiempreExistencia.setText(texto);
    }
    
    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setLblClave(String lblClave) {
        this.lblClave.setText(lblClave);
    }

    public void setLblNombre(String lblNombre) {
        this.lblNombre.setText(lblNombre);
    }

    public void setLblExistencia(String lblExistencia) {
        this.lblExistencia.setText(lblExistencia);
    }

    public void setLblPrecio(String lblPrecio) {
        this.lblPrecio.setText(lblPrecio);
    }

    public void setLblMarca(String lblMarca) {
        this.lblMarca.setText(lblMarca);
    }
	
}
