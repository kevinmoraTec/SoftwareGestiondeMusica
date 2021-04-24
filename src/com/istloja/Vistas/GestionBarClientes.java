package com.istloja.Vistas;

import com.istloja.Modelo.Clientes;
import com.istloja.Utilidades.Utilidades;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import java.net.MalformedURLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author danielmora
 */
public class GestionBarClientes {

    private JTextField txtcedulaClientes;
    private JTextField txtnombreCliente;
    private JTextField txtapellidoCliente;
    private JTextField txtdireccionCliente;
    private JTextField txttelefonoCliente;
    private JTextField txtedadCliente;
    private JTextField JDateFecharegistro;
    private JTextField txtartistaCliente;
    private JTextField txtmusicaCliente;
    private JComboBox ComboBoxgeneroCliente;
    private JTextField txtañodemusicaCliente;
    private JTextField txtUrlCliente;
    //private JDateChooser fechaActualizacion;
    private JFrame GestionClientes;
    private Utilidades utilidades;

    public GestionBarClientes(JTextField txtcedulaClientes, JTextField txtnombreCliente, JTextField txtapellidoCliente, JTextField txtdireccionCliente, JTextField txttelefonoCliente, JTextField txtedadCliente, JTextField JDateFecharegistro, JTextField txtartistaCliente, JTextField txtmusicaCliente, JComboBox ComboBoxgeneroCliente, JTextField txtañodemusicaCliente, JTextField txtUrlCliente, JFrame GestionClientes, Utilidades utilidades) {
        this.txtcedulaClientes = txtcedulaClientes;
        this.txtnombreCliente = txtnombreCliente;
        this.txtapellidoCliente = txtapellidoCliente;
        this.txtdireccionCliente = txtdireccionCliente;
        this.txttelefonoCliente = txttelefonoCliente;
        this.txtedadCliente = txtedadCliente;
        this.JDateFecharegistro = JDateFecharegistro;
        this.txtartistaCliente = txtartistaCliente;
        this.txtmusicaCliente = txtmusicaCliente;
        this.ComboBoxgeneroCliente = ComboBoxgeneroCliente;
        this.txtañodemusicaCliente = txtañodemusicaCliente;
        this.txtUrlCliente = txtUrlCliente;
        this.GestionClientes = GestionClientes;
        this.utilidades = utilidades;
    }

    



     

    public void lmpiarRellenoClientes() {
        txtcedulaClientes.setText(null);
        txtnombreCliente.setText(null);
        txtapellidoCliente.setText(null);
        txtdireccionCliente.setText(null);
        txttelefonoCliente.setText(null);
        txtedadCliente.setText(null);
        JDateFecharegistro.setText(null);
        txtartistaCliente.setText(null);
        txtmusicaCliente.setText(null);
        ComboBoxgeneroCliente.setSelectedIndex(0);
        txtañodemusicaCliente.setText(null);
        txtUrlCliente.setText(null);

    }
    
    public Clientes validarGuardarEditar(boolean isEditar) {
        Clientes clientes = new Clientes();
        
        if (txtnombreCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionClientes,"El campo nombres no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
               txtnombreCliente.requestFocus();
            return null;
        }
        if (txtapellidoCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionClientes, "El campo apellidos no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtapellidoCliente.requestFocus();
            return null;
        }
        if (txtdireccionCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionClientes, "El campo direccion no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtdireccionCliente.requestFocus();
            return null;
        }
        if (txttelefonoCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionClientes, "El campo teléfono no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        txttelefonoCliente.requestFocus();
        return null;
        }
        if (!utilidades.validarNumero(txttelefonoCliente.getText())) {
            System.out.println(""+utilidades.validarNumero(txttelefonoCliente.getText()));
            JOptionPane.showMessageDialog(GestionClientes, "Los datos ingresados en el telefono no son validos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txttelefonoCliente.requestFocus();
            return null;
        }
        if (txtedadCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionClientes, "El campo Edad no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtedadCliente.requestFocus();
            return null;
        }
        if (!utilidades.validarNumeroEdad(txtedadCliente.getText())) {
            JOptionPane.showMessageDialog(GestionClientes, "Los datos ingresados en la Edad no son validos. Ingrese por Ejemplo: =22 /o/ 23", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtedadCliente.requestFocus();
            return null;
        }
        if (txtartistaCliente.getText().isEmpty()) {
             JOptionPane.showMessageDialog(GestionClientes, "El campo Artista no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
             txtartistaCliente.requestFocus();
             return null;
        }
        if (txtmusicaCliente.getText().isEmpty()) {
             JOptionPane.showMessageDialog(GestionClientes, "El campo Artista no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
             txtmusicaCliente.requestFocus();
             return null;
        }

        if (txtañodemusicaCliente.getText().isEmpty()) {
             JOptionPane.showMessageDialog(GestionClientes, "El campo Año no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
             txtañodemusicaCliente.requestFocus();
             return null;
        }

        if (!utilidades.validarNumeroAñocancion(txtañodemusicaCliente.getText())){
           JOptionPane.showMessageDialog(GestionClientes, "Los datos ingresados en lel Año no son validos. Ingrese por Ejemplo: =1998 /o/ 2001", "ERROR", JOptionPane.ERROR_MESSAGE); 
        txtañodemusicaCliente.requestFocus();
        return null;
        }
        
//        txtUrlCliente.cut();
//        txtUrlCliente.copy();
//        txtUrlCliente.paste();
//        if (!utilidades.urlValidator(txtUrlCliente.getText())) {
//            JOptionPane.showMessageDialog(GestionClientes, "Los datos ingresados en la URL no son validos. Ingrese por Ejemplo: = https://www.youtube.com/watch?v=X3-LuNDmshg", "ERROR", JOptionPane.ERROR_MESSAGE);
//            txtUrlCliente.requestFocus();
//            return null;
//        }
        
        
        clientes.setCedula(txtcedulaClientes.getText());
        clientes.setNombre(txtnombreCliente.getText());
        clientes.setApellido(txtapellidoCliente.getText());
        clientes.setDirecion(txtdireccionCliente.getText());
        clientes.setTelefono(txttelefonoCliente.getText());
        clientes.setEdad(txtedadCliente.getText());
        clientes.setFecha_registro(java.sql.Date.valueOf(JDateFecharegistro.getText()));
        clientes.setArtista(txtartistaCliente.getText());
        clientes.setMusica(txtmusicaCliente.getText());
        clientes.setGenero((String) ComboBoxgeneroCliente.getSelectedItem());
        clientes.setAñoMusica(txtañodemusicaCliente.getText());
        clientes.setVinculo(txtUrlCliente.getText());
        if (isEditar) {
          clientes.setFechaActualizacion(java.sql.Date.valueOf( utilidades.devolverFechaFormato(utilidades.devolverFechaactual())));
        }else{
            //clientes.setFecha_registro((java.sql.Date) new Date());
        }
      
        return clientes;
    }
}
