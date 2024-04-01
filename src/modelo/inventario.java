
package modelo;


public class inventario extends producto{
    protected int fecha, idEntrada, idSalida, canEntrada, cantSalida;

    public inventario(int fecha, int idEntrada, int idSalida, int canEntrada, int cantSalida, String nombreProd, int cantidad, float precio, int idCategoria, String nombreCategoria) {
        super(nombreProd, cantidad, precio, idCategoria, nombreCategoria);
        this.fecha = fecha;
        this.idEntrada = idEntrada;
        this.idSalida = idSalida;
        this.canEntrada = canEntrada;
        this.cantSalida = cantSalida;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public int getCanEntrada() {
        return canEntrada;
    }

    public void setCanEntrada(int canEntrada) {
        this.canEntrada = canEntrada;
    }

    public int getCantSalida() {
        return cantSalida;
    }

    public void setCantSalida(int cantSalida) {
        this.cantSalida = cantSalida;
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
    public int getIdCategoria() {
        return idCategoria;
    }

    @Override
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

   

    public inventario() {
    }

    
    
    
    
    
    
}
