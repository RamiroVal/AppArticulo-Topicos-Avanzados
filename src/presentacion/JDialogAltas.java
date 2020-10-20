package presentacion;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import persistencia.ManejaTablaH;
import persistencia.GuardaMarca;
import negocio.EventosAltas;

import LibTexto.*;

public class JDialogAltas extends JDialog{
	
    //Declaración de elementos que se usarán
    private JTextField txtCodigo, txtDescripcion, txtExistencia, txtPrecio;
    private JButton btnSalir, /*btnConsultar,*/ btnGuardar;
    private JComboBox cmbMarcar;
    private ManejaTablaH manejaTabla;
    private JCheckBox chkSiempreExistencia;
	
    public JDialogAltas(JFrame frame, ManejaTablaH manejaTabla, GuardaMarca marcas) {
		
        super(frame,"Captura de Artículos",true); //Llamado al constructor de la clase padre y recibe como parámetro un objeto de tipo JFrame y se le asigna modo modal
	setLayout(new FlowLayout(FlowLayout.CENTER)); //Se le asigna un FlowLayout centrado
	setSize(330, 155); //Se le asigna las dimensiones del JDialog
	setLocationRelativeTo(null); //Se establece el centro de la pantalla caundo es llamado
	setResizable(false); //Bloquea el redimensionamiento del JFrame 
		
	String[] listaArticulos =  marcas.getNombreMarcas();//Arreglo de String con los nombres de las marcas que se agregaran
	txtCodigo = new JTextField(3); //Se crea un objeto de tipo JTextField con una longitud de 3
	txtDescripcion = new JTextField(13); //Se crea un objeto de tipo JTextField con una longitud de 13
	cmbMarcar = new JComboBox(listaArticulos); //Se crea un objeto de tipo JComboBox y se le da como parámetro el arreglo listaArticulos
	btnGuardar = new JButton("Guardar"); //Se crea un objeto de tipo JButton con la leyenda "Guardar"
	//btnConsultar = new JButton("Consultar"); //Se crea un objeto de tipo JButton con la leyenda "Consultar"
	btnSalir = new JButton("Salir"); //Se crea un objeto de tipo JButton con la leyenda "Salir"
	txtExistencia = new JTextField(5); //Crea un JTextField de longitud de 5
	txtPrecio = new JTextField(8); //Crea un JTextField de longitud de 8
        chkSiempreExistencia = new JCheckBox("Siempre en existencia"); //Se crea un JCheckBox paara indicar si el articulo siempre tiene que estar disponible o no 
		
	EventosAltas manejador = new EventosAltas(this);
	btnGuardar.addActionListener(manejador); //Agrega un manejador de eventos de acción al btnGuardar
	btnSalir.addActionListener(manejador); //Agrega un manejador de eventos de acción al btnSalir
        chkSiempreExistencia.addItemListener(manejador); //Agrega un manejador de eventos de item al chkSiempreExistencia
		
	this.manejaTabla = manejaTabla; //Asignación de objeto de tipo ManejaTablaH para hacer referencia
        
        CharLimit clCodigo = new CharLimit(txtCodigo, 3, CharLimit.SOLO_NUMEROS);
        CharLimit clDescripcion = new CharLimit(txtDescripcion, 25);
        CharLimit clExistencia = new CharLimit(txtExistencia, 5, CharLimit.SOLO_NUMEROS);
        CharLimit clPrecio = new CharLimit(txtPrecio, 8, CharLimit.BOOLEANOS);
		
	add(new LabelDefault("Clave:")); //Se crea un objeto de tipo JLabel con la leyenda "Clave:" y se añade al JDialog
	add(txtCodigo); //Se añade el objeto txtCodigo al JDialog
	add(new LabelDefault("Nombre:")); //Se ccrea un objeto de tipo JLabel con la leyenda "Descripción:" y se añade al JDialog
	add(txtDescripcion); //Se añade el objeto txtDescripcion al JDialog
	add(new LabelDefault("Existencia:")); //Se agrega un JLabel con la leyenda "Existencia:"
	add(txtExistencia); //Se agrega el txtExistencia al JDialog
        add(chkSiempreExistencia); //Se agrega el chkSiempreExistencia al JDialog
	add(new LabelDefault("Precio:")); //Se agrega un JLabel con la leyenda "Precio:" al JDialog
	add(txtPrecio); //Se agrega el objeto txtPrecio al JDialog
	add(new LabelDefault("Seleccione Marca a Agregar:")); //Se crea un objeto de tipo JLabel con la leyenda "Seleccione Marca a Agregar" y se añade al JDialog
	add(cmbMarcar); //Se añade el objeto cmbMarca al JDialog
	add(btnGuardar); //Se añade el objeto btnGuardar al JDialog
	//add(btnConsultar); //Se añade el objeto btnConsultar al JDialog
	add(btnSalir); //Se añade el objeto btnSalir al JDialog
		

    }
	
    //Métodos Getters y Setters
    public JTextField getTxtPrecio() {
        return txtPrecio;
    }
	
    public JTextField getTxtExistencia() {
	return txtExistencia;
    }
	
    public ManejaTablaH getManejaTabla() {
	return manejaTabla;
    }
	
    public JTextField getTxtCodigo() {
        return txtCodigo;
    }
	
    public JTextField getTxtDescripcion() {
	return txtDescripcion;
    }
	
    public JButton getBtnSalir() {
	return btnSalir;
    }
	
    public JButton getBtnGuardar() {
        return btnGuardar;
    }
	
    /*public JButton getBtnConsultar() {
	return btnConsultar;
    }*/
        
    public JCheckBox getChkSiempreExistencia(){
        return chkSiempreExistencia;
    }
	
    public JComboBox getCmbMarcar() {
	return cmbMarcar;
    }
	
    public void setTxtCodigo(String txtCodigo) {
	this.txtCodigo.setText(txtCodigo);
    }

    public void setTxtDescripcion(String txtDescripcion) {
	this.txtDescripcion.setText(txtDescripcion);
    }
	
    public void setTxtPrecio(String mensaje) {
        this.txtPrecio.setText(mensaje);
    }
	
    public void setTxtExistencia(String mensaje) {
	this.txtExistencia.setText(mensaje);
    }
    
}