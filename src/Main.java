import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        ventana v = new ventana();

    }


}

class ventana extends JFrame{
    private JPanel panelPlano, panelControles;
    private JLabel titulo;


    public ventana(){
        this.setBounds(0,0,720,700);
        this.setVisible(true);
        this.setTitle("Traslación");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        /*Configuracion del titulo*/
        titulo = new JLabel("Trasladar un punto en el plano");
        titulo.setBounds(20,20,680,60);
        titulo.setVisible(true);


        /*Configuracion del plano para dibujar*/
        panelPlano = new JPanel();
        panelPlano.setBounds(200,100,500,500);
        panelPlano.setVisible(true);
        panelPlano.setBackground(Color.BLUE);
        /*Configuracion del plano controles*/
        panelControles = new JPanel();
        panelControles.setBounds(20,100,160,500);
        panelControles.setVisible(true);
        panelControles.setBackground(Color.gray);



        /*Agregar los componentes*/
        this.setLayout(null);
        this.add(panelPlano);
        this.add(panelControles);
        this.add(titulo);
    }



}
