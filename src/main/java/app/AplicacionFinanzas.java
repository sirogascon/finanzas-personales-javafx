package app;

import model.CategoriaGasto;
import model.Gasto;
import model.Ingreso;

import java.util.ArrayList;

public class AplicacionFinanzas {

    private ArrayList<Gasto> gastos;
    private ArrayList<Ingreso> ingresos;

    public AplicacionFinanzas() {
        gastos = new ArrayList<>();
        ingresos = new ArrayList<>();
    }

    // GASTOS
    public void anadirGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public ArrayList<Gasto> getGastos() {
        return gastos;
    }

    public boolean hayGastos() {
        return !gastos.isEmpty();
    }

    public void eliminarGasto(int posicion) {
        gastos.remove(posicion);
    }

    public void modificarImporteGasto(int posicion, double nuevoImporte) {
        gastos.get(posicion).setImporte(nuevoImporte);
    }

    // INGRESOS
    public void anadirIngreso(Ingreso ingreso) {
        ingresos.add(ingreso);
    }

    public ArrayList<Ingreso> getIngresos() {
        return ingresos;
    }

    public boolean hayIngresos() {
        return !ingresos.isEmpty();
    }

    public void eliminarIngreso(int posicion) {
        ingresos.remove(posicion);
    }

    public void modificarImporteIngreso(int posicion, double nuevoImporte) {
        ingresos.get(posicion).setImporte(nuevoImporte);
    }

    // RESUMEN FINANCIERO
    public double calcularTotalGastos() {
        double total = 0;

        for (int i = 0; i < gastos.size(); i++) {
            total = total + gastos.get(i).getImporte();
        }

        return total;
    }

    public double calcularTotalIngresos() {
        double total = 0;

        for (int i = 0; i < ingresos.size(); i++) {
            total = total + ingresos.get(i).getImporte();
        }

        return total;
    }

    public double calcularSaldoTotal() {
        return calcularTotalIngresos() - calcularTotalGastos();
    }

    public double calcularTotalGastosPorCategoria(CategoriaGasto categoria) {
        double total = 0;

        for (int i = 0; i < gastos.size(); i++) {
            if (gastos.get(i).getCategoria() == categoria) {
                total = total + gastos.get(i).getImporte();
            }
        }

        return total;
    }
}