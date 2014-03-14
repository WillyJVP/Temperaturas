
//Importar Librerias
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Temperatura extends JFrame{

    public static void main(String args[]){
        new Temperatura().Init();

    }

    //Declaracion de variables
    JLabel lbMensaje,lbFarent, lbCelsius, lbKelvin;
    JTextField txtFarent, txtCelsius, txtKelvin;
    JButton btnCalc, btnCls;
    JPanel panel;
    double valor1,valor2,valor3,resultado1,resultado2;

    public void Init(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Crear Ventana
        this.setSize(350, 250);
        this.setVisible(true);
        this.setLocation(400,200);

        //Crear Panel
        panel = new JPanel();
        panel.setSize(350,250);
        panel.setBackground(Color.darkGray);
        panel.setLayout(null);
        this.add(panel);

        //Mostrar la ETIQUETAS
        lbMensaje = new JLabel();
        lbMensaje.setBackground(Color.darkGray);
        lbMensaje.setForeground(Color.white);
        lbMensaje.setLocation(30, 10);
        lbMensaje.setSize(300, 20);
        lbMensaje.setText("CONVERSOR DE UNIDADES DE TEMPERATURA");
        lbMensaje.setOpaque(true);
        panel.add(lbMensaje);

        lbCelsius = new JLabel();
        lbCelsius.setBackground(Color.darkGray);
        lbCelsius.setForeground(Color.white);
        lbCelsius.setLocation(70, 70);
        lbCelsius.setSize(200, 20);
        lbCelsius.setText("Celsius: ");
        lbCelsius.setOpaque(true);
        panel.add(lbCelsius);

        lbFarent = new JLabel();
        lbFarent.setBackground(Color.darkGray);
        lbFarent.setForeground(Color.white);
        lbFarent.setLocation(70,100);
        lbFarent.setSize(100,20);
        lbFarent.setText("Farenheit: ");
        lbFarent.setOpaque(true);
        panel.add(lbFarent);

        lbKelvin = new JLabel();
        lbKelvin.setBackground(Color.darkGray);
        lbKelvin.setForeground(Color.white);
        lbKelvin.setLocation(70,130);
        lbKelvin.setSize(100,20);
        lbKelvin.setText("Kelvin: ");
        lbKelvin.setOpaque(true);
        panel.add(lbKelvin);

        //Crear CUADROS DE TEXTO

        txtCelsius = new JTextField();
        txtCelsius.setBounds(160,70,80,20);
        panel.add(txtCelsius);

        txtFarent = new JTextField();
        txtFarent.setBounds(160,100,80,20);
        txtFarent.setVisible(true);
        panel.add(txtFarent);

        txtKelvin = new JTextField();
        txtKelvin.setBounds(160,130,80,20);
        panel.add(txtKelvin);

        //Crear BOTONES
        btnCalc = new JButton();
        btnCalc.setText("Calcular");
        btnCalc.setBounds(30,170,90,20);
        panel.add(btnCalc);
        btnCalc.setForeground(Color.BLACK);


        btnCls = new JButton();
        btnCls.setText("Limpiar");
        btnCls.setBounds(200,170,90,20);
        panel.add(btnCls);
        btnCls.setForeground(Color.black);

        Cls();
        //ACCION DEL BOTON CALCULAR
        btnCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
        String svalor1 = txtCelsius.getText();
        String svalor2 = txtFarent.getText();
        String svalor3 = txtKelvin.getText();
                if (!svalor1.equals(" ")&&((svalor2.equals(" "))&&(svalor3.equals(" ")))){
                    try{
                        valor1 = Double.parseDouble(svalor1);
                        resultado1=(valor1*1.8+32);
                        txtFarent.setText(Double.toString(resultado1));
                        resultado2=valor1+273;
                        txtKelvin.setText(Double.toString(resultado2));
                    }
                    catch (NumberFormatException e1){
                        JOptionPane.showMessageDialog(rootPane, "Ha ingresado un dato incorrecto");
                        Cls();

                    }
                }
                else if (!svalor2.equals(" ")&&((svalor1.equals(" "))&&(svalor3.equals(" ")))){
                    try{
                        valor2 = Double.parseDouble(svalor2);
                        resultado1 = ((valor2-32)/1.8);
                        //Reduce el numero de Decimales
                        String cad=String.valueOf(resultado1); //convierte a un string
                        cad = cad.substring(0,8);              //reduce la hilera del string
                        resultado1 = Double.parseDouble(cad);  //convierte el string a un double
                        txtCelsius.setText(Double.toString(resultado1));

                        resultado2 = (((valor2-32)/1.8)+273.15);
                        String cad2=String.valueOf(resultado2);
                        cad2 = cad2.substring(0,8);
                        resultado2 = Double.parseDouble(cad2);
                        txtKelvin.setText(Double.toString(resultado2));
                    }
                    catch (NumberFormatException e1){
                        JOptionPane.showMessageDialog(rootPane, "Ha ingresado un dato incorrecto");
                        Cls();
                    }
                }
                else if (!svalor3.equals(" ")&&((svalor2.equals(" "))&&(svalor1.equals(" ")))){
                    try{
                        valor3 = Double.parseDouble(svalor3);
                        resultado1=valor3-273.15;
                        txtCelsius.setText(Double.toString(resultado1));
                        resultado2=(((valor3-273.15)*1.8)+32);
                        txtFarent.setText(Double.toString(resultado2));
                    }
                    catch (NumberFormatException e1){
                        JOptionPane.showMessageDialog(rootPane, "Ha ingresado un dato incorrecto");
                        Cls();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Error, Ingrese solo una opcion");
                    Cls();
                }

            }
        });

        //ACCION DEL BOTON LIMPIAR
        btnCls.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Cls();

            }
        });
    }
public void Cls(){
        txtFarent.setText(" ");
        txtKelvin.setText(" ");
        txtCelsius.setText(" ");
    }

}
