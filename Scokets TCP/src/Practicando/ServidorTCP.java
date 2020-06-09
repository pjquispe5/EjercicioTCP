package Practicando;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
	public static void main(String[] args) throws IOException {
		ServerSocket socketServidor=null; //creamos el socket del servidor
		Socket socketCliente= null;  //creamos el socket para el cliente
		//para los flujos de entrada y salida del cliente
		BufferedReader entrada=null;
		PrintWriter salida=null;
		
		System.out.println("----BIENVENIDO AL SERVIDOR----");
		
		//definimos el socket del servidor
		try {  //para el manejo de excepciones
			//definimos el socket del servidor con el mismo puerto del cliente
			socketServidor=new ServerSocket(1234);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//para los clientes
		try {
			//para recibir a los clientes
			while(true) {
				socketCliente=socketServidor.accept(); //el socket del servidor acepta al nuevo cliente
				//flujos de entrada y salida del cliente
				entrada=new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				salida=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
	  			
				System.out.println("\nNuevo cliente :)");
				while(true) {
					//ECO
					//recibimos el mensaje del cliente
					String cad=entrada.readLine(); //lee y obtiene el mensaje que envio el cliente
					System.out.println("\nMensaje del cliente: "+cad); //imprimimos el mensaje cad del cliente		
					String respuesta="";
					switch (cad) {
					case "1":
						respuesta="Papel";
						break;
					case "2":
						respuesta="Piedra";
						break;
					case "3":
						respuesta="Tijera";
						break;	
					default:
						System.out.println("Fin cliente");
						break;
					}
					if(cad.equals("4"))break;
					salida.println(respuesta); //envia el mensaje al cliente ECO
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		//liberamos recursos
		salida.close();
		entrada.close();
		socketServidor.close();
		socketCliente.close();
	}
	
}
