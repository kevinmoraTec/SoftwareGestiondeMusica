/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.Utilidades;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author danielmora
 */
public class Utilidades {

    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }
        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

    public boolean validarNumero(String numero) {

        // Validamos los numeros de Telefono de las Personas
        if (numero.isEmpty()) {
            return false;
        } else if (numero.length() > 10) {
            return false;
        }
        if (numero.charAt(0) != '0') {
            return false;
        }

        try {

            int validarNumero = Integer.parseInt(numero);

            return true;

        } catch (Exception ex) {
            return false;
        }

    }

    public boolean validarNumeroEdad(String numero) {

       // Validamos los numeros de Telefono de las Personas
        if (numero.isEmpty()) {
            return false;
        } 
        if (numero.length() > 2) {
            return false;
        }
        if (numero.matches("[0-9]*")) {
            return true;
		}

        try {

            int validarNumero = Integer.parseInt(numero);

            return true;

        } catch (Exception ex) {
            return false;
        }

    }

    public boolean validarNumeroAñocancion(String numero) {
        String comprobar = "1050";
        // Validamos los numeros de Telefono de las Personas
        if (numero.isEmpty()) {
            return false;
            
            
        }
        if (numero.matches("[0-9]*")) {
			return true;
		}
        if (numero.length() > 5) {
            return false;
        } 
        if (Integer.parseInt(numero) >= Integer.parseInt(comprobar)) {
            return false;
        }
        try {
            int validarNumero = Integer.parseInt(numero);
            return true;

        } catch (Exception ex) {
            return false;
        }

    }

//    public boolean urlValidator(String url) throws MalformedURLException {
//        /*validación de url*/
//        try {
//            new URL(url).toURI();
//            return true;
//        } catch (URISyntaxException exception) {
//            return false;
//        } catch (MalformedURLException exception) {
//            return false;
//        }
//    }

    public Date devolverFecha(Date fecha) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return  fecha;
    }

    public Date devolverFechaactual() {
        java.util.Date fecha = new Date();
        System.out.println(fecha);
        return fecha;
    }
    public Date devolverFechaactual2(Object object) {
        
              return (Date) object;

    }
      public String devolverFechaFormato(Date fecha) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
         return f.format(fecha);
    }

    public java.sql.Date devolverFechaactual(Date devolverFechaactual) {
         java.util.Date fecha = new Date();
        System.out.println(fecha);
        return (java.sql.Date) fecha;
    }
}
