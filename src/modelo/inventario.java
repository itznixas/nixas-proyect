package modelo;


public  class inventario {
    protected int idIvTmp, idProSalida, idProEntrada, cantEntrada, cantSalida;
    protected String fechaInvEntrada, nomEntrada, nomSalida, fechaInvSalida;

    public inventario(int idIvTmp, int idProSalida, int idProEntrada, int cantEntrada, int cantSalida, String fechaInvEntrada, String nomEntrada, String nomSalida, String fechaInvSalida) {
        this.idIvTmp = idIvTmp;
        this.idProSalida = idProSalida;
        this.idProEntrada = idProEntrada;
        this.cantEntrada = cantEntrada;
        this.cantSalida = cantSalida;
        this.fechaInvEntrada = fechaInvEntrada;
        this.nomEntrada = nomEntrada;
        this.nomSalida = nomSalida;
        this.fechaInvSalida = fechaInvSalida;
    }

    public inventario() {
    }

    public int getIdIvTmp() {
        return idIvTmp;
    }

    public void setIdIvTmp(int idIvTmp) {
        this.idIvTmp = idIvTmp;
    }

    public int getIdProSalida() {
        return idProSalida;
    }

    public void setIdProSalida(int idProSalida) {
        this.idProSalida = idProSalida;
    }

    public int getIdProEntrada() {
        return idProEntrada;
    }

    public void setIdProEntrada(int idProEntrada) {
        this.idProEntrada = idProEntrada;
    }

    public int getCantEntrada() {
        return cantEntrada;
    }

    public void setCantEntrada(int cantEntrada) {
        this.cantEntrada = cantEntrada;
    }

    public int getCantSalida() {
        return cantSalida;
    }

    public void setCantSalida(int cantSalida) {
        this.cantSalida = cantSalida;
    }

    public String getFechaInvEntrada() {
        return fechaInvEntrada;
    }

    public void setFechaInvEntrada(String fechaInvEntrada) {
        this.fechaInvEntrada = fechaInvEntrada;
    }

    public String getNomEntrada() {
        return nomEntrada;
    }

    public void setNomEntrada(String nomEntrada) {
        this.nomEntrada = nomEntrada;
    }

    public String getNomSalida() {
        return nomSalida;
    }

    public void setNomSalida(String nomSalida) {
        this.nomSalida = nomSalida;
    }

    public String getFechaInvSalida() {
        return fechaInvSalida;
    }

    public void setFechaInvSalida(String fechaInvSalida) {
        this.fechaInvSalida = fechaInvSalida;
    }

    
    


}
