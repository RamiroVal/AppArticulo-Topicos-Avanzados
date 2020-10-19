package codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//Clase que se encarga de manejar los eventos de la clase Menu
public class EventosMenu implements ActionListener{
	
    //Declaración de objetos para hacer referencia a métodos
    private Menu frame;
    private ManejaTablaH tabla;
    private GuardaMarca marca;
	
    //Clase constructor
    EventosMenu(Menu f, ManejaTablaH t, GuardaMarca m){
        frame = f;
        tabla = t;
	marca = m;
    }
	
    //Método actionPerformed para el manejo de eventos
    public void actionPerformed(ActionEvent e) {
        String evento = e.getActionCommand(); //Declaración de string que recibe el nombre del botón que fue presionado
		
	if (evento.equals("Articulos")){ //Si la opción seleccionada fue la de Articulos
            if (marca.getNombreMarcas().length == 0) { //Si la lista para seleccionar las marcas aún no se ha llenado con una opción
                JOptionPane.showMessageDialog(frame, "Lista de marcas vacías, agregue una para continuar", "Error", JOptionPane.ERROR_MESSAGE); //Se muestra un mensaje de error
            }else { //Si no
                JDialogAltas articulos = new JDialogAltas(frame, tabla, marca); //Se crea un objeto de tipo JDialogAltas
		articulos.setVisible(true); //Se muestra el JDialogAltas
            }
	}
		
        //Se encarga de cerrar la ventana y finalizar la ejecución al seleccionar "Salir"
        if (evento.equals("Salir")) {
            System.exit(0);
	}
		
	if (evento.equals("Inventario Total")) { //Si la opción seleccionada fue la de Inventario Total
            JDialogInventario inventario  = new JDialogInventario(frame, tabla); //Se crea un objeto de tipo JDialogInventario
            inventario.setVisible(true); //Se muestra el JDialog al usuario
	}
		
	if (evento.equals("Marcas")) { //Si la opción que se seleccionó fue la de Marcas
            JDialogMarcas marcas = new JDialogMarcas(frame, marca); //Se crea un objeto de tipo JDialogMarcas
            marcas.setVisible(true); //Se muestra al usuario
	}
		
	if (evento.equals("Consulta X Articulo")) { //Si la opción seleccionada fue la de Consulta X Articulo
            if (marca.getNombreMarcas().length == 0) { //Comprueba que ya se hayan agregado marcas previamente
                JOptionPane.showMessageDialog(frame, "Lista de artículos vacías, agregue uno para continuar", "Error", JOptionPane.ERROR_MESSAGE); //Si es así muestra un mensaje de error al usuario
            }else { //Si no
		ConsultaXArticulo consultar = new ConsultaXArticulo(frame, tabla); //Crea un objeto de tipo ConsultaXArticulo
		consultar.setVisible(true); //Muestra el ConsultaXArticulo al usuario
            }
			
	}
		
	if (evento.equals("Consulta Marcas")) { //Si la opción seleccionada fue la de Consulta Marcas
            JTableConsultaMarcas marcas = new JTableConsultaMarcas(frame, marca); //Crea un objeto de tipo JTableConsultaMarcas
            marcas.setVisible(true); //Lo muestra al usuario
			
	}
		
    }
	
}