package codigo;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

//Clase manejadora de eventos del JDialogMarcas
public class EventosMarcas extends KeyAdapter implements ActionListener{
	
	private JDialogMarcas dialog;
	
	//Constructor que recibe como parámetros un objeto de tipo JDialogMarcas para hacer referencia
	public EventosMarcas(JDialogMarcas d) {
		dialog = d;
	}

	//Metodo actionPerformed para el manejo de eventos
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Guardar")) { //Si el usuario presiona el boton btnGuardar
			try {
				int id = Integer.parseInt(dialog.getTxtIdMarca().getText()); //Declara un entero con el valor que el usuario ingresó en el txtMarca
				String nombre = dialog.getTxtNombre().getText().toUpperCase(); //Declara un string con la cadena que el usuario ingresó al txtNombre y lo convierte en mayúsculas
				String dProveedor = dialog.getTxtDatosProveedor().getText().toUpperCase(); //Declara un string con la cadena que el usuario ingresó al txtDatosProveedor y lo convierte en mayúsculas
				
				if (dialog.getTxtIdMarca().getText().isEmpty() || nombre.isEmpty() || dProveedor.isEmpty()) { //Si el txtIdMarca o la cadena nombre o la cadena dProveedor estan vacías
					JOptionPane.showMessageDialog(dialog, "Campos vacíos", "Error", JOptionPane.ERROR_MESSAGE); //Muestra al usuario un mensaje de error
				}else if (dialog.getDalMarcas().estaLleno()){ //Si no, comprueba si la "memoria" donde se guardan las marcas esta lleno a través del método estaLleno 
					JOptionPane.showMessageDialog(dialog, "Memoria Llena", "Error", JOptionPane.ERROR_MESSAGE); //Si es así muestra un mensaje al usuario
				}else { //Si no
					if (dialog.getDalMarcas().esRepetido(id, nombre, dProveedor)) { //Comprueba si id, nombre o dProveedor ya habían sido ingresados
						if (dialog.getDalMarcas().estaID(id)) //Comprueba si el id ya había sido agregado a través del método estaID 
							JOptionPane.showMessageDialog(dialog, "ID repetido", "Error", JOptionPane.ERROR_MESSAGE); //Si es así, muestra un mensaje de error
						if (dialog.getDalMarcas().estaNombre(nombre)) //Comprueba si el nombre ya había sido agregado
							JOptionPane.showMessageDialog(dialog, "Nombre repetido", "Error", JOptionPane.ERROR_MESSAGE); //Si es así, muestra un mensaje de error
						if (dialog.getDalMarcas().estaDatos(dProveedor)) //Comprueba si el dProveedor ya había sido agregado
							JOptionPane.showMessageDialog(dialog, "Datos de Proveedor repetidos", "Error", JOptionPane.ERROR_MESSAGE); //Si es así, muestra un mensaje de error
					}else { //Si no es así
						dialog.getDalMarcas().guardaMarcas(id, nombre, dProveedor); //Agrega los datos por el método guardaMarcas haciendo referencia por el JDialogMarcas a la clase GuardaMarca 
						JOptionPane.showMessageDialog(dialog, "Marca registrada", "Confirmación", JOptionPane.INFORMATION_MESSAGE); //Muestra un mensaje de confirmación
						dialog.setTxtDatosProveedor(""); //Limpia el txtDatosProveedor
						dialog.setTxtIdMarca(""); //Limpia el txtIdMarca
						dialog.setTxtNombre(""); //Limpia el txtNombre
					}
				}
			}catch(Exception error) { //Si no se puede cumplir lo que se hizo en el try
				JOptionPane.showMessageDialog(dialog, "Error", "Error", JOptionPane.ERROR_MESSAGE); //Muestra un mensaje de error
			}
		}
		
		if (e.getActionCommand().equals("Salir")) { //Si el usuario preciona el boton btnSalir
			dialog.dispose(); //Cierra el JDialog
		}
		
	}
	
	//Comprueba que lo que se escriba en el JTextField asignado sean sólo números
	public void keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
			Toolkit.getDefaultToolkit().beep();
			dialog.getLblID().setForeground(Color.RED);
		}else {
			dialog.getLblID().setForeground(Color.BLACK);
		}
	}

}