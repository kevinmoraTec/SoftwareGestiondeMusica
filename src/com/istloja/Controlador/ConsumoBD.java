package com.istloja.Controlador;

import com.istloja.ConexionBD.Conexion_base_de_Datos;
import com.istloja.Modelo.Consumo;
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
public class ConsumoBD {

    public boolean registrarConsumos(Consumo consumo) {
        boolean registrar = false;
        //Interfaz de comunicacion (acceso a )con  la base de datos // se encuetra e el jdbc
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "INSERT INTO `gestionMusica`.`Consumo` (`cedula`, `nombre`, `apellido`, `artista`, `año`, `genero`, `musica`, `url`, `codigo_producto`, `cantidad`, `total`) VALUES ('"+consumo.getCedula()+"',"
                + " '"+consumo.getNombre()+"',"
                + " '"+consumo.getApellido()+"',"
                + " '"+consumo.getArtista()+"',"
                + " '"+consumo.getAño()+"',"
                + " '"+consumo.getGenero()+"',"
                + " '"+consumo.getMusica()+"',"
                + " '"+consumo.getUrl()+"',"
                + " '"+consumo.getCodigo_producto()+"',"
                + " '"+consumo.getCantidad()+"',"
                + " '"+consumo.getTotal()+"');";
        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();

        } catch (SQLException E) {
            System.out.println("Error al Registrar Consumo (Consumo bd)" + E.getMessage());
        }
        return registrar;
    }

    public boolean eliminarConsumo(Consumo consumo) {

        boolean registrar = false;
        //Interfaz de comunicacion (acceso a )con  la base de datos // se encuetra e el jdbc
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;

        String sql = "DELETE FROM `gestionMusica`.`Consumo` WHERE `id_Consumo`='" + consumo.getId_consumo() + "';";

        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();

        } catch (SQLException E) {
            System.out.println("Error al Editar Menu (Menubd bd)" + E.getMessage());
        }
        return registrar;
    }

    public List<Consumo> obtenertConsumo() {

        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        ResultSet rs = null;// Obtener los datos de la base de datos 
        List<Consumo> Listconsumo = new ArrayList<Consumo>();
        Consumo c = null;
        String sql = "SELECT * FROM gestionMusica.Consumo;";
        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Consumo();
                c.setId_consumo(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setArtista(rs.getString(5));
                c.setAño(rs.getString(6));
                c.setGenero(rs.getString(7));
                c.setMusica(rs.getString(8));
                c.setUrl(rs.getString(9));
                c.setCodigo_producto(rs.getString(10));
                c.setCantidad(rs.getInt(11));
                c.setTotal(rs.getDouble(12));
                Listconsumo.add(c);

            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error buscar Menu Codigo (Menubd)" + ex.getMessage());

        }
        return Listconsumo;
    }

    public Consumo getMenuCodigo(String codigo) {
        Connection con = null;
        Statement stm = null;
        //Conexion con la base de datos.
        ResultSet rs = null;// Obtener los datos de la base de datos 
        Consumo c = null;
        String sql = "SELECT * FROM gestionMusica.Inventario where Codigo = '" + codigo + "';";
        try {
            Conexion_base_de_Datos cd = new Conexion_base_de_Datos();
            con = Conexion_base_de_Datos.conexionMysql();
            stm = con.createStatement(); // Para realizar una consulta, creamos el Statement y llamamos a su método executeQuery().
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Consumo();
                c.setId_consumo(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setArtista(rs.getString(5));
                c.setAño(rs.getString(6));
                c.setGenero(rs.getString(7));
                c.setMusica(rs.getString(8));
                c.setUrl(rs.getString(9));
                c.setCodigo_producto(rs.getString(10));
                c.setCantidad(rs.getInt(11));
                c.setTotal(rs.getDouble(12));

            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Error buscar Menu getMenubar (Menubd)" + ex.getMessage());

        }
        return c;

    }

}
