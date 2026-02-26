import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Ingrese nombre del cliente:");
        String cedula = JOptionPane.showInputDialog("Ingrese cédula:");
        String telefono = JOptionPane.showInputDialog("Ingrese teléfono:");
        String categoria = JOptionPane.showInputDialog("Categoría (VIP o Regular):");

        int mes;

        do {
            mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número del mes (1-12):"));
            if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(null, "Mes inválido. Intente nuevamente.");
            }
        } while (mes < 1 || mes > 12);

        double totalGeneral = 0;
        int puntosTotales = 0;
        int cantidadVehiculos = 0;

        String continuar;

        do {

            String placa = JOptionPane.showInputDialog("Placa del vehículo:");
            String marca = JOptionPane.showInputDialog("Marca:");
            double precioDia = Double.parseDouble(JOptionPane.showInputDialog("Precio por día:"));

            int dias;
            do {
                dias = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de días:"));
                if (dias <= 0) {
                    JOptionPane.showMessageDialog(null, "Los días deben ser mayores a 0.");
                }
            } while (dias <= 0);

            int seguroOp = JOptionPane.showConfirmDialog(null, "¿Incluye seguro completo?");
            boolean seguro = (seguroOp == JOptionPane.YES_OPTION);

            int gpsOp = JOptionPane.showConfirmDialog(null, "¿Incluye GPS?");
            boolean gps = (gpsOp == JOptionPane.YES_OPTION);

            Vehiculo v = new Vehiculo(placa, marca, precioDia, dias, seguro, gps);

            double subtotal = v.calcularSubtotal();
            int puntos = v.calcularPuntos();

            totalGeneral += subtotal;
            puntosTotales += puntos;
            cantidadVehiculos++;

            JOptionPane.showMessageDialog(null,
                    "Subtotal vehículo " + placa + ": " + subtotal +
                    "\nPuntos ganados: " + puntos);

            continuar = JOptionPane.showInputDialog("¿Desea ingresar otro vehículo? (si/no)");

        } while (continuar.equalsIgnoreCase("si"));

        double totalFinal = totalGeneral;

        if (categoria.equalsIgnoreCase("VIP")) {
            totalFinal = totalGeneral - (totalGeneral * 0.05);
            puntosTotales = puntosTotales * 2;
        }

        String resumen = "==============================\n";
        resumen += "RESUMEN FINAL DE ALQUILERES\n";
        resumen += "==============================\n";
        resumen += "Cliente: " + nombre + "\n";
        resumen += "Cédula: " + cedula + "\n";
        resumen += "Categoría: " + categoria + "\n";
        resumen += "Mes: " + obtenerMes(mes) + "\n";
        resumen += "---------------------------------\n";
        resumen += "Cantidad de vehículos: " + cantidadVehiculos + "\n";
        resumen += "Subtotal acumulado: " + totalGeneral + "\n";
        resumen += "---------------------------------\n";
        resumen += "TOTAL A PAGAR: " + totalFinal + "\n";
        resumen += "PUNTOS TOTALES: " + puntosTotales + "\n";
        resumen += "==============================";

        JOptionPane.showMessageDialog(null, resumen);
    }

    public static String obtenerMes(int mes) {

        String nombreMes = "";

        switch (mes) {
            case 1: nombreMes = "Enero"; break;
            case 2: nombreMes = "Febrero"; break;
            case 3: nombreMes = "Marzo"; break;
            case 4: nombreMes = "Abril"; break;
            case 5: nombreMes = "Mayo"; break;
            case 6: nombreMes = "Junio"; break;
            case 7: nombreMes = "Julio"; break;
            case 8: nombreMes = "Agosto"; break;
            case 9: nombreMes = "Septiembre"; break;
            case 10: nombreMes = "Octubre"; break;
            case 11: nombreMes = "Noviembre"; break;
            case 12: nombreMes = "Diciembre"; break;
        }

        return nombreMes;
    }
}