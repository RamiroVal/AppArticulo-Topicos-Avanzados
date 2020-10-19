package codigo;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//Clase que se encarga de construir y mostrar la JTable que muestra los atributos de los objetos Marca
public class JTableConsultaMarcas extends JDialog{
	
    //Método Constructor
    public JTableConsultaMarcas(Menu frame, GuardaMarca marcas) {
        super(frame, "Inventario Marcas", true); //Hace referencia a la clase padre
	setSize(370, 200); //Establece las dimensiones del JDialog
	setResizable(false); //Bloquea el redimensionamiento del JDialog
        setLocationRelativeTo(null); //Se establece el centro de la pantalla caundo es llamado
        String[] columnasNombre = {"ID Marca", "Nombre", "Datos Proveedor"}; //Arreglo donde estan los nombres de las columnas
	String[][] datos = marcas.getTabla(); //Matríz donde se se guardan las marcas
	JTable tblTabla = new JTable(datos, columnasNombre); //Creación de un JTable
	tblTabla.setPreferredScrollableViewportSize(new Dimension(500, 800));
			
	JScrollPane scpScroll = new JScrollPane(tblTabla);
		
	getContentPane().add(scpScroll,BorderLayout.CENTER);
    }

}
