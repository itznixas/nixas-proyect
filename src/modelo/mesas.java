/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalTime;

/**
 *
 * @author Royer
 */
public class mesas extends tmpPedidos{
    protected int cantSillas;
    protected String tipoMesa, estadoMesa;

    public mesas(int cantSillas, String tipoMesa, String estadoMesa, int idMesas, int idPedidos, int mesero, int cantidad, LocalTime hora, String producto, String estado, int idEmpl, Integer cedulaEmpl, Integer celEmpl, int idRol, String nombreEmpl, String apellidoEmpl, String userEmpl, String claveEmpl, String nombreRol, String direccion) {
        super(idMesas, idPedidos, mesero, cantidad, hora, producto, estado, idEmpl, cedulaEmpl, celEmpl, idRol, nombreEmpl, apellidoEmpl, userEmpl, claveEmpl, nombreRol, direccion);
        this.cantSillas = cantSillas;
        this.tipoMesa = tipoMesa;
        this.estadoMesa = estadoMesa;
    }

    

    public mesas() {
    }

    public int getCantSillas() {
        return cantSillas;
    }

    public void setCantSillas(int cantSillas) {
        this.cantSillas = cantSillas;
    }

    public String getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(String tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    public String getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    @Override
    public int getIdMesas() {
        return idMesas;
    }

    @Override
    public void setIdMesas(int idMesas) {
        this.idMesas = idMesas;
    }
    
    
}
