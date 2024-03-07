
package modelo;


public  class regEmpleado extends empleadoRol {
    private int idEmpl, cedulaEmpl, celEmpl, claveEmpl;
    private String nombreEmpl, apellidoEmpl, userEmpl;

    public regEmpleado() {
    }

    
    public regEmpleado(int idEmpl, String nombreEmpl, String apellidoEmpl, 
            int cedulaEmpl, int celEmpl, int idRol, String nombreRol,String userEmpl, int claveEmpl ) {
        super(idRol, nombreRol);
        this.idEmpl = idEmpl; //
        this.cedulaEmpl = cedulaEmpl;//
        this.celEmpl = celEmpl;//
        this.claveEmpl = claveEmpl; //
        this.nombreEmpl = nombreEmpl; //
        this.apellidoEmpl = apellidoEmpl;
        this.userEmpl = userEmpl;
       
    }

    public int getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(int idEmpl) {
        this.idEmpl = idEmpl;
    }
       //2
    public int getCedulaEmpl() {
        return cedulaEmpl;
    }

    public void setCedulaEmpl(int cedulaEmpl) {
        this.cedulaEmpl = cedulaEmpl;
    }
        //3
    public int getCelEmpl() {
        return celEmpl;
    }

    public void setCelEmpl(int celEmpl) {
        this.celEmpl = celEmpl;
    }
    //4
    public int getClaveEmpl() {
        return claveEmpl;
    }

    public void setClaveEmpl(int claveEmpl) {
        this.claveEmpl = claveEmpl;
    }
        //5

        //6
    public String getNombreEmpl() {
        return nombreEmpl;
    }

    public void setNombreEmpl(String nombreEmpl) {
        this.nombreEmpl = nombreEmpl;
    }
        //7
    public String getApellidoEmpl() {
        return apellidoEmpl;
    }

    public void setApellidoEmpl(String apellidoEmpl) {
        this.apellidoEmpl = apellidoEmpl;
    }
        //8
    public String getUserEmpl() {
        return userEmpl;
    }

    public void setUserEmpl(String userEmpl) {
        this.userEmpl = userEmpl;
    }
    //9
    @Override
    public String getNombreRol() {
        return nombreRol;
    }

    @Override
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    @Override
        public int getIdRol() {
        return idRol;
    }

    @Override
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

}
