package com.istloja.Controlador;

import com.istloja.ConexionBD.Conexion_base_de_Datos;
import com.istloja.Modelo.Clientes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielmora
 */
public class ClienteBD {

    public boolean registrarCliente(Clientes clientes) {
        boolean registrar = false;
        //Interfaz de comunicacion (acceso a )con  la base de datos // se encuetra e el jdbc
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        // CON fECHA ACTUALIZAR=INSERT INTO `gestionMusica`.`clientes` (`cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `edad`, `atista`, `musica`, `genero`, `año`, `vinculo`, `fecha`, `fechaActualizacion`) VALUES ('1212', 'dani', 'wew', 'dasd', 'asd', '22', 'sad', 'sd', 'asd', 'sa', 'dsad', '2019-09-09', '2019-10-01');
        //Strig sql Dinamico
        String sql = "INSERT INTO `gestionMusica`.`clientes` (`cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `edad`, `atista`, `musica`, `genero`, `año`, `vinculo`, `fecha`) VALUES ('" + clientes.getCedula() + "',"
                + " '" + clientes.getNombre() + "',"
                + " '" + clientes.getApellido() + "',"
                + " '" + clientes.getDirecion() + "',"
                + " '" + clientes.getTelefono() + "',"
                + " '" + clientes.getEdad() + "',"
                + " '" + clientes.getArtista() + "',"
                + " '" + clientes.getMusica() + "',"
                + " '" + clientes.getGenero() + "',"
                + " '" + clientes.getAñoMusica() + "',"
                + " '" + clientes.getVinculo() + "',"
                + " '" + clientes.getFecha_registro() + "');";

        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException E) {
            System.out.println("Error al Registrar Cliente (Cliente bd)" + E.getMessage());
        }
        return registrar;
    }

    public boolean editarClientes(Clientes clientes) {
        boolean registrar = false;
        //Interfaz de comunicacion (acceso a )con  la base de datos // se encuetra e el jdbc
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "UPDATE `gestionMusica`.`clientes` SET `cedula`='" + clientes.getCedula() + "',"
                + " `nombre`='" + clientes.getNombre() + "', "
                + "`apellido`='" + clientes.getApellido() + "',"
                + " `direccion`='" + clientes.getDirecion() + "',"
                + " `telefono`='" + clientes.getTelefono() + "',"
                + " `edad`='" + clientes.getEdad() + "',"
                + " `atista`='" + clientes.getArtista() + "',"
                + " `musica`='" + clientes.getMusica() + "',"
                + " `genero`='" + clientes.getGenero() + "',"
                + " `año`='" + clientes.getAñoMusica() + "',"
                + " `vinculo`='" + clientes.getVinculo() + "',"
                + " `fechaActualizacion`='" + clientes.getFechaActualizacion() + "' WHERE `id_clientes`='" + clientes.getIdcliente() + "';";

        try {
           // Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            stm.execute(sql);
            stm.close();
            con.close();
            registrar = true;
        } catch (SQLException E) {
            System.out.println("Error al Editar Cliente (Cliente bd)" + E.getMessage());
        }
        return registrar;
    }

    public boolean eliminarCliente(Clientes clientes) {
        boolean registrar = false;
        //Interfaz de comunicacion (acceso a )con  la base de datos // se encuetra e el jdbc
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql = "DELETE FROM `gestionMusica`.`clientes` WHERE `id_clientes`='" + clientes.getIdcliente() + "';";
        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();

        } catch (SQLException E) {
            System.out.println("Error al Eliminar Cliente (Cliente bd)" + E.getMessage());
        }
        return registrar;
    }

    /// 
    public Clientes getClienteCedula(String cedula) {

        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;// Obtener los datos de la base de datos 
        Clientes c = null;
        String sql = "SELECT * FROM gestionMusica.clientes where cedula = " + cedula + ";";
        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Clientes();
                c.setIdcliente(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDirecion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setEdad(rs.getString(7));
                c.setArtista(rs.getString(8));
                c.setMusica(rs.getString(9));
                c.setGenero(rs.getString(10));
                c.setAñoMusica(rs.getString(11));
                c.setVinculo(rs.getString(12));
                c.setFecha_registro(rs.getDate(13));
                c.setFechaActualizacion(rs.getDate(14));

            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error buscar Cliente Cedula (Clientebd)" + ex.getMessage());

        }
        return c;
    }

    public List<Clientes> obtenerCliente() {

        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;// Obtener los datos de la base de datos 
        List<Clientes> ListaClientes = new ArrayList<Clientes>();
        String sql = "SELECT * FROM gestionMusica.clientes;";
        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Clientes c = new Clientes();
                c = new Clientes();
                c.setIdcliente(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDirecion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setEdad(rs.getString(7));
                c.setArtista(rs.getString(8));
                c.setMusica(rs.getString(9));
                c.setGenero(rs.getString(10));
                c.setAñoMusica(rs.getString(11));
                c.setVinculo(rs.getString(12));
                c.setFecha_registro(rs.getDate(13));
                c.setFechaActualizacion(rs.getDate(14));
                ListaClientes.add(c);

            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error obeterCliente(Clientebd)" + ex.getMessage());

        }
        return ListaClientes;
    }

    public List<Clientes> obtenerClienteCedula(String cedula) {

        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;// Obtener los datos de la base de datos 

        String sql = "SELECT * FROM gestionMusica.clientes where cedula like \"%" + cedula + "%\"";
        List<Clientes> ListaClientes = new ArrayList<Clientes>();
        try {
            //Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Clientes c = new Clientes();

                c.setIdcliente(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDirecion(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setEdad(rs.getString(7));
                c.setArtista(rs.getString(8));
                c.setMusica(rs.getString(9));
                c.setGenero(rs.getString(10));
                c.setAñoMusica(rs.getString(11));
                c.setVinculo(rs.getString(12));
                c.setFecha_registro(rs.getDate(13));
                c.setFechaActualizacion(rs.getDate(14));
                ListaClientes.add(c);

            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error obeterCliente(Clientebd)" + ex.getMessage());

        }
        return ListaClientes;
    }

}
