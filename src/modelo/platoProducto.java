/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Royer
 */
public abstract class platoProducto extends producto {
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

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getId_porciones() {
        return id_porciones;
    }

    @Override
    public void setId_porciones(int id_porciones) {
        this.id_porciones = id_porciones;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public float getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
