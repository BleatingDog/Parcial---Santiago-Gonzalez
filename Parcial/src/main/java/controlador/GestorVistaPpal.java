/*
* Parcial programación
* Santiago González Gálvez - 202183392
* John Freddy Belalcázar - 202182464
* Profesor: Luis Yovany Romo Portilla
*/

package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void modificarAnio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void nuevoPronostico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
