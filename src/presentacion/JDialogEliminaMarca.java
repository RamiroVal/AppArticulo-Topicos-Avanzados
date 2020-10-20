package presentacion;

import LibTexto.LabelDefault;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import persistencia.GuardaMarca;
import persistencia.ManejaTablaH;
import negocio.EventosEliminaMarca;

public class JDialogEliminaMarca extends JDialog{
	
    private JComboBox cmbMarcas;
    private LabelDefault lblIdMarca, lblNombre, lblDatosProveedor, lblMarcasUso;
    private JButton btnEliminar, btnSalir;
	
    public JDialogEliminaMarca(Menu frame, GuardaMarca gMarca, ManejaTablaH Tabla) {
        super(frame, "Eliminar marca", true);
	setSize(360, 215);
	setLocationRelativeTo(null);
	setLayout(null);
		
	String[] Marcas = gMarca.getNombreMarcas();
	String[][] datosMarcas = gMarca.getTabla();
	int veces = Tabla.getUsoMarca(Marcas[0]);
		
	LabelDefault seleccion = new LabelDefault("Seleccione la marca:");
	LabelDefault id = new LabelDefault("Id:");
	LabelDefault nombre = new LabelDefault("Nombre:");
	LabelDefault datosProveedor = new LabelDefault("Datos generales:");
	LabelDefault marcasUso = new LabelDefault("Artículos:");

	lblIdMarca = new LabelDefault(datosMarcas[0][0]);
	lblNombre = new LabelDefault(datosMarcas[0][1]);
	lblDatosProveedor = new LabelDefault(datosMarcas[0][2]);
	lblMarcasUso = new LabelDefault(Integer.toString(veces));
		
	cmbMarcas = new JComboBox(Marcas);
		
	btnEliminar = new JButton("Eliminar");
	btnSalir = new JButton("Salir");
		
		
	seleccion.setBounds(5, 10, 190, 15);
	cmbMarcas.setBounds(190, 5, 150, 25);
	id.setBounds(5, 35, 20, 15);
	lblIdMarca.setBounds(190, 35, 130, 15);
	nombre.setBounds(5, 60, 70, 15);
	lblNombre.setBounds(190, 60, 200, 15);
	datosProveedor.setBounds(5, 85, 150, 15);
	lblDatosProveedor.setBounds(190, 85, 300, 15);
	marcasUso.setBounds(5, 110, 90, 15);
	lblMarcasUso.setBounds(190, 110, 90, 15);
	btnEliminar.setBounds(90, 140, 80, 30);
	btnSalir.setBounds(180, 140, 80, 30);
		
	add(seleccion);
	add(cmbMarcas);
	add(id);
	add(lblIdMarca);
	add(nombre);
	add(lblNombre);
	add(datosProveedor);
	add(lblDatosProveedor);
	add(marcasUso);
	add(lblMarcasUso);
	add(btnEliminar);
	add(btnSalir);
		
	EventosEliminaMarca manejador = new EventosEliminaMarca(this, gMarca, Tabla);
	btnEliminar.addActionListener(manejador);
	btnSalir.addActionListener(manejador);
	cmbMarcas.addItemListener(manejador);
		
    }
	
    public JComboBox getCmbMarcas() {
        return cmbMarcas;
    }
	
    public JButton getBtnEliminar() {
	return btnEliminar;
    }
	
    public JButton getBtnSalir() {
	return btnSalir;
    }
	
    public void setLblIdMarca(String texto) {
	lblIdMarca.setText(texto);
    }
	
    public void setLblNombre(String texto) {
	lblNombre.setText(texto);
    }
	
    public void setLblDatosProveedor(String texto) {
	lblDatosProveedor.setText(texto);
    }
	
    public void setLblMarcasUso(String texto) {
	lblMarcasUso.setText(texto);
    }
	
}
