/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public abstract class producto extends categoriaProd  {
    protected String nombreProd;
    protected int  cantidad;
    protected float precio;

    public producto(String nombreProd, int cantidad, float precio, int idCategoria, String nombreCategoria) {
        super(idCategoria, nombreCategoria);
        this.nombreProd = nombreProd;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public producto() {
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
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

    @Override
    public int getIdCategoria() {
        return idCategoria;
    }

    @Override
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    @Override
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    

   
}
