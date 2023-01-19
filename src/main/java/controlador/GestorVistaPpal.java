/*
* Parcial programación
* Santiago González Gálvez - 202183392
* John Freddy Belalcázar - 202182464
* Profesor: Luis Yovany Romo Portilla
*/

package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import vista.VistaPpal;

public class GestorVistaPpal {
    
    private VistaPpal vistaPpal;
    private int anioActual = 0;
    public GestorVistaPpal(VistaPpal vistaPpal){
        this.vistaPpal = vistaPpal;
        this.vistaPpal.addBtnAgregarListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnBorrarListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnModificarListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnNuevoListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnAceptarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPpal.getBtnAgregar()){
                if (e.getButton() == 1){
                     agregarEnProceso();
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnAceptar3()){
                if (e.getButton() == 1){
                     agregarAnio();
                }
            }
            if (e.getSource() == vistaPpal.getBtnBorrar()){
                if (e.getButton() == 1){
                     borrarAnio();
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnModificar()){
                if (e.getButton() == 1){
                     ingresarDatosVentaAnterior();
                     
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnAceptar()){
                if (e.getButton() == 1){
                     modificarAnio();
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnNuevo()){
                if (e.getButton() == 1){
                     borrarPronostico();
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnAceptar2()){
                if (e.getButton() == 1){
                     ingresarPronostico();
                }
            }
        }
    }
    
    public void agregarAnio() {
        
        int cantidadDeVentas = Integer.parseInt(vistaPpal.getTxtCantidadVenta().getText());
        if(cantidadDeVentas > 0) {
            
            anioActual +=1;
            Object[] fila = new Object[4];
            fila[0] = anioActual;
            fila[1] = cantidadDeVentas;
            fila[2] = 0;//Año actual - (Año actual-1)
            fila[3] = 0;//(Año actual - (Año actual-1))/Año actual-1
            vistaPpal.anadirFilaTablaHistorico(fila);
            
            //Modificando ventana
            vistaPpal.getBtnAgregar().setEnabled(true);
            vistaPpal.getBtnBorrar().setEnabled(true);
            vistaPpal.getBtnModificar().setEnabled(true);
            vistaPpal.getTxtCantidadVenta().setEnabled(false);
            vistaPpal.getBtnAceptar3().setEnabled(false);
            vistaPpal.getBtnAceptar2().setEnabled(false);
            vistaPpal.getBtnAceptar().setEnabled(false);
        }
        if(vistaPpal.getModeloTablaHistorico().getRowCount() >= 3){
            vistaPpal.getBtnNuevo().setEnabled(true);
        } else {
           vistaPpal.getBtnNuevo().setEnabled(false); 
        }
    }
    
    public void agregarEnProceso(){
        vistaPpal.getTxtCantidadVenta().setEnabled(true);
        vistaPpal.getBtnAceptar3().setEnabled(true);
        vistaPpal.getBtnAceptar2().setEnabled(false);
        vistaPpal.getBtnAceptar().setEnabled(false);
        vistaPpal.getBtnAgregar().setEnabled(false);
        vistaPpal.getBtnBorrar().setEnabled(false);
        vistaPpal.getBtnModificar().setEnabled(false);
        vistaPpal.getBtnNuevo().setEnabled(false);
    }
    
    public void borrarAnio() {
        
        int filaSeleccionada = vistaPpal.filaSeleccionada();
        if (filaSeleccionada == -1){
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada", "Error", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        
        int numeroDeFilas = vistaPpal.getModeloTablaHistorico().getRowCount();

        //Borra los años posteriores al año seleccionado
        for(int i = filaSeleccionada; i < numeroDeFilas; i++){
            vistaPpal.getModeloTablaHistorico().removeRow(i);
        }

        //Borra los pronósticos
        for(int i = 0; i < vistaPpal.getModeloTablaPronostico().getRowCount(); i++){
            vistaPpal.getModeloTablaPronostico().removeRow(i);
        }

        //Modificando ventana
        vistaPpal.getBtnAgregar().setEnabled(true);
        vistaPpal.getBtnModificar().setEnabled(true);
        
        if(vistaPpal.getModeloTablaHistorico().getRowCount() >= 3){
            vistaPpal.getBtnNuevo().setEnabled(true);
        } else {
           vistaPpal.getBtnNuevo().setEnabled(false); 
        }
        
        if(vistaPpal.getModeloTablaHistorico().getRowCount() == 0){
            vistaPpal.getBtnBorrar().setEnabled(false);
            vistaPpal.getBtnModificar().setEnabled(false); 
            vistaPpal.getBtnNuevo().setEnabled(false); 
        }
    }

    public void modificarAnio() {
        
        long ventaNueva = Long.parseLong(vistaPpal.getTxtCantidadVenta().getText());
        //Modificar la cantidad de ventas del año seleccionado
        //Recalcular todo :v
        
        //Modificando ventana
        vistaPpal.getBtnAceptar().setEnabled(false);
        vistaPpal.getBtnAceptar2().setEnabled(false);
        vistaPpal.getBtnAceptar3().setEnabled(false);
        vistaPpal.getTxtCantidadVenta().setEnabled(false);
        vistaPpal.getBtnAgregar().setEnabled(true);
        vistaPpal.getBtnBorrar().setEnabled(true);
        vistaPpal.getBtnModificar().setEnabled(true);
        
        if(vistaPpal.getModeloTablaHistorico().getRowCount() >= 3){
            vistaPpal.getBtnNuevo().setEnabled(true);
        } else {
           vistaPpal.getBtnNuevo().setEnabled(false); 
        }
        
        vistaPpal.getTxtCantidadVenta().setText("");
        
    }
    
    public void ingresarDatosVentaAnterior(){
        
        int fila = vistaPpal.filaSeleccionada();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        long ventaAntigua = vistaPpal.ventaAnioSeleccionado(fila);
        int anioSeleccionado = vistaPpal.anioSeleccionado(fila);

        //Ingresando los datos a la ventana
        vistaPpal.getTxtCantidadVenta().setText(String.valueOf(ventaAntigua));
        vistaPpal.getTxtAnio().setText(String.valueOf(anioSeleccionado));

        //Modificando la ventana
        vistaPpal.getBtnAceptar().setEnabled(true);
        vistaPpal.getTxtCantidadVenta().setEnabled(true);
        vistaPpal.getBtnAceptar2().setEnabled(false);
        vistaPpal.getBtnAceptar3().setEnabled(false);
        vistaPpal.getBtnAgregar().setEnabled(false);
        vistaPpal.getBtnBorrar().setEnabled(false);
        vistaPpal.getBtnModificar().setEnabled(false);
        vistaPpal.getBtnNuevo().setEnabled(false);
        
    }
    public void borrarPronostico() {
        //Borra los pronósticos
        for(int i = 0; i < vistaPpal.getModeloTablaPronostico().getRowCount(); i++){
            vistaPpal.getModeloTablaPronostico().removeRow(i);
        }
        
        //Modificando ventana
        vistaPpal.getBtnAceptar2().setEnabled(true);
        vistaPpal.getTxtCantidadVenta().setEnabled(false);
        vistaPpal.getBtnAceptar().setEnabled(false);
        vistaPpal.getBtnAgregar().setEnabled(false);
        vistaPpal.getBtnBorrar().setEnabled(false);
        vistaPpal.getBtnModificar().setEnabled(false);
        vistaPpal.getBtnNuevo().setEnabled(false);
    }
    public void ingresarPronostico(){
        //Ingresa el pronóstico de los años ingresados
        int aniosAPronosticar = Integer.parseInt(vistaPpal.getTxtAnios().getText());
        if(aniosAPronosticar >= 2) {
            //
            anioActual +=1;
            Object[] fila = new Object[2];
            fila[0] = 0; //Año
            fila[1] = 0; //Pronóstico de ventas del año
            vistaPpal.anadirFilaTablaPronostico(fila);
            
            //Modificando ventana
            vistaPpal.getBtnAceptar2().setEnabled(false);
            vistaPpal.getBtnAceptar().setEnabled(false);
            vistaPpal.getTxtCantidadVenta().setEnabled(true);
            vistaPpal.getBtnAgregar().setEnabled(true);
            vistaPpal.getBtnBorrar().setEnabled(true);
            vistaPpal.getBtnModificar().setEnabled(true);
            vistaPpal.getBtnNuevo().setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un número mayor o igual a 2", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}