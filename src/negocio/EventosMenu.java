package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import presentacion.*;
import persistencia.ManejaTablaH;
import persistencia.GuardaMarca;

import LibTabla.ConsultaTablas;

//Clase que se encarga de manejar los eventos de la clase Menu
public class EventosMenu implements ActionListener{
	
    //Declaración de objetos para hacer referencia a métodos
    private Menu frame;
    private ManejaTablaH tabla;
    private GuardaMarca marca;
	
    //Clase constructor
    public EventosMenu(Menu f, ManejaTablaH t, GuardaMarca m){
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
            String[] columnasNombre = {"Clave", "Nombre", "Marca", "Existencia", "Precio"}; //Arreglo para poner los nombres de las columnas de una JTable
            String[][] datos = tabla.getTabla(); //Arreglo donde se guardan los daatos de la tabla hash
            ConsultaTablas inventario = new ConsultaTablas(frame, "Inventario Total", columnasNombre, datos); //Creacion de objeto de la libreria Libreria_AppInventario, muestra los datos que se le envían en una JTable
            inventario.setVisible(true); //Lo muestra al usuario
	}
		
	if (evento.equals("Marcas")) { //Si la opción que se seleccionó fue la de Marcas
            JDialogMarcas marcas = new JDialogMarcas(frame, marca); //Se crea un objeto de tipo JDialogMarcas
            marcas.setVisible(true); //Se muestra al usuario
	}
		
	if (evento.equals("Consulta X Articulo")) { //Si la opción seleccionada fue la de Consulta X Articulo
            try {
                ConsultaXArticulo consultar = new ConsultaXArticulo(frame, tabla); //Crea un objeto de tipo ConsultaXArticulo
		consultar.setVisible(true); //Muestra el ConsultaXArticulo al usuario
            }catch(Exception ex) { //Si no
		JOptionPane.showMessageDialog(frame, "Lista de artículos vacías, agregue uno para continuar", "Error", JOptionPane.ERROR_MESSAGE); //Si es así muestra un mensaje de error al usuario
            }
			
	}
		
	if (evento.equals("Consulta Marcas")) { //Si la opción seleccionada fue la de Consulta Marcas
            String[] columnasNombre = {"ID Marca", "Nombre", "Datos Proveedor"}; //Arreglo donde estan los nombres de las columnas
            String[][] datos = marca.getTabla(); //Matríz donde se se guardan las marcas
            ConsultaTablas marcas = new ConsultaTablas(frame, "Consulta Marcas", columnasNombre, datos); //Declaracion me objeto de la librería Libreria_AppInventario para crear tablas por un JDialog
            marcas.setVisible(true); //Lo muestra al usuario
	
	}
        
        if (evento.equals("Cambiar Existencia")) {
            try {
                JDialogCambiarExistencia existencia = new JDialogCambiarExistencia(frame, tabla);
		existencia.setVisible(true);
            }catch(Exception ex) {
		JOptionPane.showMessageDialog(frame, "No se han agregado artículos", "Error", JOptionPane.ERROR_MESSAGE);
            }
			
	}
        
        if (evento.equals("Eliminar Marca")){
            if (marca.getNombreMarcas().length == 0) {
                JOptionPane.showMessageDialog(frame, "No se han agregado marcas", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
		JDialogEliminaMarca eliminar = new JDialogEliminaMarca(frame, marca, tabla);
		eliminar.setVisible(true);
            }
	}
		
    }
	
}