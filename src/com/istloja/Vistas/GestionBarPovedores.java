package com.istloja.Vistas;

import com.istloja.Modelo.Proveedores;
import com.istloja.Utilidades.Utilidades;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author danielmora
 */
public class GestionBarPovedores {

    private JTextField txtRucProvedores;
    private JTextField txtRazonSocialProvedores;
    private JTextField txtTipodeActividadProvedores;
    private JTextField txtNombreRepresentanteProvedores;
    private JTextField txtApellidosProvedores;
    private JTextField txtTelefeonoProvedores;
    private JTextField txtCorreoProvedores;
    private JTextField txtDireccionProvedores;
    private JComboBox ComboBoxEstadoDeudaProvedores;
    private JTextField JDateFecharegistroProvedores;
    private JFrame GestionProvedores;
    private Utilidades utilidades;

    public GestionBarPovedores(JTextField txtRucProvedores, JTextField txtRazonSocialProvedores, JTextField txtTipodeActividadProvedores, JTextField txtNombreRepresentanteProvedores, JTextField txtApellidosProvedores, JTextField txtTelefeonoProvedores, JTextField txtCorreoProvedores, JTextField txtDireccionProvedores, JComboBox ComboBoxEstadoDeudaProvedores, JTextField JDateFecharegistroProvedores, JFrame GestionProvedores, Utilidades utilidades) {
        this.txtRucProvedores = txtRucProvedores;
        this.txtRazonSocialProvedores = txtRazonSocialProvedores;
        this.txtTipodeActividadProvedores = txtTipodeActividadProvedores;
        this.txtNombreRepresentanteProvedores = txtNombreRepresentanteProvedores;
        this.txtApellidosProvedores = txtApellidosProvedores;
        this.txtTelefeonoProvedores = txtTelefeonoProvedores;
        this.txtCorreoProvedores = txtCorreoProvedores;
        this.txtDireccionProvedores = txtDireccionProvedores;
        this.ComboBoxEstadoDeudaProvedores = ComboBoxEstadoDeudaProvedores;
        this.JDateFecharegistroProvedores = JDateFecharegistroProvedores;
        this.GestionProvedores = GestionProvedores;
        this.utilidades = utilidades;
    }

    public void LimpiarRellenoProvedores() {
        txtRucProvedores.setText(null);
        txtRazonSocialProvedores.setText(null);
        txtTipodeActividadProvedores.setText(null);
        txtNombreRepresentanteProvedores.setText(null);
        txtApellidosProvedores.setText(null);
        txtTelefeonoProvedores.setText(null);
        txtCorreoProvedores.setText(null);
        txtDireccionProvedores.setText(null);
        ComboBoxEstadoDeudaProvedores.setSelectedIndex(0);
        JDateFecharegistroProvedores.setText(null);
    }

    public Proveedores guradarEditar(boolean isEditar) {
        Proveedores proveedores = new Proveedores();

        if (txtRazonSocialProvedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionProvedores, "LLene los campos del RazonSocial", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtRazonSocialProvedores.requestFocus();
            return null;
        }

        if (txtTipodeActividadProvedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionProvedores, "LLene los campos del nombre de representante", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTipodeActividadProvedores.requestFocus();
            return null;
        }
        if (txtNombreRepresentanteProvedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionProvedores, "LLene los campos del nombre de representante", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombreRepresentanteProvedores.requestFocus();
            return null;
        }
        if (txtApellidosProvedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionProvedores, "LLene los campos del apellido del representante", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtApellidosProvedores.requestFocus();
            return null;
        }
        if (txtTelefeonoProvedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionProvedores, "LLene los campos de la razon social", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTelefeonoProvedores.requestFocus();// sirve para ubicar el cursor en el campo vacio
            return null;
        }

        if (txtCorreoProvedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionProvedores, "LLene los campos del tipo de actividad", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCorreoProvedores.requestFocus();
            return null;
        }

        if (txtDireccionProvedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(GestionProvedores, "LLene los campos del telefono", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDireccionProvedores.requestFocus();
            return null;
        }

        proveedores.setRuc(txtRucProvedores.getText());
        proveedores.setRazon_social(txtRazonSocialProvedores.getText());
        proveedores.setTipo_actividad(txtTipodeActividadProvedores.getText());
        proveedores.setNombre_representante(txtNombreRepresentanteProvedores.getText());
        proveedores.setApellido_representante(txtApellidosProvedores.getText());
        proveedores.setTelefono(txtTelefeonoProvedores.getText());
        proveedores.setCorreo(txtCorreoProvedores.getText());
        proveedores.setDireccion(txtDireccionProvedores.getText());
        proveedores.setEstado_deuda((String) ComboBoxEstadoDeudaProvedores.getSelectedItem());
        proveedores.setFecha_Registro(java.sql.Date.valueOf(JDateFecharegistroProvedores.getText()));
        if (isEditar) {
           // proveedores.setFecha_actuslizacion(java.sql.Date.valueOf(utilidades.devolverFechaFormato(utilidades.devolverFechaactual())));

        } else {

        }

        return proveedores;
    }

}
