package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import vista.VentanaTelevisor;



public class Televisor implements ActionListener {
	
	private VentanaTelevisor vistaTelevisor;
	private ArrayList <String> listaUsuarios;
	private ArrayList <Character> listaBoxes;


	
	public Televisor() {
		
		this.vistaTelevisor = new VentanaTelevisor();
		vistaTelevisor.setVisible(true);
		vistaTelevisor.setActionlistener(this);
		this.listaUsuarios = new ArrayList<String>();
		this.listaBoxes = new ArrayList<Character>();


		
	}

	private void recibir() {
		 new Thread() {
				public void run() {
					
	                try {
	                	
	                	ServerSocket server = new ServerSocket(1235);
	                	
	                	while (true) {
	                	Socket s = server.accept();
	                	BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        
	                	String msg=in.readLine(); //recibo el box
                        char box=(msg.charAt(0));

                        String documento=msg.substring(1, msg.length());
                        listaUsuarios.add(0,documento);
                        listaBoxes.add(0,box);

                        mostrar();

	                }
	                    
	                  

	                } catch (Exception e) {
	                    e.printStackTrace();
	                	JOptionPane.showMessageDialog(null,"ERROR COMUNICACION TELEVISOR", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

	                }

	            }
	        }.start();

		
	}


	protected void mostrar() {
		int i=0;
		int maximo = 10;
		this.vistaTelevisor.limpiar();
		String documentos="",boxes="";

		while(i<listaUsuarios.size() && i<maximo) {
			
			if (documentos.equalsIgnoreCase("")) {
				documentos = listaUsuarios.get(i) + "\n";
				boxes = listaBoxes.get(i) + "\n";
			}
			else {
				documentos =documentos + listaUsuarios.get(i) + "\n";
				boxes =boxes + listaBoxes.get(i) + "\n";
			}

			i++;
		}
		this.vistaTelevisor.setDocumento(documentos);
		this.vistaTelevisor.setBox(boxes);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Televisor televisor= new Televisor();
		televisor.recibir();
	}
	
	
}
