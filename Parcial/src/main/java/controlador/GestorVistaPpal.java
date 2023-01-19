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
                     vistaPpal.getBtnAceptar().setEnabled(true);
                     //Desabilitando botones
                     vistaPpal.getBtnAgregar().setEnabled(false);
                     vistaPpal.getBtnBorrar().setEnabled(false);
                     vistaPpal.getBtnModificar().setEnabled(false);
                     vistaPpal.getBtnNuevo().setEnabled(false);
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnAceptar()){
                if (e.getButton() == 1){
                     modificarAnio();
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnNuevo()){
                if (e.getButton() == 1){
                     nuevoPronostico();
                }
            }
        }
    }
    
    public void agregarAnio() {
        
        int cantidadDeVentas = Integer.parseInt(vistaPpal.getTxtCantidadVenta().getText());
        if(cantidadDeVentas > 0) {
            //
            anioActual +=1;
            Object[] fila = new Object[4];
            fila[0] = anioActual;
            fila[1] = cantidadDeVentas;
            fila[2] = 0;//Año actual - (Año actual-1)
            fila[3] = 0;//(Año actual - (Año actual-1))/Año actual-1
            vistaPpal.anadirFilaTablaHistorico(fila);
        }
    }

    public void borrarAnio() {
        
        int filaSeleccionada = vistaPpal.filaSeleccionada();
        if (filaSeleccionada != -1){
            int numeroDeFilas = vistaPpal.getModeloTablaHistorico().getRowCount();
            for(int i = filaSeleccionada; i < numeroDeFilas; i++){
                vistaPpal.getModeloTablaHistorico().removeRow(i);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada", "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }

    public void modificarAnio() {
        
        //Habilitando botones
        vistaPpal.getBtnAceptar().setVisible(false);
        vistaPpal.getBtnAgregar().setEnabled(true);
        vistaPpal.getBtnBorrar().setEnabled(true);
        vistaPpal.getBtnModificar().setEnabled(true);
        vistaPpal.getBtnNuevo().setEnabled(true);
        
        vistaPpal.getTxtCantidadVenta().setText("0");
        long ventaNueva = Long.parseLong(vistaPpal.getTxtCantidadVenta().getText());
        //Modificar la cantidad de ventas del año seleccionado
    }
    
    public void ingresarDatosVentaAnterior(){
        int fila = vistaPpal.filaSeleccionada();
        if (fila != -1) {
            long ventaAntigua = vistaPpal.ventaAnioSeleccionado(fila);
            int anioSeleccionado = vistaPpal.anioSeleccionado(fila);
            vistaPpal.getTxtCantidadVenta().setText(String.valueOf(ventaAntigua));
            vistaPpal.getTxtAnio().setText(String.valueOf(anioSeleccionado));
        } else {
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void nuevoPronostico() {
        for(int i = 0; i < vistaPpal.getModeloTablaHistorico().getRowCount(); i++){
            vistaPpal.getModeloTablaPronostico().removeRow(i);
        }
    }
}
