import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ventana v = new ventana();

    }


}

class ventana extends JFrame {
    private JPanel panelPlano, panelControles;
    private JLabel titulo;
    private JTextField txtXOriginal, txtYOriginal, txtXTrans, txtYTrans;
    private JLabel infoXOriginal, infoYOriginal, infoXTrans, infoYTrans, infoBtnTrans, infoResultado;
    private JButton btnDrawOrigin, btnDrawTrans;


    public ventana() {
        this.setBounds(0, 0, 720, 700);
        this.setVisible(true);
        this.setTitle("Traslación");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.white);

        /*Configuracion del titulo*/
        titulo = new JLabel("Trasladar un punto en el plano");
        titulo.setBounds(20, 20, 680, 60);
        titulo.setVisible(true);
        Font f = new Font("Arial", Font.BOLD, 28);
        titulo.setFont(f);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        /*Configuracion del plano para dibujar*/
        panelPlano = new JPanel();
        panelPlano.setBounds(200, 100, 500, 550);
        panelPlano.setVisible(true);
        panelPlano.setBackground(Color.LIGHT_GRAY);

        /*Configuracion del plano controles*/
        panelControles = new JPanel();
        panelControles.setBounds(20, 100, 160, 550);
        panelControles.setVisible(true);
        panelControles.setBackground(Color.gray);

        /*COnfiguracion de los txt y lbl*/
        infoXOriginal = initInstrucciones(40, 120, 120, 40, "Ingrese la coordenada original en X:");
        txtXOriginal = initTxt(40, 170, 120, 30);

        infoYOriginal = initInstrucciones(40, 200, 120, 40, "Ingrese la coordenada original en Y:");
        txtYOriginal = initTxt(40, 250, 120, 30);

        btnDrawOrigin = new JButton("Dibujar original");
        btnDrawOrigin.setBounds(40, 290, 120, 40);
        btnDrawOrigin.setVisible(true);
        btnDrawOrigin.setFont(new Font("Arial", Font.BOLD, 10));


        infoXTrans = initInstrucciones(40, 280 + 50, 120, 40, "Unidades para trasladar en X:");
        txtXTrans = initTxt(40, 320 + 50, 120, 30);

        infoYTrans = initInstrucciones(40, 360 + 50, 120, 40, "Unidades para trasladar en Y:");
        txtYTrans = initTxt(40, 400 + 50, 120, 30);

        infoBtnTrans = initInstrucciones(40, 450 + 50, 120, 40, "Presione para trasladar: ");
        btnDrawTrans = new JButton("Trasladar");
        btnDrawTrans.setBounds(50, 500 + 50, 100, 40);
        btnDrawTrans.setVisible(true);
        btnDrawTrans.setFont(new Font("Arial", Font.BOLD, 10));

        infoResultado = initInstrucciones(40, 550 + 50, 120, 40, "Nuevas coordenadas...");


        /*Agregar los componentes*/
        this.setLayout(null);
        panelControles.setLayout(null);

        this.add(titulo);
        this.add(txtXOriginal);
        this.add(infoXOriginal);
        this.add(txtYOriginal);
        this.add(infoYOriginal);
        this.add(btnDrawOrigin);
        this.add(txtXTrans);
        this.add(infoXTrans);
        this.add(txtYTrans);
        this.add(infoYTrans);
        this.add(infoBtnTrans);
        this.add(btnDrawTrans);
        this.add(infoResultado);
        this.add(panelPlano);
        this.add(panelControles);
        paint(panelPlano.getGraphics());


    }

    @Override
    public void paint(Graphics g){
        g.drawLine(0, 0, 50, 50);
    }



    public JLabel initInstrucciones(int x, int y, int w, int h, String t) {
        Font f = new Font("Arial", Font.BOLD, 10);
        JLabel lbl = new JLabel("<html>" + t + "</html>");
        lbl.setBounds(x, y, w, h);
        lbl.setVisible(true);
        lbl.setFont(f);
        return lbl;
    }

    public JTextField initTxt(int x, int y, int w, int h) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, w, h);
        txt.setVisible(true);
        return txt;
    }

    public void drawPlano() {
        Graphics g = panelPlano.getGraphics();

    }

}
