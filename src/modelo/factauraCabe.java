/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public abstract class factauraCabe {
    protected int idCabFac, idCli, idMesero, idCajero;
    protected float descuento, iva, total;
    protected String horaFact, fechaFact, idTipoPago;

    public factauraCabe(int idCabFac, int idCli, int idMesero, int idCajero, float descuento, float iva, float total, String horaFact, String fechaFact, String idTipoPago) {
        this.idCabFac = idCabFac;
        this.idCli = idCli;
        this.idMesero = idMesero;
        this.idCajero = idCajero;
        this.descuento = descuento;
        this.iva = iva;
        this.total = total;
        this.horaFact = horaFact;
        this.fechaFact = fechaFact;
        this.idTipoPago = idTipoPago;
    }

    public factauraCabe() {
    }

    public int getIdCabFac() {
        return idCabFac;
    }

    public void setIdCabFac(int idCabFac) {
        this.idCabFac = idCabFac;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getHoraFact() {
        return horaFact;
    }

    public void setHoraFact(String horaFact) {
        this.horaFact = horaFact;
    }

    public String getFechaFact() {
        return fechaFact;
    }

    public void setFechaFact(String fechaFact) {
        this.fechaFact = fechaFact;
    }

    public String getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(String idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
    
    
}
