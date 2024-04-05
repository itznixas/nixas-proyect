/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class cierreCaja extends regEmpleado {
    protected int idCaja;
    protected float saldoInicio, entrada, caja, valorActual;
    protected String horaCierre, fechaCierre;

    public cierreCaja(int idCaja, float saldoInicio, float entrada, float caja, float valorActual, String horaCierre, String fechaCierre, int idEmpl, Integer cedulaEmpl, Integer celEmpl, int idRol, String nombreEmpl, String apellidoEmpl, String userEmpl, String claveEmpl, String nombreRol, String direccion) {
        super(idEmpl, cedulaEmpl, celEmpl, idRol, nombreEmpl, apellidoEmpl, userEmpl, claveEmpl, nombreRol, direccion);
        this.idCaja = idCaja;
        this.saldoInicio = saldoInicio;
        this.entrada = entrada;
        this.caja = caja;
        this.valorActual = valorActual;
        this.horaCierre = horaCierre;
        this.fechaCierre = fechaCierre;
    }

    public cierreCaja() {
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public float getSaldoInicio() {
        return saldoInicio;
    }

    public void setSaldoInicio(float saldoInicio) {
        this.saldoInicio = saldoInicio;
    }

    public float getEntrada() {
        return entrada;
    }

    public void setEntrada(float entrada) {
        this.entrada = entrada;
    }

    public float getCaja() {
        return caja;
    }

    public void setCaja(float caja) {
        this.caja = caja;
    }

    public float getValorActual() {
        return valorActual;
    }

    public void setValorActual(float valorActual) {
        this.valorActual = valorActual;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getUserEmpl() {
        return userEmpl;
    }

    public void setUserEmpl(String userEmpl) {
        this.userEmpl = userEmpl;
    }
    
    
}
