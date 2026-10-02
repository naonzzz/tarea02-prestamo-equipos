/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea02;

/**
 *
 * @author naomy
 */
public class SistemaPrestamos {
    private Equipo[] equipos = new Equipo[5];
    private int[] diasAtraso = new int[5];

    public SistemaPrestamos() {
        inicializarCatalogo();
    }

    private void inicializarCatalogo() {
        equipos[0] = new Equipo("EQ01", "Cámara DSLR", "Cámara", 500);
        equipos[1] = new Equipo("EQ02", "Trípode", "Soporte", 500);
        equipos[2] = new Equipo("EQ03", "Micrófono", "Audio", 500);
        equipos[3] = new Equipo("EQ04", "Tableta gráfica", "Diseño", 500);
        equipos[4] = new Equipo("EQ05", "Kit de iluminación", "Iluminación", 800);
        // diasAtraso ya inicia en 0 por defecto
    }

    // La posición visible va de 1 a 5
    public boolean posicionValida(int posicion) {
        return posicion >= 1 && posicion <= equipos.length;
    }

    // Opción 1
    public String consultarCatalogo() {
        String resultado = "CATÁLOGO DE EQUIPOS\n\n";
        for (int i = 0; i < equipos.length; i++) {
            resultado += (i + 1) + ". " + equipos[i].obtenerInformacion() + "\n";
        }
        return resultado;
    }

    // Opción 2
    public String prestarEquipo(int posicion) {
        if (!posicionValida(posicion)) {
            return "Posición inválida. Debe estar entre 1 y " + equipos.length + ".";
        }
        int i = posicion - 1;
        if (!equipos[i].isDisponible()) {
            return "El equipo " + equipos[i].getNombre() + " ya está prestado.";
        }
        equipos[i].prestar();
        diasAtraso[i] = 0; // nuevo préstamo, se reinicia el atraso
        return "Equipo prestado: " + equipos[i].getNombre();
    }

    // Opción 3
    public String devolverEquipo(int posicion, int dias) {
        if (!posicionValida(posicion)) {
            return "Posición inválida. Debe estar entre 1 y " + equipos.length + ".";
        }
        if (dias < 0) {
            return "Los días de atraso no pueden ser negativos.";
        }
        int i = posicion - 1;
        if (equipos[i].isDisponible()) {
            return "El equipo " + equipos[i].getNombre() + " no está prestado.";
        }
        equipos[i].devolver();
        diasAtraso[i] = dias;
        return "Equipo devuelto: " + equipos[i].getNombre()
                + "\nDías de atraso: " + dias
                + "\nMulta: ₡" + equipos[i].calcularMulta(dias);
    }

    // Opción 4
    public String consultarMultas() {
        String resultado = "MULTAS DEL ÚLTIMO PRÉSTAMO\n\n";
        for (int i = 0; i < equipos.length; i++) {
            resultado += (i + 1) + ". " + equipos[i].getNombre()
                    + " | Días de atraso: " + diasAtraso[i]
                    + " | Multa: ₡" + equipos[i].calcularMulta(diasAtraso[i]) + "\n";
        }
        return resultado;
    }

    // Opción 5
    public String mostrarResumen() {
        int disponibles = 0;
        int prestados = 0;
        int totalDias = 0;
        int totalMultas = 0;

        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i].isDisponible()) {
                disponibles++;
            } else {
                prestados++;
            }
            totalDias += diasAtraso[i];
            totalMultas += equipos[i].calcularMulta(diasAtraso[i]);
        }

        return "RESUMEN\n\n"
                + "Equipos disponibles: " + disponibles + "\n"
                + "Equipos prestados: " + prestados + "\n"
                + "Total de días de atraso: " + totalDias + "\n"
                + "Total de multas: ₡" + totalMultas;
    }
}//fin clase
