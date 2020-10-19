package codigo;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;


public class EventosAltas extends KeyAdapter implements ActionListener{
	
	//Declaracion de elementos
	private JDialogAltas dialog;
	
	//Clase Constructora
	EventosAltas(JDialogAltas dialog){
		this.dialog = dialog;
		
	}
	
	//Método manejador de eventos de teclas
	public void keyTyped(KeyEvent e) {
		
		if (e.getSource() == dialog.getTxtCodigo()) { //Si se comienza a teclear en el objeto txtCodigo de la clase JDialogAltas
			if (Character.isAlphabetic(e.getKeyChar()) || Character.isWhitespace(e.getKeyChar()) || Character.isLetter(e.getKeyChar())) { //Si lo que se escribe es un caracter alfabético, espacio en blanco y letra
				e.consume(); //Se ignora
				Toolkit.getDefaultToolkit().beep(); //Envía un sonido de atención
				dialog.setLblError("Sólo números"); //Muestra un JLabel para indicarle al usuario que sólo se permiten números
				dialog.getTxtCodigo().setBorder(new LineBorder(Color.RED)); //Colorea el borde del JTextField de color rojo
			}else { //Si no
				dialog.setLblError(""); //Mantiene u oculta el JLabel que indica al usuario que sólo se permiten números
				dialog.getTxtCodigo().setBorder(new LineBorder(null)); //Restaura el color del JLabel txtCodigo
			}

			if (dialog.getTxtCodigo().getText().length() == 3) { //Si el texto ingresado al JLabel txtCodigo es igual a 3
				e.consume(); //Se ignora lo que el usuario quiera seguir ingresando
				Toolkit.getDefaultToolkit().beep(); //Envía un sonido de atención
			}
		}
		
		if (e.getSource() == dialog.getTxtExistencia()) { //Si se comienza a teclear en el objeto txtExistencia de la clase JDialogAltas
			if (!Character.isDigit(e.getKeyChar())) { //Si lo que se ingresa no es un dígito
				e.consume(); //Se ignora
				Toolkit.getDefaultToolkit().beep(); //Se envía un sonido de atención
				dialog.setLblError("Sólo números"); //Muestra un JLabel para indicar al usuario que sólo se permiten números
				dialog.getTxtExistencia().setBorder(new LineBorder(Color.RED)); //Colorea el borde del JTextField txtExistencia de color rojo
			}else { //Si no
				dialog.setLblError(""); //Mantiene u oculta el JLabel que indica al usuario que sólo se permiten números
				dialog.getTxtExistencia().setBorder(new LineBorder(null)); //Restaura el color del JLabel txtExistencia
			}
		}
		
		if (e.getSource() == dialog.getTxtPrecio()) { //Si se comienza a teclear en el objeto txtPrecio de la clase JDialogAltas
			if (Character.isAlphabetic(e.getKeyChar()) || Character.isWhitespace(e.getKeyChar()) || Character.isLetter(e.getKeyChar())) { //Si lo que se escribe es un caracter alfabético, espacio en blanco y letra
				e.consume(); //Se ignora
				Toolkit.getDefaultToolkit().beep(); //Se envía un sonido de atención
				dialog.setLblError("Sólo números"); //Muestra un JLabel para indicar al usuario que sólo se permiten números
				dialog.getTxtPrecio().setBorder(new LineBorder(Color.RED)); //Colorea el borde del JTextField txtPrecio de color rojo
			}else { //Si no
				dialog.setLblError(""); //Mantiene u oculta el JLabel que indica al usuario que sólo se permiten números
				dialog.getTxtPrecio().setBorder(new LineBorder(null)); //Restaura el color del JLabel txtPrecio
			}
		}
		
	}
	
	//Método que sirve para comprobar si una clave es repetida o no
	public boolean esRepetido(int clave) {
		if (dialog.getManejaTabla().getHtTabla().containsKey(clave)) {
			return true;
		}else {
			return false;
		}
		
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
					if (dialog.getManejaTabla().getHtTabla().containsKey(clave)) { //Si la clave que se ingresó ya existía en la hashtable
						JOptionPane.showMessageDialog(dialog, "Clave existente", "Error", JOptionPane.ERROR_MESSAGE); //Muestra un mensaje de error al usuario
					}else { //Si no
						JOptionPane.showMessageDialog(dialog, "Artículo " + dialog.getTxtDescripcion().getText() + " guardado", "Confirmación",JOptionPane.INFORMATION_MESSAGE); //Muestra un mensaje de confirmación al usuario
						dialog.getManejaTabla().agregaArticulo(clave, nombre, marca, existencia, precio); //Hace referencia al método para agregaArticulo a través del JDialogAltas
						dialog.setTxtCodigo(""); //Limpia el txtCodigo
						dialog.setTxtDescripcion(""); //Limpia el txtDescripcion
						dialog.setTxtExistencia(""); //Limpia el txtExistencia
						dialog.setTxtPrecio(""); //Limpia el txtPrecio
					}
				}catch (Exception error) {
					JOptionPane.showMessageDialog(dialog, "Error en el precio", "Error", JOptionPane.ERROR_MESSAGE); //Si ocurre un error, mas especificamente, si el usuario agrega 2 puntos en el txtPrecio muestra mensaje de error
				}
			}
			
		}
		
		if (e.getSource() == dialog.getBtnSalir()) { //Si el usuario presiona el boton btSalir
			dialog.dispose(); //Cierra el JDialogAltas
		}
		
	}
	

}