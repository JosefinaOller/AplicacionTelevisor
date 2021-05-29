package monitoreoTelevisor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import controladorTelevisor.ControladorTelevisor;

public class ErroresTelevisor {
	
	private ControladorTelevisor controladorTelevisor;
	
	
	
	public ErroresTelevisor(ControladorTelevisor controladorTelevisor) {
		super();
		this.controladorTelevisor = controladorTelevisor;
		recibirError();
	}

	public void recibirError() {
		new Thread() {
            public void run() {
                try {
                    ServerSocket server = new ServerSocket(2070); //serverSocket de televisor desde el monitor
                    while (true) {

                        Socket socket= server.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String aviso=null; 
                        aviso=in.readLine();
                        if(aviso.equals("cambio"))
                        	cambioDeServidor();
                        else
                        	System.out.println("Se envio cualquier cosa");
                    }
                                                                                                                                                                                         

                } catch (Exception e) {
                	e.printStackTrace();
                    
                }
        
            }
	
        }.start();
	}

	protected void cambioDeServidor() {
		this.controladorTelevisor.cambiarServidor();
		
	}

}
