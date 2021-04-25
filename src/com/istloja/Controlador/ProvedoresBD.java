package com.istloja.Controlador;

import com.istloja.ConexionBD.Conexion_base_de_Datos;
import com.istloja.Modelo.Clientes;
import com.istloja.Modelo.Proveedores;
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
public class ProvedoresBD {

    public boolean registrarProvedores(Proveedores proveedores) {
        boolean registrar = false;
        //Interfaz de comunicacion (acceso a )con  la base de datos // se encuetra e el jdbc
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        // Para borrar 

        //Strig sql Dinamico
        String sql = "INSERT INTO `gestionMusica`.`Provedores` (`ruc`,"
                + " `razon_social`,"
                + " `tipo_actividad`,"
                + " `nombre_representante`,"
                + " `apellido_representante`,"
                + " `telefono`,"
                + " `correo`,"
                + " `direccion`,"
                + " `estado_deuda`,"
                + " `fecha_registro`) VALUES ('" + proveedores.getRuc() + "',"
                + " '" + proveedores.getRazon_social() + "',"
                + " '" + proveedores.getTipo_actividad() + "',"
                + " '" + proveedores.getNombre_representante() + "',"
                + " '" + proveedores.getApellido_representante() + "',"
                + " '" + proveedores.getTelefono() + "',"
                + " '" + proveedores.getCorreo() + "',"
                + " '" + proveedores.getDireccion() + "',"
                + " '" + proveedores.getEstado_deuda() + "',"
                + " '" + proveedores.getFecha_Registro() + "');";

        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException E) {
            System.out.println("Error al Registrar Provedor (Provedores bd)" + E.getMessage());
        }
        return registrar;
    }

    public boolean editarProvedores(Proveedores proveedores) {
        boolean registrar = false;
        //Interfaz de comunicacion (acceso a )con  la base de datos // se encuetra e el jdbc
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "UPDATE `gestionMusica`.`Provedores` SET `ruc`='" + proveedores.getRuc() + "',"
                + " `razon_social`='" + proveedores.getRazon_social() + "',"
                + " `tipo_actividad`='" + proveedores.getTipo_actividad() + "',"
                + " `nombre_representante`='" + proveedores.getNombre_representante() + "',"
                + " `apellido_representante`='" + proveedores.getApellido_representante() + "',"
                + " `telefono`='" + proveedores.getTelefono() + "',"
                + " `correo`='" + proveedores.getCorreo() + "',"
                + " `direccion`='" + proveedores.getDireccion() + "',"
                + " `estado_deuda`='" + proveedores.getEstado_deuda() + "',"
                + " `fecha_actualizacion`='" + proveedores.getFecha_actuslizacion() + "' WHERE `id_Provedores`='" + proveedores.getId_Provedore() + "';";

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

    public boolean eliminarProvedores(Proveedores proveedores) {
        boolean registrar = false;
        //Interfaz de comunicacion (acceso a )con  la base de datos // se encuetra e el jdbc
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql = "DELETE FROM `gestionMusica`.`Provedores` WHERE `id_Provedores`='" + proveedores.getId_Provedore() + "';";
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

    public Proveedores getProvedorCedula(String ruc) {

        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;// Obtener los datos de la base de datos 
        Proveedores p = null;
        String sql = " SELECT * FROM gestionMusica.Provedores where ruc = " + ruc + ";";
        //SELECT * FROM gestionMusica.Provedores
        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                p = new Proveedores();
                p.setId_Provedore(rs.getInt(1));
                p.setRuc(rs.getString(2));
                p.setRazon_social(rs.getString(3));
                p.setTipo_actividad(rs.getString(4));
                p.setNombre_representante(rs.getString(5));
                p.setApellido_representante(rs.getString(6));
                p.setTelefono(rs.getString(7));
                p.setCorreo(rs.getString(8));
                p.setDireccion(rs.getString(9));
                p.setEstado_deuda(rs.getString(10));
                p.setFecha_Registro(rs.getDate(11));
                p.setFecha_actuslizacion(rs.getDate(12));
            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error buscar getProvedorCedula (Provedoresbd)" + ex.getMessage());

        }
        return p;
    }

    public List<Proveedores> obtenerProvedores() {

        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;// Obtener los datos de la base de datos 
        List<Proveedores> Listaprovedores = new ArrayList<Proveedores>();
        String sql = "SELECT * FROM gestionMusica.Provedores;";
        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Proveedores p = new Proveedores();
                p = new Proveedores();
                p.setId_Provedore(rs.getInt(1));
                p.setRuc(rs.getString(2));
                p.setRazon_social(rs.getString(3));
                p.setTipo_actividad(rs.getString(4));
                p.setNombre_representante(rs.getString(5));
                p.setApellido_representante(rs.getString(6));
                p.setTelefono(rs.getString(7));
                p.setCorreo(rs.getString(8));
                p.setDireccion(rs.getString(9));
                p.setEstado_deuda(rs.getString(10));
                p.setFecha_Registro(rs.getDate(11));
                p.setFecha_actuslizacion(rs.getDate(12));
                Listaprovedores.add(p);

            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error obtenerProvedores(Provedoresbd)" + ex.getMessage());

        }
        return Listaprovedores;

    }
        public List<Proveedores> obtenerProvedoresCedula(String ruc) {

        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;// Obtener los datos de la base de datos 
        List<Proveedores> Listaprovedores = new ArrayList<Proveedores>();                   
        String sql = "SELECT * FROM gestionMusica.Provedores where ruc like \"%" + ruc + "%\"";
        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Proveedores p = new Proveedores();
                p.setId_Provedore(rs.getInt(1));
                p.setRuc(rs.getString(2));
                p.setRazon_social(rs.getString(3));
                p.setTipo_actividad(rs.getString(4));
                p.setNombre_representante(rs.getString(5));
                p.setApellido_representante(rs.getString(6));
                p.setTelefono(rs.getString(7));
                p.setCorreo(rs.getString(8));
                p.setDireccion(rs.getString(9));
                p.setEstado_deuda(rs.getString(10));
                p.setFecha_Registro(rs.getDate(11));
                p.setFecha_actuslizacion(rs.getDate(12));
                Listaprovedores.add(p);

            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error obtenerProvedoresCedula(Provedoresbd)" + ex.getMessage());

        }
        return Listaprovedores;

    }
}
