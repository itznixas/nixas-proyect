package modelo;

public abstract class tmpPedidos extends regEmpleado {
    protected int idMesas, idPedidos, mesero, cantidad;
    protected String producto, estado, hora;

    // Constructor con parámetros
    public tmpPedidos(int idMesas, int idPedidos, int mesero, int cantidad, String hora, String producto, String estado, int idEmpl, Integer cedulaEmpl, Integer celEmpl, int idRol, String nombreEmpl, String apellidoEmpl, String userEmpl, String claveEmpl, String nombreRol, String direccion) {
        super(idEmpl, cedulaEmpl, celEmpl, idRol, nombreEmpl, apellidoEmpl, userEmpl, claveEmpl, nombreRol, direccion);
        this.idMesas = idMesas;
        this.idPedidos = idPedidos;
        this.mesero = mesero;
        this.cantidad = cantidad;
        this.hora = hora;
        this.producto = producto;
        this.estado = estado;
    }

    // Constructor sin parámetros
    public tmpPedidos() {
        super(); // Llama al constructor de la clase padre si es necesario
    }

    // Métodos getters y setters
    public int getIdMesas() {
        return idMesas; 
    }

    public void setIdMesas(int idMesas) {
        this.idMesas = idMesas;
    }

    public int getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    public int getMesero() {
        return mesero;
    }

    public void setMesero(int mesero) {
        this.mesero = mesero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
