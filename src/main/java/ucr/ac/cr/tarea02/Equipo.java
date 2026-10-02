/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea02;

/**
 *
 * @author naomy
 */
public class Equipo {
    private String codigo;
    private String nombre;
    private String tipo;
    private boolean disponible;
    private int tarifaMulta;

    // Todo equipo inicia disponible
    public Equipo(String codigo, String nombre, String tipo, int tarifaMulta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tarifaMulta = tarifaMulta;
        this.disponible = true;
    }

    // Getters
    public String getCodigo() { 
        
        return codigo;
    }
    
  
    public String getNombre() { 
        
        return nombre; 
    }
    
    
    public String getTipo() { 
        
        return tipo; 
    }
    
    
    public boolean isDisponible() { 
        
        return disponible; 
    }
    
    
    public int getTarifaMulta() { 
        
        return tarifaMulta;
    }

    // Setters
    public void setCodigo(String codigo) {
        
        this.codigo = codigo; 
    }
    
    
    public void setNombre(String nombre) { 
        
        this.nombre = nombre; 
    }
    
    
    public void setTipo(String tipo) {
        
        this.tipo = tipo;
    }
    
    
    public void setDisponible(boolean disponible) {
        
        this.disponible = disponible; 
    }
    
    
    public void setTarifaMulta(int tarifaMulta) { 
        
        this.tarifaMulta = tarifaMulta; 
    }
    

    // Cambian el estado del objeto
    public void prestar() {
        this.disponible = false;
    }//fin metodo

    public void devolver() {
        this.disponible = true;
    }//fin metodo

    // Multa = días de atraso x tarifa del equipo
    public int calcularMulta(int diasAtraso) {
        return diasAtraso * tarifaMulta;
    }//fin metodo

    // Información del equipo como String
    public String obtenerInformacion() {
        return codigo + " | " + nombre + " | " + tipo + " | "
                + (disponible ? "Disponible" : "Prestado");
    }//fin metodo 
}// fin de la clase

