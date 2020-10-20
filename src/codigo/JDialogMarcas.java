package codigo;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class JDialogMarcas extends JDialog{
	
    private JTextField txtIdMarca, txtNombre, txtDatosProveedor;
    private JButton btnSalir, btnGuardar;
    private JLabel lblID, lblNombre, lblDatos;
    private GuardaMarca dalMarcas;
	
    public JDialogMarcas(JFrame frame, GuardaMarca marcas) {
        super(frame, "Altas Marcas", true); //Hace referencia a la clase padre
        setSize(330, 160); //Se le asigna uans dimensiones al JDialog
	setResizable(false); //Se bloquea el redimensionamiento del JDialog
        setLocationRelativeTo(null); //Se establece el centro de la pantalla caundo es llamado
	setLayout(null); //Se asigna un Layout nulo

	//Se crean los JTextField y se les asigna dimensiones
	txtIdMarca = new JTextField(6);
	txtNombre = new JTextField(15);
	txtDatosProveedor = new JTextField(20);

	//Se crean los JButtons
	btnSalir = new JButton("Salir");
	btnGuardar = new JButton("Guardar");

	//Se crean los JLabels para indicar el nombre de los parámetros
	lblID = new JLabel("ID de Marca:");
	lblNombre = new JLabel("Nombre:");
	lblDatos = new JLabel("Datos de Proveedor:");

	//Se establecen las dimenciones y la ubicación dentro del JDialog de los elementos
	lblID.setBounds(5, 5, 70, 10);
	txtIdMarca.setBounds(140, 3, 100, 20);
	lblNombre.setBounds(5, 30, 50, 15);
        txtNombre.setBounds(140, 30, 100, 20);
	lblDatos.setBounds(5, 57, 130, 15);
	txtDatosProveedor.setBounds(140, 57, 100, 20);
	btnGuardar.setBounds(60, 84, 90, 30);
	btnSalir.setBounds(160, 84, 90, 30);

        this.dalMarcas = marcas; //Se declara un objeto de tipoGuardaMarca para hacer referencia

	//Se le agregan los manejadores a los elementos
	txtIdMarca.addKeyListener(new EventosMarcas(this));
	btnGuardar.addActionListener(new EventosMarcas(this));
	btnSalir.addActionListener(new EventosMarcas(this));

	//Se agregan los elementos al JDialog
	add(lblID);
	add(txtIdMarca);
	add(lblNombre);
	add(txtNombre);
	add(lblDatos);
	add(txtDatosProveedor);
	add(btnGuardar);
	add(btnSalir);
		
    }

    //Métodos Getters y Setters
    public JTextField getTxtIdMarca() {
        return txtIdMarca;
    }

    public void setTxtIdMarca(String txtIdMarca) {
        this.txtIdMarca.setText(txtIdMarca);
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre.setText(txtNombre);
    }

    public JTextField getTxtDatosProveedor() {
        return txtDatosProveedor;
    }

    public void setTxtDatosProveedor(String txtDatosProveedor) {
        this.txtDatosProveedor.setText(txtDatosProveedor);
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JLabel getLblID() {
        return lblID;
    }

    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblDatos() {
        return lblDatos;
    }

    public void setLblDatos(JLabel lblDatos) {
        this.lblDatos = lblDatos;
    }

    public GuardaMarca getDalMarcas() {
        return dalMarcas;
    }

    public void setDalMarcas(GuardaMarca dalMarcas) {
        this.dalMarcas = dalMarcas;
    }

}
