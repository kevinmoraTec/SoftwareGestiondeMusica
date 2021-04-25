package com.istloja.ModelTables;

import com.istloja.Modelo.Proveedores;
import com.istloja.Modelo.Clientes;
import com.istloja.Vistas.VentanaPrincipal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danielmora
 */
public class ModeTableProvedores extends AbstractTableModel {

    private String[] nombre_Columnas = {"RUC", "TIPO ACTIVIDAD", "N.REPRESENTANTE", "A.REPRESENTANTE", "TELEFONO", "CORREO", "DIRECCION", "ESTADO_DEUDA", "F.REGISTRO", "F.ACTUALIZACION"};// Definimos el Encabezado de nuestra tabla 
    private List<Proveedores> proveedores;
    private VentanaPrincipal Vprincipal;

    public ModeTableProvedores(List<Proveedores> proveedores, VentanaPrincipal Vprincipal) {
        this.proveedores = proveedores;
        this.Vprincipal = Vprincipal;
    }

    @Override
    public int getRowCount() {// Me mustra el tamaño de las filas que tenemos en la tabla 
        return proveedores.size();
    }

    @Override
    public int getColumnCount() {
        return nombre_Columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        {
            Proveedores  proveedores = this.proveedores.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    proveedores.getRuc();
                case 1:
                    proveedores.getRazon_social();
                case 2:
                    proveedores.getTipo_actividad();
                case 3:
                    proveedores.getNombre_representante();
                case 4:
                    proveedores.getApellido_representante();
                case 5:
                    proveedores.getTelefono();
                case 6:
                    proveedores.getCorreo();
                case 7:
                    proveedores.getDireccion();
                case 8:
                    proveedores.getEstado_deuda();
                case 9:
                    proveedores.getFecha_Registro();
               // case 10:
                // proveedores.getFecha_actuslizacion();
            }
            return new String();
        }
    }

    @Override
    public String getColumnName(int column) {
        return nombre_Columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        Vprincipal.ClikProvedores(proveedores.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Proveedores> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedores> proveedores) {
        this.proveedores = proveedores;
    }

}
