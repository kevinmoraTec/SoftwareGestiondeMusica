package com.istloja.Modelo;

import java.sql.Date;

public class Proveedores {
    private int id_Provedore;
    private String ruc;
    private String razon_social;
    private String tipo_actividad;
    private String nombre_representante;
    private String apellido_representante;
    private String telefono;
    private String correo;
    private String direccion;
    private String estado_deuda;
    private Date fecha_Registro;
    private Date fecha_actuslizacion;

    public Proveedores() {
    }
    
    

    public int getId_Provedore() {
        return id_Provedore;
    }

    public void setId_Provedore(int id_Provedore) {
        this.id_Provedore = id_Provedore;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTipo_actividad() {
        return tipo_actividad;
    }

    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }

    public String getNombre_representante() {
        return nombre_representante;
    }

    public void setNombre_representante(String nombre_representante) {
        this.nombre_representante = nombre_representante;
    }

    public String getApellido_representante() {
        return apellido_representante;
    }

    public void setApellido_representante(String apellido_representante) {
        this.apellido_representante = apellido_representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado_deuda() {
        return estado_deuda;
    }

    public void setEstado_deuda(String estado_deuda) {
        this.estado_deuda = estado_deuda;
    }

    public Date getFecha_Registro() {
        return fecha_Registro;
    }

    public void setFecha_Registro(Date fecha_Registro) {
        this.fecha_Registro = fecha_Registro;
    }

    public Date getFecha_actuslizacion() {
        return fecha_actuslizacion;
    }

    public void setFecha_actuslizacion(Date fecha_actuslizacion) {
        this.fecha_actuslizacion = fecha_actuslizacion;
    }
    
    
    
}
