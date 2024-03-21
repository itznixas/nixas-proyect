
package modelo;

public class prodPreparacion extends platoProducto{
    protected int idPreparacion;

    public prodPreparacion() {
       
    }

    public prodPreparacion(int idPreparacion, int id_plato, String nombre, int id_porciones, int cantidad, float precio) {
        super(id_plato, nombre, id_porciones, cantidad, precio);
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
    
}
