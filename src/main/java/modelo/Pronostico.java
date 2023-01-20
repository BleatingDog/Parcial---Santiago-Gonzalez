/*
* Parcial programación
* Santiago González Gálvez - 202183392
* Profesor: Luis Yovany Romo Portilla
*/

package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Pronostico {
    
    private ArrayList <Double> cantidadVentas;
    private ArrayList <Double> porcentajeDeVariacion;
    private double sumatoriaDePorcentaje;
    private double porcentajeDeVariacionPromedio;
    
    public Pronostico() {
        cantidadVentas = new ArrayList();
        sumatoriaDePorcentaje = 0;
        porcentajeDeVariacionPromedio = 0;
    }
    
    public void agregarAno(double cantidadVentas) {
        this.cantidadVentas.add(cantidadVentas);
    }
    
    public void modificarAno(double cantidadVentas, int ano) {
        this.cantidadVentas.set(ano, cantidadVentas);
    }
    
    public void eliminarAno(int ano) {
        this.cantidadVentas.removeIf(i -> i>=ano);
    }
    
    public boolean calcularPorcentajeDeVariacion() {
        if (cantidadVentas.size() >= 2) {
            porcentajeDeVariacion = new ArrayList();
            Iterator i = cantidadVentas.iterator();
            double primerAno = (double) i.next();
            while (i.hasNext()) {
                double segundoAno = (double) i.next();
                porcentajeDeVariacion.add((segundoAno-primerAno)/((double) primerAno));
                primerAno = segundoAno;
            }
            Iterator o = porcentajeDeVariacion.iterator();
            sumatoriaDePorcentaje = 0;
            while (o.hasNext()) {
                sumatoriaDePorcentaje += (double) o.next();
            }
            porcentajeDeVariacionPromedio = sumatoriaDePorcentaje/porcentajeDeVariacion.size();
            return true;
        }
        return false;
    }
    
    public double calcularIncremento(int ano) {
        try {
            return cantidadVentas.get(ano);
        } catch (IndexOutOfBoundsException e) {
            return calcularIncremento(ano-1)*(1+porcentajeDeVariacionPromedio);
        }
    }

    public ArrayList<Double> getCantidadVentas() {
        return cantidadVentas;
    }

    public ArrayList<Double> getPorcentajeDeVariacion() {
        return porcentajeDeVariacion;
    }

    public double getSumatoriaDePorcentaje() {
        return sumatoriaDePorcentaje;
    }

    public double getPorcentajeDeVariacionPromedio() {
        return porcentajeDeVariacionPromedio;
    }
}
