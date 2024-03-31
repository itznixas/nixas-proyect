
package modelo;

public class prodPreparacion extends platoProducto{
    protected int idPreparacion;

    public prodPreparacion(int idPreparacion, int id_plato, String nombreProd, int cantidad, float precio, int idCategoria, String nombreCategoria) {
        super(id_plato, nombreProd, cantidad, precio, idCategoria, nombreCategoria);
        this.idPreparacion = idPreparacion;
    }

    public int getIdPreparacion() {
        return idPreparacion;
    }

    public void setIdPreparacion(int idPreparacion) {
        this.idPreparacion = idPreparacion;
    }

    @Override
    public int getId_plato() {
        return id_plato;
    }

    @Override
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
