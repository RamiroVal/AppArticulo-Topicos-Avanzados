package presentacion;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import persistencia.ManejaTablaH;
import negocio.EventosCambiarExistencia;

public class JDialogCambiarExistencia extends JDialog {
	
    private JButton btnActualizar, btnSalir;
    private JTextField txtCambios;
    private JComboBox cmbArticulos;
    private JLabel lblExistencia, lblMarca, lblClave;
	
    public JDialogCambiarExistencia(Menu f, ManejaTablaH mArticulos) {
        super(f, "Cambiar existencia", true);
        setSize(300, 250);
	setLayout(null);
	setLocationRelativeTo(null);
	setResizable(false);
	
	String[] articulos = mArticulos.regresaNombre();
	String[][] datos = mArticulos.getTabla();
		
	JLabel lblMarca = new JLabel("Seleccione el artículo:");
	lblMarca.setBounds(5, 5, 130, 15);
		
	cmbArticulos = new JComboBox(articulos);
	cmbArticulos.setBounds(145, 1, 120, 25);
		
	JLabel lblexistencia = new JLabel("Existencia del artículo:");
	lblexistencia.setBounds(5, 35, 130, 15);
		
	lblExistencia = new JLabel(datos[0][3]);
	lblExistencia.setBounds(145, 35, 100, 15);
		
	JLabel lblmarca = new JLabel("Marca:");
	lblmarca.setBounds(5, 65, 120, 15);
		
	this.lblMarca = new JLabel(datos[0][2]);
	this.lblMarca.setBounds(145, 65, 120, 15);
		
	JLabel lblclave = new JLabel("Clave:");
	lblclave.setBounds(5, 95, 120, 15);
		
	lblClave = new JLabel(datos[0][0]);
	lblClave.setBounds(145, 95, 120, 15);
		
	JLabel lblCambios = new JLabel("Ingrese existencia:");
	lblCambios.setBounds(5, 125, 120, 15);
		
        txtCambios = new JTextField();
	txtCambios.setBounds(145, 123, 70, 23);
		
	btnActualizar = new JButton("Actualizar");
	btnActualizar.setBounds(40, 170, 100, 30);
		
	btnSalir = new JButton("Salir");
	btnSalir.setBounds(150, 170, 100, 30);
		
	add(lblMarca);
	add(cmbArticulos);
	add(lblexistencia);
	add(lblExistencia);
	add(lblmarca);
	add(this.lblMarca);
	add(lblclave);
	add(lblClave);
	add(lblCambios);
	add(txtCambios);
	add(btnActualizar);
	add(btnSalir);
		
	EventosCambiarExistencia manejador = new EventosCambiarExistencia(this, mArticulos);
	cmbArticulos.addItemListener(manejador);
	btnSalir.addActionListener(manejador);
	btnActualizar.addActionListener(manejador);
		
    }
	
    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnSalir() {
	return btnSalir;
    }
	
    public JTextField getTxtCambios() {
	return txtCambios;
    }
            
    public JComboBox getCmbArticulos() {
	return cmbArticulos;
    }
	
    public JLabel getLblExistencia() {
	return lblExistencia;
    }
	
    public JLabel getLblMarca() {
	return lblMarca;
    }
	
    public JLabel getLblClave() {
	return lblClave;
    }
	
    public void setTxtCambios(String s) {
        txtCambios.setText(s);
    }
	
    public void setLblExistencias(String s) {
        lblExistencia.setText(s);
    }
	
    public void setLblMarca(String s) {
	lblMarca.setText(s);
    }
	
    public void setLblClave(String s) {
        lblClave.setText(s);
    }

}
