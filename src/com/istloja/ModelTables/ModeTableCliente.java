/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.ModelTables;

import com.istloja.Modelo.Clientes;
import com.istloja.Vistas.VentanaPrincipal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danielmora
 */
public class ModeTableCliente extends AbstractTableModel {// Como AbstractTableModel es una calse padre la subcalse debe Implementar todos los metodos;

    private  String[] nombre_Columnas = {"CEDULA", "NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO", "EDAD", "ARTISTA", "MUSICA", "GENERO", "AÑO", "VINCULO", "FECHA"};// Definimos el Encabezado de nuestra tabla 
    private  List<Clientes> clientes;
    private VentanaPrincipal Vprincipal;
    public ModeTableCliente(List<Clientes> clientes,VentanaPrincipal Vprincipal) {
        this.clientes = clientes;
        this.Vprincipal = Vprincipal;
    }

    @Override
    public int getRowCount() {// Me mustra el tamaño de las filas que tenemos en la tabla 
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return nombre_Columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        {// O TAMBIEN seteamos los valores. 
            // obtenemos la fila1,fila2,fila3,fila4

//     public String[] nombre_Columnas = {"CEDULA","NOMBRE","APELLIDO","
//DIRECCION","TELEFONO","EDAD","ARTISTA","MUSICA","GENERO","AÑO",
//"VINCULO","FECHA"};// Definim
            Clientes clientes = this.clientes.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return clientes.getCedula();
                case 1:
                    return clientes.getNombre();
                case 2:
                    return clientes.getApellido();
                case 3:
                    return clientes.getDirecion();
                case 4:
                    return clientes.getTelefono();
                case 5:
                    return clientes.getEdad();
                case 6:
                    return clientes.getArtista();
                case 7:
                    return clientes.getMusica();
                case 8:
                    return clientes.getGenero();
                case 9:
                    return clientes.getAñoMusica();
                case 10:
                    return clientes.getVinculo();
                case 11:
                    return clientes.getFecha_registro();
            }
            return new String();
        }

    }

    @Override
    public String getColumnName(int column) {
        return nombre_Columnas[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       Vprincipal.clikCliente(clientes.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
    
   

}
