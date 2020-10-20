package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import presentacion.JDialogEliminaMarca;
import persistencia.GuardaMarca;
import persistencia.ManejaTablaH;

public class EventosEliminaMarca implements ActionListener, ItemListener{
    
    private JDialogEliminaMarca dialog;
    private GuardaMarca gMarca;
    private ManejaTablaH Tabla;
    private String marca;
    private int veces;

    public EventosEliminaMarca(JDialogEliminaMarca d, GuardaMarca m, ManejaTablaH t) {
        dialog = d;
	gMarca = m;
	Tabla = t;
	marca = dialog.getCmbMarcas().getSelectedItem().toString();
	veces = Tabla.getUsoMarca(marca);
    }
	
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dialog.getBtnSalir())
            dialog.dispose();
		
	if (e.getSource() == dialog.getBtnEliminar()) {
            if (veces != 0) {
                JOptionPane.showMessageDialog(dialog, "No se puede eliminar la marca ya que hay artículos de dicha marca", "No se puede eliminar", JOptionPane.ERROR_MESSAGE);
            }else {
                int si = JOptionPane.showConfirmDialog(dialog, "La marca " + marca + " se eliminará", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
                    if (si == 0) {
                        gMarca.eliminaMarca(marca);
			//String[] marcas = gMarca.getNombreMarcas();
			dialog.getCmbMarcas().removeItem(marca);
			try {
                            marca = dialog.getCmbMarcas().getSelectedItem().toString();
                            veces = Tabla.getUsoMarca(marca);
                            String[] atributos = gMarca.getAtributosNombre(marca);
                            dialog.setLblIdMarca(atributos[0]);
                            dialog.setLblNombre(atributos[0]);
                            dialog.setLblDatosProveedor(atributos[2]);
                            dialog.setLblMarcasUso(Integer.toString(veces));
			}catch(Exception ex) {
                            JOptionPane.showMessageDialog(dialog, "No hay marcas dadas de alta", "", JOptionPane.INFORMATION_MESSAGE);
                            dialog.dispose();
                        }
					
                    }
            }
	}
		
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == dialog.getCmbMarcas()) {
            try {
                marca = dialog.getCmbMarcas().getSelectedItem().toString();
		veces = Tabla.getUsoMarca(marca);
		String[] atributos = gMarca.getAtributosNombre(marca);
		dialog.setLblIdMarca(atributos[0]);
		dialog.setLblNombre(atributos[1]);
		dialog.setLblDatosProveedor(atributos[2]);
		dialog.setLblMarcasUso(Integer.toString(veces));
            }catch(Exception ex) {
                dialog.dispose();
            }
			
	}
		
    }

}
