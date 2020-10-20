package codigo;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JDialogInventario extends JDialog{
	
    private ManejaTablaH manejaTabla;
	
    //Clase encargada del JDialogInventario
    public JDialogInventario(Menu frame, ManejaTablaH tabla) {
        super(frame, "Inventario",true); //Llama al constructor de la clase padre y pasa como parámetros el frame de Menu, un titulo y establece el JDialog como modal
        setSize(700, 200); //Establece las dimensiones del JD
        setLocationRelativeTo(null); //Se establece el centro de la pantalla caundo es llamado
	String[] columnasNombre = {"Clave", "Nombre", "Marca", "Existencia", "Precio"}; //Arreglo para poner los nombres de las columnas de una JTable
	String[][] datos = tabla.getTabla(); //Arreglo donde se guardan los daatos de la tabla hash
	JTable tblTabla = new JTable(datos, columnasNombre); //Creación de una JTable
	tblTabla.setPreferredScrollableViewportSize(new Dimension(500, 800)); 
		
	JScrollPane scpScroll = new JScrollPane(tblTabla);
		
	getContentPane().add(scpScroll,BorderLayout.CENTER);
    }

}
