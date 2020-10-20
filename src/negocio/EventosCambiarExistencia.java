package negocio;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import presentacion.JDialogCambiarExistencia;
import persistencia.ManejaTablaH;

public class EventosCambiarExistencia implements ActionListener, ItemListener{

    //Declaracion de objetos para hacer referencia
    private JDialogCambiarExistencia dialog;
    private ManejaTablaH tabla;
	
    //Método constructor
    public EventosCambiarExistencia(JDialogCambiarExistencia d, ManejaTablaH t) {
        dialog = d;
	tabla = t;
    }
	
    //Método manejador de eventos ItemListener
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == dialog.getCmbArticulos()) { //Si el JComboBox Articulos es cambiado 
            int index = tabla.regresaIndex(dialog.getCmbArticulos().getSelectedItem().toString()); //Obtiene el índice de dónde está guardado a través del nombre de un artículo
            String[][] datos = tabla.getTabla(); //Declaración de String con los elementos de la tabla Hash
            dialog.setLblClave(datos[index][0]); //Establece la clave del nombre que fue seleccionado
            dialog.setLblMarca(datos[index][2]); //Establece la marca del nombre que fue seleccionado
            dialog.setLblExistencias(datos[index][3]); //Establece la Existencai del nombre del artículo que fue seleccionado
	}
		
    }
	
    //Método manejador de eventos ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dialog.getBtnSalir()) { //Si se presiona el botón Salir
            dialog.dispose(); //Se cierra el JDialog
        }
		
	if (e.getSource() == dialog.getBtnActualizar()) { //Si se selecciona el botón Actualizar
            try {
                int index = tabla.regresaIndex(dialog.getCmbArticulos().getSelectedItem().toString()); //Obtiene el índice donde esta guardados los atributos del artículo seleccionado en el ComboBox
                String[][] datos = tabla.getTabla(); //Obtiene la tabla de todos los artículos
		tabla.setExistencia(Integer.parseInt(datos[index][0]), Integer.parseInt(dialog.getTxtCambios().getText())); //Actualiza la existencia del articulo seleccionado en el ComboBox
		JOptionPane.showMessageDialog(dialog, "La existencia se ha cambiado", "Confirmación", JOptionPane.INFORMATION_MESSAGE); //Muestra un mensaje de confirmación al usuaio
		datos = tabla.getTabla(); //Actualiza la tabla con todos los artículos
                dialog.setTxtCambios(""); //Limpia el JTextField
		dialog.setLblExistencias(datos[index][3]); //Establece la Existencai del nombre del artículo que fue seleccionado
                dialog.getTxtCambios().setBorder(new LineBorder(Color.BLACK)); //Cambia el borde del txtCambios a negro
            }catch(Exception ex) {
		dialog.getTxtCambios().setBorder(new LineBorder(Color.red)); //Colorea el contorno del txtCambios a rojo, ya que se encontraba vacío
		JOptionPane.showMessageDialog(dialog, "Campo vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
			
	}
		
    }
	
}
