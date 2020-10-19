package codigo;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDialogAltas extends JDialog{
	
	//Declaración de elementos que se usarán
	private JTextField txtCodigo, txtDescripcion, txtExistencia, txtPrecio;
	private JButton btnSalir, /*btnConsultar,*/ btnGuardar;
	private JComboBox cmbMarcar;
	private JLabel lblError;
	private ManejaTablaH manejaTabla;
	
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
		lblError = new JLabel(); //Crea un JLabel que servirá cuando el usuario ingresa un dato erroneo en un JLabel
		lblError.setForeground(Color.RED); //Asigna color de fuente rojo al lblError
		txtExistencia = new JTextField(5); //Crea un JTextField de longitud de 5
		txtPrecio = new JTextField(8); //Crea un JTextField de longitud de 8
		
		
		txtCodigo.addKeyListener(new EventosAltas(this)); //Agrega un manejador KeyEvent al txtCodigo
		txtExistencia.addKeyListener(new EventosAltas(this)); //Agrega un manejador de eventos de teclado al txtExistencia
		txtPrecio.addKeyListener(new EventosAltas(this)); //Agrega un manejador de eventos de teclado al txtPrecio
		btnGuardar.addActionListener(new EventosAltas(this)); //Agrega un manejador de eventos de acción al btnGuardar
		btnSalir.addActionListener(new EventosAltas(this)); //Agrega un manejador de eventos de acción al btnSalir
		
		this.manejaTabla = manejaTabla; //Asignación de objeto de tipo ManejaTablaH para hacer referencia
		
		add(new JLabel("Clave:")); //Se crea un objeto de tipo JLabel con la leyenda "Clave:" y se añade al JDialog
		add(txtCodigo); //Se añade el objeto txtCodigo al JDialog
		add(new JLabel("Nombre:")); //Se ccrea un objeto de tipo JLabel con la leyenda "Descripción:" y se añade al JDialog
		add(txtDescripcion); //Se añade el objeto txtDescripcion al JDialog
		add(lblError);
		add(new JLabel("Existencia:"));
		add(txtExistencia);
		add(new JLabel("Precio:"));
		add(txtPrecio);
		add(new JLabel("Seleccione Marca a Agregar:")); //Se crea un objeto de tipo JLabel con la leyenda "Seleccione Marca a Agregar" y se añade al JDialog
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
	
	public JComboBox getCmbMarcar() {
		return cmbMarcar;
	}
	
	public void setTxtCodigo(String txtCodigo) {
		this.txtCodigo.setText(txtCodigo);
	}

	public void setTxtDescripcion(String txtDescripcion) {
		this.txtDescripcion.setText(txtDescripcion);
	}
	
	public void setLblError(String mensaje) {
		this.lblError.setText(mensaje);
	}
	
	public JLabel getLblError() {
		return lblError;
	}
	
	public void setTxtPrecio(String mensaje) {
		this.txtPrecio.setText(mensaje);
	}
	
	public void setTxtExistencia(String mensaje) {
		this.txtExistencia.setText(mensaje);
	}
}