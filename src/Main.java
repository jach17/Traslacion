import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private int xO, yO, x1, y1;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = getxO() + (x1 * 10);
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = getyO() + (y1 * 10);
    }

    public void setxO(int xo) {
        this.xO = xo * 10;
    }

    public int getxO() {
        return this.xO;
    }

    public void setyO(int yo) {
        this.yO = yo * 10;
    }

    public int getyO() {
        return this.yO;
    }

    public void setCoordenadas(JTextField x, JTextField y) {
        if (x.getText().equals("") || y.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "NO PUEDE DEJAR EL CAMPO DE LA COORDENADA ORIGINAL VACÍO");
            repaint();
        } else {
            setxO(Integer.parseInt(x.getText()));
            setyO(Integer.parseInt(y.getText()));
        }
    }

    public void setCoordenadasTrans(JTextField x, JTextField y) {
        if (x.getText().equals("") || y.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "NO PUEDE DEJAR VACIOS LOS CAMPOS DE TRASLACION");
            setX1(0);
            setY1(0);
        } else {
            setX1(Integer.parseInt(x.getText()));
            setY1(Integer.parseInt(y.getText()));
        }
    }

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
        panelPlano.setBounds(200, 100, 500, 500);
        panelPlano.setVisible(true);
        panelPlano.setBackground(Color.LIGHT_GRAY);

        /*Configuracion del plano controles*/
        panelControles = new JPanel();
        panelControles.setBounds(20, 100, 160, 550);
        panelControles.setVisible(true);
        panelControles.setBackground(Color.gray);

        /*COnfiguracion de los txt y lbl y btn*/
        infoXOriginal = initInstrucciones(40, 120, 120, 40, "Ingrese la coordenada original en X:");
        txtXOriginal = initTxt(40, 170, 120, 30);

        infoYOriginal = initInstrucciones(40, 200, 120, 40, "Ingrese la coordenada original en Y:");
        txtYOriginal = initTxt(40, 250, 120, 30);


        btnDrawOrigin = new JButton("Dibujar original");
        btnDrawOrigin.setBounds(40, 290, 120, 40);
        btnDrawOrigin.setVisible(true);
        btnDrawOrigin.setFont(new Font("Arial", Font.BOLD, 10));
        btnDrawOrigin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCoordenadas(txtXOriginal, txtYOriginal);
                drawFirstPoint(panelPlano, getxO(), getyO());
                drawPlano(panelPlano);

            }
        });


        infoXTrans = initInstrucciones(40, 280 + 50, 120, 40, "Unidades para trasladar en X:");
        txtXTrans = initTxt(40, 320 + 50, 120, 30);

        infoYTrans = initInstrucciones(40, 360 + 50, 120, 40, "Unidades para trasladar en Y:");
        txtYTrans = initTxt(40, 400 + 50, 120, 30);

        infoBtnTrans = initInstrucciones(40, 450 + 50, 120, 40, "Presione para trasladar: ");

        btnDrawTrans = new JButton("Trasladar");
        btnDrawTrans.setBounds(50, 500 + 50, 100, 40);
        btnDrawTrans.setVisible(true);
        btnDrawTrans.setFont(new Font("Arial", Font.BOLD, 10));
        btnDrawTrans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCoordenadasTrans(txtXTrans, txtYTrans);
                drawTranslatedPoint(panelPlano, getX1(), getY1());
                infoResultado.setText("x1= " + getX1()/10 + "\ty1= " + getY1()/10);
            }
        });

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
        repaint();
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


    public void drawFirstPoint(JPanel plano, int x, int y) {
        Graphics g = plano.getGraphics();
        x = x + plano.getWidth() / 2;
        y = plano.getHeight() / 2 - y;
        System.out.println("Coordenadas del punto original: " + x + ", " + y);
        g.fillOval(x - 5, y - 5, 10, 10);
    }

    public void drawTranslatedPoint(JPanel plano, int x, int y) {
        Graphics g = plano.getGraphics();
        x = x + plano.getWidth() / 2;
        y = plano.getHeight() / 2 - y;
        System.out.println("Coordenadas del punto translated: " + x + ", " + y);
        g.fillOval(x - 5, y - 5, 10, 10);
    }


    public void drawPlano(JPanel p) {
        Graphics g = p.getGraphics();
        g.setColor(Color.RED);
        g.drawLine(p.getWidth() / 2, 0, p.getWidth() / 2, p.getHeight());
        g.drawLine(0, p.getHeight() / 2, p.getWidth(), p.getHeight() / 2);
        for (int i = 0; i <= p.getWidth(); i += 10) {
            g.drawLine(i, (p.getHeight() / 2) - 5, i, (p.getHeight() / 2) + 5);
        }
        for (int i = 0; i <= p.getHeight(); i += 10) {
            g.drawLine((p.getWidth() / 2) - 5, i, (p.getWidth() / 2) + 5, i);
        }
    }
}
