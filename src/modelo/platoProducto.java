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

    public platoProducto(int id_plato, String nombreProd, int cantidad, float precio, int idCategoria, String nombreCategoria) {
        super(nombreProd, cantidad, precio, idCategoria, nombreCategoria);
        this.id_plato = id_plato;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    @Override
    public String getNombreProd() {
        return nombreProd;
    }

    @Override
    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
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
