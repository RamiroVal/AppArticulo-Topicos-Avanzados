package codigo;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame {
	
    //Declaración de elementos que se usarán
    private JMenuBar mbBarra;
    private JMenu menuCatalogos, menuConsultas;
    private ManejaTablaH manejadoraTabla = new ManejaTablaH();
    private GuardaMarca marcas = new GuardaMarca();
    private JComboBox cbComboBox;

    Menu(){
        super("App Inventario"); //Llamada al método constructor de la clase padre y se le da como parámetro "App Inventario"
	setSize(300,100); //Establece las dimensiones del JFrame
	setDefaultCloseOperation(EXIT_ON_CLOSE); //Detiene la ejecución cuando el usuario cierra el JFrame
	setLocationRelativeTo(null); //Establece al JFrame en el centro de la pantalla
	setResizable(false); //Bloquea el redimensionamiento del JFrame
	setLayout(null);
		
	mbBarra = new JMenuBar(); //Crea un objeto de tipo JMenuBar
	menuCatalogos = new JMenu("Catalogos"); //Crea un objeto de tipo JMenu con la leyenda "Catalogos"
	menuConsultas = new JMenu("Consultas"); //Crea un objeto de tipo JMenu con la leyenda "Consultas"
		
	setJMenuBar(mbBarra); //Se agrega el objeto mbBarra al JFrame
	mbBarra.add(menuCatalogos); //Agrega el objeto menuCatalogos al objeto mbBarra
	mbBarra.add(menuConsultas); //Agrega el objeto menuCatalogos al objeto mbBarra

	//Declara los JMenuItems que se utilizarán
	JMenuItem mitemArticulos, mitemMarcas, mitemSalir, mitemInventario, mitemConsultaMarca, mitemConsultaArticulo;

	mitemArticulos = new JMenuItem("Articulos"); //Crea un objeto de tipo JMenuItem con la leyenda "Articulos"
	mitemMarcas = new JMenuItem("Marcas"); //Crea un objeto de tipo JMenuItem con la leyenda "Marcas"
	mitemSalir = new JMenuItem("Salir"); //Crea un objeto de tipo JMenuItem con la leyenda "Salir"
	mitemInventario =  new JMenuItem("Inventario Total"); //Crea un objeto de tipo JMenuItem con la leyenda "Inventario Total"
	mitemConsultaMarca = new JMenuItem("Consulta Marcas"); //Crea un objeto de tipo JMenuItem con la leyenda "Consulta Marcas"
	mitemConsultaArticulo = new JMenuItem("Consulta X Articulo"); //Crea un objeto de tipo JMenuItem con la leyenda "Consulta X Articulo"
		
	menuCatalogos.add(mitemArticulos); //Agrega el objeto mimtemArticulos al objeto menuCatalogos
	menuCatalogos.add(mitemMarcas); //Agrega el objeto mimtemMarcas al objeto menuCatalogos
	menuCatalogos.addSeparator(); //Crea un objeto de tipo JMenuItem con la leyenda "_________" y la agrega al objeto menuCatalogos
	menuCatalogos.add(mitemSalir); //Agrega el objeto mimtemSalir al objeto menuCatalogos
	menuConsultas.add(mitemInventario); //Agrega el objeto de tipo mitemInventario al objeto menuConsultas
	menuConsultas.add(mitemConsultaArticulo); //Agrega el objeto de tipo mitemConsultaArticulo al objeto menuConsultas
	menuConsultas.add(mitemConsultaMarca); //Agrega el objeto de tipo mitemConsultaMarca al objeto menuConsultas
		
	EventosMenu manejador = new EventosMenu(this, manejadoraTabla, marcas); //Se declara un objeto de tipo EventosMenu para el manejo de eventos
	mitemArticulos.addActionListener(manejador); //Se agrega el manejador al objeto mitemArticulos
	mitemSalir.addActionListener(manejador); //Se agrega el manejador al objeto mitemSalir
	mitemInventario.addActionListener(manejador);
	mitemMarcas.addActionListener(manejador);
	mitemConsultaMarca.addActionListener(manejador);
	mitemConsultaArticulo.addActionListener(manejador);
		
    }
	
    //Métodos Getters
    public GuardaMarca getMarcas() {
        return marcas;
    }
	
    public ManejaTablaH getManejadoraTabla() {
        return manejadoraTabla;
    }
	
    public JMenuBar getMbBarra() {
        return mbBarra;
    }

}
