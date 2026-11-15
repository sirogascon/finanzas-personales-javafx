package model;

import java.time.LocalDate;

public class Gasto {

    private String descripcion;
    private CategoriaGasto categoria;
    private double importe;
    private LocalDate fecha;
    private MetodoPago metodoPago;

    public Gasto(String descripcion, CategoriaGasto categoria, double importe, LocalDate fecha, MetodoPago metodoPago) {
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.importe = importe;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public CategoriaGasto getCategoria() {
        return categoria;
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

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "descripcion='" + descripcion + '\'' +
                ", categoria=" + categoria +
                ", importe=" + importe +
                ", fecha=" + fecha +
                ", metodoPago=" + metodoPago +
                '}';
    }
}