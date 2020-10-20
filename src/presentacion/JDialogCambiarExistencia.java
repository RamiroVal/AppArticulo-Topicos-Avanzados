package presentacion;

import LibTexto.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import persistencia.ManejaTablaH;
import negocio.EventosCambiarExistencia;

public class JDialogCambiarExistencia extends JDialog {
	
    private JButton btnActualizar, btnSalir;
    private JTextField txtCambios;
    private JComboBox cmbArticulos;
    private LabelDefault lblExistencia, lblMarca, lblClave;
	
    public JDialogCambiarExistencia(Menu f, ManejaTablaH mArticulos) {
        super(f, "Cambiar existencia", true);
        setSize(300, 250);
	setLayout(null);
	setLocationRelativeTo(null);
	setResizable(false);
	
	String[] articulos = mArticulos.regresaNombre();
	String[][] datos = mArticulos.getTabla();
		
	LabelDefault lblMarca = new LabelDefault("Seleccione el artículo:");
	lblMarca.setBounds(5, 5, 130, 15);
		
	cmbArticulos = new JComboBox(articulos);
	cmbArticulos.setBounds(160, 1, 120, 25);
		
	LabelDefault lblexistencia = new LabelDefault("Existencia del artículo:");
	lblexistencia.setBounds(5, 35, 150, 15);
		
	lblExistencia = new LabelDefault(datos[0][3]);
	lblExistencia.setBounds(160, 35, 100, 15);
		
	LabelDefault lblmarca = new LabelDefault("Marca:");
	lblmarca.setBounds(5, 65, 120, 15);
		
	this.lblMarca = new LabelDefault(datos[0][2]);
	this.lblMarca.setBounds(160, 65, 120, 15);
		
	LabelDefault lblclave = new LabelDefault("Clave:");
	lblclave.setBounds(5, 95, 120, 15);
		
	lblClave = new LabelDefault(datos[0][0]);
	lblClave.setBounds(160, 95, 120, 15);
		
	LabelDefault lblCambios = new LabelDefault("Ingrese existencia:");
	lblCambios.setBounds(5, 127, 120, 15);
		
        txtCambios = new JTextField();
	txtCambios.setBounds(160, 123, 70, 23);
        
        CharLimit clCambios = new CharLimit(txtCambios, 5, CharLimit.SOLO_NUMEROS);
		
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
