public class Vehiculo {

    private String placa;
    private String marca;
    private double precioDia;
    private int dias;
    private boolean seguroCompleto;
    private boolean gps;

    public Vehiculo(String placa, String marca, double precioDia, int dias, boolean seguroCompleto, boolean gps) {
        this.placa = placa;
        this.marca = marca;
        this.precioDia = precioDia;
        this.dias = dias;
        this.seguroCompleto = seguroCompleto;
        this.gps = gps;
    }

    public String getPlaca() {
        return placa;
    }

    public double calcularSubtotal() {

        double subtotalBase = precioDia * dias;
        double descuento = 0;

        if (dias > 7) {
            descuento = subtotalBase * 0.15;
        }

        double subtotal = subtotalBase - descuento;

        if (seguroCompleto) {
            subtotal += 5000 * dias;
        }

        if (gps) {
            subtotal += 2000 * dias;
        }

        return subtotal;
    }

    public int calcularPuntos() {

        int puntos = 0;

        if (dias > 7) {
            puntos += 5;
        }

        if (seguroCompleto) {
            puntos += 2;
        }

        return puntos;
    }
}