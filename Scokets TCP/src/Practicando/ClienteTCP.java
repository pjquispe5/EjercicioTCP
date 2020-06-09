package Practicando;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteTCP {
	public static void main(String[] args) throws IOException {
		Socket socketCliente= null;  //creamos el socket para el cliente
		//para los flujos de entrada y salida del cliente
		BufferedReader entrada=null;
		PrintWriter salida=null;
		
		System.out.println("----BIENVENIDO CLIENTE----");
		
		//definimos el socket y los flujos
		try { //para el manejo de excepciones
			//definimos el socket del cliente
			socketCliente=new Socket("localhost", 1234);
			//definimos flujos de entrada y salida
			entrada=new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			salida=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//para escribir en consola
		BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) { //para recibir varios mensajes
				
				System.out.println("******************** MENÚ ******************");
				System.out.println("Seleccione una opcion:");
				System.out.println("\nOpción 1");
				System.out.println("Opción 2");
				System.out.println("Opción 3");
				System.out.println("Salir");
				String opcion=leer.readLine();
				
				switch (opcion) {
				case "1":
					salida.println(opcion);
					opcion=entrada.readLine();
					System.out.println("La respuesta del servidor es: "+opcion);
					break;
				case "2":
					salida.println(opcion);
					opcion=entrada.readLine();
					System.out.println("La respuesta del servidor es: "+opcion);
					break;	
				case "3":
					salida.println(opcion);
					opcion=entrada.readLine();
					System.out.println("La respuesta del servidor es: "+opcion);
					break;	
				default:
					salida.println(opcion);
					opcion=entrada.readLine();
					System.out.println("Saliendo...");
					break;
				}
			if(opcion.equals("4"))break;
			}
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//liberamos recursos
		salida.close();
		entrada.close();
		leer.close();
		socketCliente.close();
		
	}
}
