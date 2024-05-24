import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

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
    JLabel L1;
    JLabel L2;

    public Gui10() {
        setLayout(new FlowLayout());
        L1 = new JLabel("Estado del robot: " + X + ", " + Y);
        L2 = new JLabel("Direccion: " + direccion);
        add(L1);
        add(L2);
        
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

        setSize(400, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        Gui10 ventana = new Gui10();
    }

    private void actualizarEstado() {
        L1.setText("Estado del robot: " + X + ", " + Y);
        L2.setText("Direccion: " + direccion);
    }

    class agrega implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            X++;
		    direccion = "norte";
            System.out.println("Direccion: " + direccion);
            System.out.println("X: " + X);
            actualizarEstado();
        }
    }

    class resta implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            X--;
            direccion = "sur";
            System.out.println("Direccion: " + direccion);
            System.out.println("X: " + X);
            actualizarEstado();
        }
    }
    
    class oeste implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Y++;
            direccion = "oeste";
            System.out.println("Direccion: " + direccion);
            System.out.println("Y: " + Y);
            actualizarEstado();
        }
    }
    
    class este implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Y--;
            direccion = "este";
            System.out.println("Direccion: " + direccion);
            System.out.println("Y: " + Y);
            actualizarEstado();
        }
    }

    class guardarestado implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                FileWriter writer = new FileWriter("estado.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("X=" + X + "\n");
                bufferedWriter.write("Y=" + Y + "\n");
                bufferedWriter.write("Direccion=" + direccion + "\n");
                bufferedWriter.close();
                System.out.println("Estado guardado en estado.txt");
            } catch (IOException ex) {
                System.err.println("Error al guardar el estado: " + ex.getMessage());
            }
        }
    }
    
    class cargarestado implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("estado.txt"));
                String linea;
                while ((linea = reader.readLine()) != null) {
                    // Parsear la línea para obtener los valores
                    String[] partes = linea.split("=");
                    if (partes.length == 2) {
                        String clave = partes[0];
                        String valor = partes[1];
                        if (clave.equals("X")) {
                            X = Integer.parseInt(valor);
                        } else if (clave.equals("Y")) {
                            Y = Integer.parseInt(valor);
                        } else if (clave.equals("Direccion")) {
                            direccion = valor;
                        }
                    }
                }
                reader.close();
                actualizarEstado();
                System.out.println("Estado cargado desde estado_robot.txt");
            } catch (IOException ex) {
                System.err.println("Error al cargar el estado: " + ex.getMessage());
            }
        }
    }
}
