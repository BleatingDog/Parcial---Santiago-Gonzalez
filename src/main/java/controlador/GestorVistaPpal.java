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
import modelo.Pronostico;
import vista.VistaPpal;

public class GestorVistaPpal {
    
    private VistaPpal vistaPpal;
    private Pronostico pronostico;
    private int filaSeleccionadaModificar;
    
    public GestorVistaPpal(VistaPpal vistaPpal){
        this.vistaPpal = vistaPpal;
        pronostico = new Pronostico();
        this.vistaPpal.addBtnAgregarListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnBorrarListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnModificarListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnNuevoListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnAceptarListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnAceptar2Listener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnAceptar3Listener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPpal.getBtnAgregar() && vistaPpal.getBtnAgregar().isEnabled()){
                if (e.getButton() == 1){
                    borrarPronostico(false);
                    agregarEnProceso();
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnAceptar3() && vistaPpal.getBtnAceptar3().isEnabled()){
                if (e.getButton() == 1){
                    agregarAnio();
                }
            }
            if (e.getSource() == vistaPpal.getBtnBorrar() && vistaPpal.getBtnBorrar().isEnabled()){
                if (e.getButton() == 1){
                    borrarAnio();
                    borrarPronostico(false);
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnModificar() && vistaPpal.getBtnModificar().isEnabled()){
                if (e.getButton() == 1){
                    ingresarDatosVentaAnterior();
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnAceptar() && vistaPpal.getBtnAceptar().isEnabled()){
                if (e.getButton() == 1){
                    modificarAnio();
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnNuevo() && vistaPpal.getBtnNuevo().isEnabled()){
                if (e.getButton() == 1){
                    borrarPronostico(true);
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnAceptar2() && vistaPpal.getBtnAceptar2().isEnabled()){
                if (e.getButton() == 1){
                    ingresarPronostico();
                }
            }
        }
    }
    
    public void agregarAnio() {
        
        double cantidadDeVentas = Double.parseDouble(vistaPpal.getTxtCantidadVenta().getText());
        if(cantidadDeVentas >= 0) {
            
            pronostico.agregarAno(cantidadDeVentas);
            Object[] fila = new Object[3];
            int numAnio = pronostico.getCantidadVentas().size()-1;
            fila[0] = numAnio;
            fila[1] = pronostico.getCantidadVentas().get(numAnio);
            fila[2] = "";
            vistaPpal.anadirFilaTablaHistorico(fila);
            
            //Modificando ventana
            vistaPpal.getBtnAgregar().setEnabled(true);
            vistaPpal.getBtnBorrar().setEnabled(true);
            vistaPpal.getBtnModificar().setEnabled(true);
            vistaPpal.getTxtCantidadVenta().setEnabled(false);
            vistaPpal.getBtnAceptar3().setEnabled(false);
            vistaPpal.getBtnAceptar2().setEnabled(false);
            vistaPpal.getBtnAceptar().setEnabled(false);
            vistaPpal.getTxtAnio().setText("");
            vistaPpal.getTxtCantidadVenta().setText("");
        }
        if(vistaPpal.getModeloTablaHistorico().getRowCount() >= 2){
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
        vistaPpal.getTxtAnio().setText(String.valueOf(pronostico.getCantidadVentas().size()));
    }
    
    public void borrarAnio() {
        
        int filaSeleccionada = vistaPpal.filaSeleccionada();
        
        if (filaSeleccionada == -1){
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada", "Error", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        
        pronostico.eliminarAno(filaSeleccionada);
        
        int numeroDeFilas = vistaPpal.getModeloTablaHistorico().getRowCount();

        actualizarTablaHistorico();

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
        
        double ventaNueva = Double.parseDouble(vistaPpal.getTxtCantidadVenta().getText());
        
        int filaSeleccionada = filaSeleccionadaModificar;
        
        pronostico.modificarAno(ventaNueva, filaSeleccionada);
        
        actualizarTablaHistorico();
        
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
        double ventaAntigua = vistaPpal.ventaAnioSeleccionado(fila);
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
        
        int cantidad = vistaPpal.getModeloTablaPronostico().getRowCount();
        for(int i = 0; i < cantidad; i++){
            vistaPpal.getModeloTablaPronostico().removeRow(0);
        }
        
        pronostico.borrarPorcentajesDeVariacion();
        actualizarTablaHistorico();
        vistaPpal.getTxtPromedio().setText("");
        filaSeleccionadaModificar = fila;
        
    }
    public void borrarPronostico(boolean habilitarOpciones) {
        //Borra los pronósticos
        int cantidad = vistaPpal.getModeloTablaPronostico().getRowCount();
        for(int i = 0; i < cantidad; i++){
            vistaPpal.getModeloTablaPronostico().removeRow(0);
        }
        
        //Modificando ventana
        vistaPpal.getBtnAceptar2().setEnabled(habilitarOpciones);
        vistaPpal.getTxtCantidadVenta().setEnabled(false);
        vistaPpal.getTxtPromedio().setText("");
        vistaPpal.getTxtAnios().setEnabled(habilitarOpciones);
        vistaPpal.getBtnAgregar().setEnabled(!habilitarOpciones);
        vistaPpal.getBtnBorrar().setEnabled(!habilitarOpciones);
        vistaPpal.getBtnModificar().setEnabled(!habilitarOpciones);
        if(vistaPpal.getModeloTablaHistorico().getRowCount() >= 2){
            vistaPpal.getBtnNuevo().setEnabled(!habilitarOpciones);
        } else {
           vistaPpal.getBtnNuevo().setEnabled(false); 
        }
        pronostico.borrarPorcentajesDeVariacion();
        actualizarTablaHistorico();
    }
    public void ingresarPronostico(){
        pronostico.calcularPorcentajeDeVariacion();
        actualizarTablaHistorico();
        
        //Ingresa el pronóstico de los años ingresados
        int aniosAPronosticar = Integer.parseInt(vistaPpal.getTxtAnios().getText());
        if(aniosAPronosticar >= 2) {
            for (int i=0; i<aniosAPronosticar; i++) {
                Object[] fila = new Object[2];
                fila[0] = i;
                fila[1] = pronostico.calcularPronostico(i);
                vistaPpal.anadirFilaTablaPronostico(fila);
            }
            
            vistaPpal.getTxtPromedio().setText(String.valueOf(pronostico.getPorcentajeDeVariacionPromedio()));
            
            //Modificando ventana
            vistaPpal.getBtnAceptar2().setEnabled(false);
            vistaPpal.getBtnAgregar().setEnabled(true);
            vistaPpal.getBtnBorrar().setEnabled(true);
            vistaPpal.getBtnModificar().setEnabled(true);
            vistaPpal.getBtnNuevo().setEnabled(true);
            vistaPpal.getTxtAnios().setEnabled(false);
            vistaPpal.getTxtAnios().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un número mayor o igual a 2", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarTablaHistorico() {
        int cantidad = vistaPpal.getModeloTablaHistorico().getRowCount();
        for (int i=0; i<cantidad; i++) {
            vistaPpal.getModeloTablaHistorico().removeRow(0);
        }
        for (int i=0; i<pronostico.getCantidadVentas().size(); i++) {
            Object[] fila = new Object[3];
            fila[0] = i;
            fila[1] = pronostico.getCantidadVentas().get(i);
            if (i==0) {
                fila[2] = "";
            } else if (pronostico.getPorcentajeDeVariacion() != null) {
                if (pronostico.getPorcentajeDeVariacion().size() != 0) {
                    fila[2] = pronostico.getPorcentajeDeVariacion().get(i-1);
                } else {
                    fila[2] = ""; 
                }
            } else {
                fila[2] = ""; 
            }
            vistaPpal.anadirFilaTablaHistorico(fila);
        }
    }
}
