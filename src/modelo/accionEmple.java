/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.*;
/**
 *
 * @author Royer
 */
public  abstract class accionEmple extends regEmpleado{
    protected int idAccion, fechaAccion, horaAccion;
    protected String nombreAccion;

    public accionEmple() {
    }

    public accionEmple(int idAccion, int fechaAccion, int horaAccion, String nombreAccion, int idEmpl, Integer cedulaEmpl, Integer celEmpl, int idRol, String nombreEmpl, String apellidoEmpl, String userEmpl, String claveEmpl, String nombreRol, String direccion) {
        super(idEmpl, cedulaEmpl, celEmpl, idRol, nombreEmpl, apellidoEmpl, userEmpl, claveEmpl, nombreRol, direccion);
        this.idAccion = idAccion;
        this.fechaAccion = fechaAccion;
        this.horaAccion = horaAccion;
        this.nombreAccion = nombreAccion;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public int getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(int fechaAccion) {
        this.fechaAccion = fechaAccion;
    }

    public int getHoraAccion() {
        return horaAccion;
    }

    public void setHoraAccion(int horaAccion) {
        this.horaAccion = horaAccion;
    }

    public String getNombreAccion() {
        return nombreAccion;
    }

    public void setNombreAccion(String nombreAccion) {
        this.nombreAccion = nombreAccion;
    }

    @Override
    public String getUserEmpl() {
        return userEmpl;
    }

    @Override
    public void setUserEmpl(String userEmpl) {
        this.userEmpl = userEmpl;
    }
    
    
    
}
