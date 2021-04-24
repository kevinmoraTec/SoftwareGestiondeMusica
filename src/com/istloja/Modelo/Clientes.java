package com.istloja.Modelo;
 import com.istloja.ConexionBD.Conexion_base_de_Datos;
import com.istloja.Controlador.ClienteBD;
import com.istloja.Utilidades.Utilidades;
import java.sql.Date;

/**
 *
 * @author danielmora
 */
public class Clientes {
    private Utilidades  utilidades;
    
    private int idcliente;
    private String cedula;
    private String nombre;
    private String apellido;
    private String edad;
    private String direcion;
    private String telefono;
    private String artista;
    private String musica;
    private String genero;
    private String vinculo;
    private String añoMusica;
    private Date fecha_registro;
    private Date fechaActualizacion;

    public Clientes() {
    }
    
    

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public String getAñoMusica() {
        return añoMusica;
    }

    public void setAñoMusica(String añoMusica) {
        this.añoMusica = añoMusica;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFechaActualizacion() {
        // txtfechaCliente.setText(utilidades.devolverFechaFormato(utilidades.devolverFechaactual()))
        System.out.println("gecha actulixaciom"+fechaActualizacion);
        return fechaActualizacion ;//= Date.valueOf(utilidades.devolverFechaFormato(utilidades.devolverFechaactual()));
        
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        //fechaActualizacion = Date.valueOf(utilidades.devolverFechaFormato(utilidades.devolverFechaactual()));
       // 
       this.fechaActualizacion = fechaActualizacion;
    }
    

    @Override
    public String toString() {
        return "Clientes{" + "idcliente=" + idcliente + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", musica=" + musica + ", vinculo=" + vinculo + ", a\u00f1oMusica=" + añoMusica + ", fecha_registro=" + fecha_registro + '}';
    }
    
    
    
    
    public static void main(String[] args) {
        
        
        ClienteBD bD = new ClienteBD();
        Clientes clientes = new Clientes();
        clientes.setCedula("1105138166");
        clientes.setNombre("daniel");
        clientes.setApellido("Mora");
        clientes.setDirecion("loja");
        clientes.setTelefono("0995736565");
        clientes.setEdad("22");
        clientes.setArtista("Daddy Yanke");
        clientes.setMusica("La gasolina");
        clientes.setGenero("Regueton");
        clientes.setAñoMusica("2017");
        clientes.setVinculo("ww.google.com");
        clientes.setFecha_registro(Date.valueOf("2019-09-09"));
        if (bD.registrarCliente(clientes)) {
            System.out.println("si se rEGISTRO");
        }else{
            System.out.println(" no se Guardo");
        }
        
        
    
    
    }
    
}
