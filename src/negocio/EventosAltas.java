package negocio;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import presentacion.JDialogAltas;

public class EventosAltas implements ActionListener, ItemListener{
	
    //Declaracion de elementos
    private JDialogAltas dialog;
    private String selec;
	
    //Clase Constructora
    public EventosAltas(JDialogAltas dialog){
        this.dialog = dialog;
        selec = "No";
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {	
        if (e.getSource() == dialog.getBtnGuardar()) { //Detecta si el objeto btnGuardar fue presionado
            if (dialog.getTxtDescripcion().getText().isEmpty() || dialog.getTxtCodigo().getText().isEmpty()) { //Comprueba si el txtDescripcion o el txtcodigo están vacíos
                JOptionPane.showMessageDialog(dialog, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE); //Si es así muestra un mensaje de error al usuario
            }else { //Si no es así comprueba que el texto ingresado en el txtCodigo sea de longitud de 3
		int clave, existencia; //Declara un entero con identificador clave y otro con existencia
		String nombre, marca; //Declara un string con identificador nombre y otro con marca
		double precio; //Declara un double con identificador precio
		try {
                    clave = Integer.parseInt(dialog.getTxtCodigo().getText()); //Establece a clave el valor que el usuario ingresó al txtCodigo
                    nombre = dialog.getTxtDescripcion().getText().toUpperCase(); ////Establece a nombre el string que el usuario ingresó al txtDescripcion y lo convierte a mayúsculas
                    marca = dialog.getCmbMarcar().getSelectedItem().toString().toUpperCase(); //Establece a marca el string que el usuario ingresó al txtMarca y lo convierte a mayúsculas
                    existencia = Integer.parseInt(dialog.getTxtExistencia().getText()); //Establece a existencia el valor que el usuario ingresó a txtExistencia
                    precio = Double.parseDouble(dialog.getTxtPrecio().getText()); //Establece a precio el valor que el usuario ingresó a txtPrecio
                    if (dialog.getManejaTabla().esRepetido(clave)) { //Si la clave que se ingresó ya existía en la hashtable
                        JOptionPane.showMessageDialog(dialog, "Clave existente", "Error", JOptionPane.ERROR_MESSAGE); //Muestra un mensaje de error al usuario
                    }else { //Si no
                        JOptionPane.showMessageDialog(dialog, "Artículo " + dialog.getTxtDescripcion().getText() + " guardado", "Confirmación",JOptionPane.INFORMATION_MESSAGE); //Muestra un mensaje de confirmación al usuario
                        dialog.getManejaTabla().agregaArticulo(clave, nombre, marca, existencia, precio, selec); //Hace referencia al método para agregaArticulo a través del JDialogAltas
			dialog.setTxtCodigo(""); //Limpia el txtCodigo
			dialog.setTxtDescripcion(""); //Limpia el txtDescripcion
			dialog.setTxtExistencia(""); //Limpia el txtExistencia
			dialog.setTxtPrecio(""); //Limpia el txtPrecio
                    }
		}catch (Exception error) {
                    JOptionPane.showMessageDialog(dialog, "Error en el precio", "Error", JOptionPane.ERROR_MESSAGE); //Si ocurre un error, mas especificamente, si el usuario agrega 2 puntos en el txtPrecio muestra mensaje de error
                    dialog.getTxtPrecio().setBorder(new LineBorder(Color.RED));
                }
            }
			
        }
		
	if (e.getSource() == dialog.getBtnSalir()) { //Si el usuario presiona el boton btSalir
            dialog.dispose(); //Cierra el JDialogAltas
	}
		
    }
    
    //Maneja los eventos del JCheckBox
    @Override
    public void itemStateChanged(ItemEvent e){
        if (dialog.getChkSiempreExistencia().isSelected()){ //Si esta seleccionado el JCheckBox
            selec = "Si";
        }else{
            selec = "No";
        }
    }
   
}
