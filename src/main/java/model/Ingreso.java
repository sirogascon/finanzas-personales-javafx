package model;

import java.time.LocalDate;

public class Ingreso {

    private String descripcion;
    private double importe;
    private LocalDate fecha;
    private String origen;

    public Ingreso(String descripcion, double importe, LocalDate fecha, String origen) {
        this.descripcion = descripcion;
        this.importe = importe;
        this.fecha = fecha;
        this.origen = origen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getOrigen() {
        return origen;
    }

    @Override
    public String toString() {
        return "Ingreso{" +
                "descripcion='" + descripcion + '\'' +
                ", importe=" + importe +
                ", fecha=" + fecha +
                ", origen='" + origen + '\'' +
                '}';
    }
}