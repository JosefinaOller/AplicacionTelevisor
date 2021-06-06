package controladorTelevisor;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


import vistaTelevisor.VentanaTelevisor;



public class ControladorTelevisor {
	
	private VentanaTelevisor vistaTelevisor;
	private ArrayList <String> listaUsuarios;
	private ArrayList <Character> listaBoxes;
	private int cambio=0;
	
	private int puerto=1235;


	
	public ControladorTelevisor() {
		
		this.vistaTelevisor = new VentanaTelevisor();
		vistaTelevisor.setVisible(true);
		this.listaUsuarios = new ArrayList<String>();
		this.listaBoxes = new ArrayList<Character>();
		recibir();

	}

	private void recibir() {
		 new Thread() {
				public void run() {
					
	                try {
	                	
	                	ServerSocket server = new ServerSocket(puerto);
	                	
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

	public void cambiarServidor() {
		if(cambio==0) {
			System.out.println("Televisor cambiando del puerto...");
			this.setPuerto(puerto+200);
			recibir();
			cambio=1;
		}
		
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	
}
