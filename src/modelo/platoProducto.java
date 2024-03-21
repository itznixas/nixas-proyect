/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Royer
 */
public class platoProducto extends producto {
    protected int id_plato;

    public platoProducto() {
   
    }

    public platoProducto(int id_plato, String nombre, int id_porciones, int cantidad, float precio) {
        super(nombre, id_porciones, cantidad, precio);
        this.id_plato = id_plato;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_porciones() {
        return id_porciones;
    }

    public void setId_porciones(int id_porciones) {
        this.id_porciones = id_porciones;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
