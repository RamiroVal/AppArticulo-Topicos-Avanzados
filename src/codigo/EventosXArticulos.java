package codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//Clase manejadora de eventos de ConsultaXArticulos
public class EventosXArticulos implements ItemListener{
	
    //Declaración de objetos para hacer referencia
    private ConsultaXArticulo frame;
    private ManejaTablaH tabla;
	
    //Método Cosntructor
    public EventosXArticulos(ConsultaXArticulo f, ManejaTablaH t) {
        frame = f;
	tabla = t;
    }
	
    //Método para el manejo de eventos de items
    @Override
    public void itemStateChanged(ItemEvent e) {
		
        if (e.getSource() == frame.getComboBox()) {
            int index = tabla.regresaIndex(frame.getComboBox().getSelectedItem().toString()); //Obtiene el índice de dónde está guardado a través del nombre de un artículo
            String[][] datos = tabla.getTabla(); //Declaración de String con los elementos de la tabla Hash
            frame.setLblClave(datos[index][0]); //Establece la clave del nombre que fue seleccionado
            frame.setLblNombre(datos[index][1]); //Establece el nombre del nombre que fue seleccionado
            frame.setLblMarca(datos[index][2]); //Establece la marca del nombre que fue seleccionado
            frame.setLblExistencia(datos[index][3]); //Establece la Existencai del nombre del artículo que fue seleccionado
            frame.setLblPrecio(datos[index][4]); //Establece el precio del nombre del artículo que fue seleccionado
	}
		
    }

}