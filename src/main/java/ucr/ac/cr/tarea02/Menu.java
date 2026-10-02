/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea02;

import javax.swing.JOptionPane;

/**
 *
 * @author naomy
 */
public class Menu {
 private SistemaPrestamos sistema = new SistemaPrestamos();

    public void iniciar() {
        int opcion;

        do {
            String texto = JOptionPane.showInputDialog(null,
                    "SISTEMA DE PRÉSTAMO DE EQUIPOS\n\n"
                    + "1. Consultar catálogo\n"
                    + "2. Prestar equipo\n"
                    + "3. Devolver equipo\n"
                    + "4. Consultar multas\n"
                    + "5. Mostrar resumen\n"
                    + "6. Salir\n\n"
                    + "Seleccione una opción:",
                    "Menú", JOptionPane.QUESTION_MESSAGE);

            // Si presiona Cancelar, se sale
            if (texto == null) {
                opcion = 6;
            } else {
                opcion = convertirEntero(texto);
            }

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, sistema.consultarCatalogo());
                    break;
                case 2:
                    prestar();
                    break;
                case 3:
                    devolver();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, sistema.consultarMultas());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, sistema.mostrarResumen());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema. Hasta pronto!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private void prestar() {
        String texto = JOptionPane.showInputDialog(null,
                sistema.consultarCatalogo() + "\nPosición del equipo a prestar:");
        if (texto == null) {
            return;
        }
        int posicion = convertirEntero(texto);
        JOptionPane.showMessageDialog(null, sistema.prestarEquipo(posicion));
    }

    private void devolver() {
        String textoPosicion = JOptionPane.showInputDialog(null,
                sistema.consultarCatalogo() + "\nPosición del equipo a devolver:");
        if (textoPosicion == null) {
            return;
        }
        String textoDias = JOptionPane.showInputDialog(null, "Días de atraso:");
        if (textoDias == null) {
            return;
        }
        int posicion = convertirEntero(textoPosicion);
        int dias = convertirEntero(textoDias);
        JOptionPane.showMessageDialog(null, sistema.devolverEquipo(posicion, dias));
    }

    // Devuelve -1 si el texto no es un número válido
    private int convertirEntero(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}//fin de la clase
