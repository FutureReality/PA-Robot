import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui10 extends JFrame {
    JButton adelante;
    JButton atras;
    JButton izquierda;
    JButton derecha;
    JButton guardar;
    JButton cargar;
	
	int Y = 0;
	int X = 0;
	String direccion = "norte";

    public Gui10() {
        setLayout(new FlowLayout());
        add(new JLabel("Estado del robot: " + X + ", " + Y));
        add(new JLabel("Direccion: " + direccion));
		
        adelante = new JButton("adelante");
        atras = new JButton("atras");
        izquierda = new JButton("izquierda");
        derecha = new JButton("derecha");
        guardar = new JButton("guardar");
        cargar = new JButton("cargar");
		
        add(adelante);
        add(atras);
        add(izquierda);
        add(derecha);
        add(guardar);
        add(cargar);
		
        adelante.addActionListener(new agrega());
        atras.addActionListener(new resta());
        izquierda.addActionListener(new oeste());
        derecha.addActionListener(new este());
        guardar.addActionListener(new guardarestado());
        cargar.addActionListener(new cargarestado());

        setSize(400, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        Gui10 ventana = new Gui10();
    }

    class agrega implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            X++;
			String direccion = "Norte";
			System.out.println(X); 
			System.out.println(direccion); 
        }
    }

    class resta implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            X--;
			System.out.println(X); 
        }
    }
	
    class oeste implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String direccion = "oeste";
			System.out.println(direccion); 
        }
    }
	
    class este implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String direccion = "este";
			System.out.println(direccion); 
        }
    }

    class guardarestado implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            X++;
			System.out.println(X); 
        }
		
    }
	
    class cargarestado implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            X++;
			System.out.println(X); 
        }
		
    }
}
