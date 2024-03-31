
package modelo;


public abstract class regEmpleado {
    private int idEmpl,   idRol;
    private Integer cedulaEmpl, celEmpl;
    private String nombreEmpl, apellidoEmpl, userEmpl, claveEmpl, nombreRol, direccion;

    public regEmpleado() {
    }
     
    public regEmpleado(int idEmpl, Integer cedulaEmpl, Integer celEmpl, int idRol, String nombreEmpl, String apellidoEmpl, String userEmpl, String claveEmpl, String nombreRol, String direccion) {
        this.idEmpl = idEmpl;
        this.cedulaEmpl = cedulaEmpl;
        this.celEmpl = celEmpl;
        this.idRol = idRol;
        this.nombreEmpl = nombreEmpl;
        this.apellidoEmpl = apellidoEmpl;
        this.userEmpl = userEmpl;
        this.claveEmpl = claveEmpl;
        this.nombreRol = nombreRol;
        this.direccion = direccion;
    }

    public int getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(int idEmpl) {
        this.idEmpl = idEmpl;
    }

    public int getCedulaEmpl() {
        return cedulaEmpl;
    }

    public void setCedulaEmpl(Integer cedulaEmpl) {
        this.cedulaEmpl = cedulaEmpl;
    }

    public int getCelEmpl() {
        return celEmpl;
    }

    public void setCelEmpl(Integer celEmpl) {
        this.celEmpl = celEmpl;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreEmpl() {
        return nombreEmpl;
    }

    public void setNombreEmpl(String nombreEmpl) {
        this.nombreEmpl = nombreEmpl;
    }

    public String getApellidoEmpl() {
        return apellidoEmpl;
    }

    public void setApellidoEmpl(String apellidoEmpl) {
        this.apellidoEmpl = apellidoEmpl;
    }

    public String getUserEmpl() {
        return userEmpl;
    }

    public void setUserEmpl(String userEmpl) {
        this.userEmpl = userEmpl;
    }

    public String getClaveEmpl() {
        return claveEmpl;
    }

    public void setClaveEmpl(String claveEmpl) {
        this.claveEmpl = claveEmpl;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    
    

}
