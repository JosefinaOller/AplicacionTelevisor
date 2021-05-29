package main;

import controladorTelevisor.ControladorTelevisor;
import monitoreoTelevisor.ErroresTelevisor;

public class Main {

	public static void main(String[] args) {
		ControladorTelevisor controlador=new ControladorTelevisor();
		ErroresTelevisor error=new ErroresTelevisor(controlador);
	}

}
