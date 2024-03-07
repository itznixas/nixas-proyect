
package modelo;


public abstract class empleadoRol {
    protected int idRol;
    protected String nombreRol,userEmpl,claveEmpl;

    public empleadoRol() {
    }

    public empleadoRol(int idRol, String nombreRol,String userEmpl,String claveEmpl) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.userEmpl = userEmpl;
        this.claveEmpl = claveEmpl;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
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

  

    
    
}
