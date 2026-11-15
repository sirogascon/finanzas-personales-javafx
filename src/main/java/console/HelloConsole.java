package console;

import app.AplicacionFinanzas;
import model.CategoriaGasto;
import model.Gasto;
import model.Ingreso;
import model.MetodoPago;

import java.time.LocalDate;
import java.util.Scanner;

public class HelloConsole {

    private Scanner input = new Scanner(System.in);
    private AplicacionFinanzas aplicacion = new AplicacionFinanzas();

    public static void main(String[] args) {
        HelloConsole programa = new HelloConsole();
        programa.inicio();
    }

    public void inicio() {
        boolean salir = false;

        do {
            mostrarMenuPrincipal();

            if (input.hasNextInt()) {
                int opcion = input.nextInt();
                input.nextLine();

                switch (opcion) {
                    case 1:
                        menuIngresos();
                        break;
                    case 2:
                        menuGastos();
                        break;
                    case 3:
                        mostrarResumenFinanciero();
                        break;
                    case 0:
                        salir = true;
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } else {
                System.out.println("Debes introducir un número");
                input.nextLine();
            }

            System.out.println();

        } while (!salir);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("====================================");
        System.out.println("   GESTIÓN DE FINANZAS PERSONALES   ");
        System.out.println("====================================");
        System.out.println("1. Gestionar ingresos");
        System.out.println("2. Gestionar gastos");
        System.out.println("3. Ver resumen financiero");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void menuGastos() {
        boolean salir = false;

        do {
            mostrarMenuGastos();

            if (input.hasNextInt()) {
                int opcion = input.nextInt();
                input.nextLine();

                switch (opcion) {
                    case 1:
                        anadirGasto();
                        break;
                    case 2:
                        modificarGasto();
                        break;
                    case 3:
                        eliminarGasto();
                        break;
                    case 4:
                        listarGastos();
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } else {
                System.out.println("Debes introducir un número");
                input.nextLine();
            }

            System.out.println();

        } while (!salir);
    }

    public void mostrarMenuGastos() {
        System.out.println("====================================");
        System.out.println("          GESTIÓN DE GASTOS         ");
        System.out.println("====================================");
        System.out.println("1. Añadir gasto");
        System.out.println("2. Modificar gasto");
        System.out.println("3. Eliminar gasto");
        System.out.println("4. Listar gastos");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opción: ");
    }

    public void anadirGasto() {
        System.out.println("=== AÑADIR GASTO ===");

        System.out.print("Descripción: ");
        String descripcion = input.nextLine();

        CategoriaGasto categoria = leerCategoria();
        if (categoria == null) {
            System.out.println("Categoría no válida");
            return;
        }

        double importe = leerImporte();
        if (importe <= 0) {
            System.out.println("El importe debe ser mayor que 0");
            return;
        }

        LocalDate fecha = leerFecha();
        if (fecha == null) {
            System.out.println("La fecha no es válida");
            return;
        }

        MetodoPago metodoPago = leerMetodoPago();
        if (metodoPago == null) {
            System.out.println("Método de pago no válido");
            return;
        }

        Gasto gasto = new Gasto(descripcion, categoria, importe, fecha, metodoPago);
        aplicacion.anadirGasto(gasto);

        System.out.println("Gasto añadido correctamente");
    }

    public void modificarGasto() {
        System.out.println("=== MODIFICAR GASTO ===");

        if (!aplicacion.hayGastos()) {
            System.out.println("No hay gastos registrados");
            return;
        }

        listarGastos();

        System.out.print("Posición del gasto a modificar: ");
        if (!input.hasNextInt()) {
            System.out.println("Debes introducir un número entero");
            input.nextLine();
            return;
        }

        int posicion = input.nextInt();
        input.nextLine();

        if (posicion < 0 || posicion >= aplicacion.getGastos().size()) {
            System.out.println("Posición no válida");
            return;
        }

        double nuevoImporte = leerImporte();
        if (nuevoImporte <= 0) {
            System.out.println("El importe debe ser mayor que 0");
            return;
        }

        aplicacion.modificarImporteGasto(posicion, nuevoImporte);
        System.out.println("Gasto modificado correctamente");
    }

    public void eliminarGasto() {
        System.out.println("=== ELIMINAR GASTO ===");

        if (!aplicacion.hayGastos()) {
            System.out.println("No hay gastos registrados");
            return;
        }

        listarGastos();

        System.out.print("Posición del gasto a eliminar: ");
        if (!input.hasNextInt()) {
            System.out.println("Debes introducir un número entero");
            input.nextLine();
            return;
        }

        int posicion = input.nextInt();
        input.nextLine();

        if (posicion < 0 || posicion >= aplicacion.getGastos().size()) {
            System.out.println("Posición no válida");
            return;
        }

        aplicacion.eliminarGasto(posicion);
        System.out.println("Gasto eliminado correctamente");
    }

    public void listarGastos() {
        System.out.println("=== LISTA DE GASTOS ===");

        if (!aplicacion.hayGastos()) {
            System.out.println("No hay gastos registrados");
            return;
        }

        for (int i = 0; i < aplicacion.getGastos().size(); i++) {
            System.out.println(i + " - " + aplicacion.getGastos().get(i));
        }
    }

    public void menuIngresos() {
        boolean salir = false;

        do {
            mostrarMenuIngresos();

            if (input.hasNextInt()) {
                int opcion = input.nextInt();
                input.nextLine();

                switch (opcion) {
                    case 1:
                        anadirIngreso();
                        break;
                    case 2:
                        modificarIngreso();
                        break;
                    case 3:
                        eliminarIngreso();
                        break;
                    case 4:
                        listarIngresos();
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } else {
                System.out.println("Debes introducir un número");
                input.nextLine();
            }

            System.out.println();

        } while (!salir);
    }

    public void mostrarMenuIngresos() {
        System.out.println("====================================");
        System.out.println("         GESTIÓN DE INGRESOS        ");
        System.out.println("====================================");
        System.out.println("1. Añadir ingreso");
        System.out.println("2. Modificar ingreso");
        System.out.println("3. Eliminar ingreso");
        System.out.println("4. Listar ingresos");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opción: ");
    }

    public void anadirIngreso() {
        System.out.println("=== AÑADIR INGRESO ===");

        System.out.print("Descripción: ");
        String descripcion = input.nextLine();

        double importe = leerImporte();
        if (importe <= 0) {
            System.out.println("El importe debe ser mayor que 0");
            return;
        }

        LocalDate fecha = leerFecha();
        if (fecha == null) {
            System.out.println("La fecha no es válida");
            return;
        }

        System.out.print("Origen: ");
        String origen = input.nextLine();

        if (origen.isEmpty()) {
            System.out.println("El origen es obligatorio");
            return;
        }

        Ingreso ingreso = new Ingreso(descripcion, importe, fecha, origen);
        aplicacion.anadirIngreso(ingreso);

        System.out.println("Ingreso añadido correctamente");
    }

    public void modificarIngreso() {
        System.out.println("=== MODIFICAR INGRESO ===");

        if (!aplicacion.hayIngresos()) {
            System.out.println("No hay ingresos registrados");
            return;
        }

        listarIngresos();

        System.out.print("Posición del ingreso a modificar: ");
        if (!input.hasNextInt()) {
            System.out.println("Debes introducir un número entero");
            input.nextLine();
            return;
        }

        int posicion = input.nextInt();
        input.nextLine();

        if (posicion < 0 || posicion >= aplicacion.getIngresos().size()) {
            System.out.println("Posición no válida");
            return;
        }

        double nuevoImporte = leerImporte();
        if (nuevoImporte <= 0) {
            System.out.println("El importe debe ser mayor que 0");
            return;
        }

        aplicacion.modificarImporteIngreso(posicion, nuevoImporte);
        System.out.println("Ingreso modificado correctamente");
    }

    public void eliminarIngreso() {
        System.out.println("=== ELIMINAR INGRESO ===");

        if (!aplicacion.hayIngresos()) {
            System.out.println("No hay ingresos registrados");
            return;
        }

        listarIngresos();

        System.out.print("Posición del ingreso a eliminar: ");
        if (!input.hasNextInt()) {
            System.out.println("Debes introducir un número entero");
            input.nextLine();
            return;
        }

        int posicion = input.nextInt();
        input.nextLine();

        if (posicion < 0 || posicion >= aplicacion.getIngresos().size()) {
            System.out.println("Posición no válida");
            return;
        }

        aplicacion.eliminarIngreso(posicion);
        System.out.println("Ingreso eliminado correctamente");
    }

    public void listarIngresos() {
        System.out.println("=== LISTA DE INGRESOS ===");

        if (!aplicacion.hayIngresos()) {
            System.out.println("No hay ingresos registrados");
            return;
        }

        for (int i = 0; i < aplicacion.getIngresos().size(); i++) {
            System.out.println(i + " - " + aplicacion.getIngresos().get(i));
        }
    }

    public void mostrarResumenFinanciero() {
        System.out.println("====================================");
        System.out.println("        RESUMEN FINANCIERO          ");
        System.out.println("====================================");

        double totalIngresos = aplicacion.calcularTotalIngresos();
        double totalGastos = aplicacion.calcularTotalGastos();
        double saldoTotal = aplicacion.calcularSaldoTotal();

        System.out.println("Total ingresos: " + totalIngresos + " €");
        System.out.println("Total gastos: " + totalGastos + " €");
        System.out.println("Saldo total: " + saldoTotal + " €");

        System.out.println();
        System.out.println("=== GASTOS POR CATEGORÍA ===");
        System.out.println("ALIMENTACION: " + aplicacion.calcularTotalGastosPorCategoria(CategoriaGasto.ALIMENTACION) + " €");
        System.out.println("TRANSPORTE: " + aplicacion.calcularTotalGastosPorCategoria(CategoriaGasto.TRANSPORTE) + " €");
        System.out.println("OCIO: " + aplicacion.calcularTotalGastosPorCategoria(CategoriaGasto.OCIO) + " €");
        System.out.println("VIVIENDA: " + aplicacion.calcularTotalGastosPorCategoria(CategoriaGasto.VIVIENDA) + " €");
        System.out.println("SALUD: " + aplicacion.calcularTotalGastosPorCategoria(CategoriaGasto.SALUD) + " €");
        System.out.println("OTROS: " + aplicacion.calcularTotalGastosPorCategoria(CategoriaGasto.OTROS) + " €");
    }

    public CategoriaGasto leerCategoria() {
        System.out.println("Categoría:");
        System.out.println("1. ALIMENTACION");
        System.out.println("2. TRANSPORTE");
        System.out.println("3. OCIO");
        System.out.println("4. VIVIENDA");
        System.out.println("5. SALUD");
        System.out.println("6. OTROS");
        System.out.print("Seleccione una opción: ");

        if (!input.hasNextInt()) {
            input.nextLine();
            return null;
        }

        int opcion = input.nextInt();
        input.nextLine();

        switch (opcion) {
            case 1:
                return CategoriaGasto.ALIMENTACION;
            case 2:
                return CategoriaGasto.TRANSPORTE;
            case 3:
                return CategoriaGasto.OCIO;
            case 4:
                return CategoriaGasto.VIVIENDA;
            case 5:
                return CategoriaGasto.SALUD;
            case 6:
                return CategoriaGasto.OTROS;
            default:
                return null;
        }
    }

    public MetodoPago leerMetodoPago() {
        System.out.println("Método de pago:");
        System.out.println("1. EFECTIVO");
        System.out.println("2. TARJETA");
        System.out.println("3. TRANSFERENCIA");
        System.out.println("4. BIZUM");
        System.out.print("Seleccione una opción: ");

        if (!input.hasNextInt()) {
            input.nextLine();
            return null;
        }

        int opcion = input.nextInt();
        input.nextLine();

        switch (opcion) {
            case 1:
                return MetodoPago.EFECTIVO;
            case 2:
                return MetodoPago.TARJETA;
            case 3:
                return MetodoPago.TRANSFERENCIA;
            case 4:
                return MetodoPago.BIZUM;
            default:
                return null;
        }
    }

    public double leerImporte() {
        System.out.print("Importe: ");

        if (input.hasNextDouble()) {
            double importe = input.nextDouble();
            input.nextLine();
            return importe;
        } else {
            input.nextLine();
            return -1;
        }
    }

    public LocalDate leerFecha() {
        System.out.print("Año: ");
        if (!input.hasNextInt()) {
            input.nextLine();
            return null;
        }
        int ano = input.nextInt();

        System.out.print("Mes: ");
        if (!input.hasNextInt()) {
            input.nextLine();
            return null;
        }
        int mes = input.nextInt();

        System.out.print("Día: ");
        if (!input.hasNextInt()) {
            input.nextLine();
            return null;
        }
        int dia = input.nextInt();
        input.nextLine();

        try {
            return LocalDate.of(ano, mes, dia);
        } catch (Exception e) {
            return null;
        }
    }
}