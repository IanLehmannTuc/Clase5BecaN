package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class Ejercicio1 {

	public static void main(String[] args) {

		String archivoEntrada = "compras.txt";
		try {
			List<String> lista = Files.readAllLines(Paths.get(archivoEntrada));
			String[] datosProducto1 = lista.get(1).split(" ");
			String[] datosProducto2 = lista.get(2).split(" ");
			String[] datosProducto3 = lista.get(3).split(" ");
			
			Producto producto1 = new Producto(datosProducto1[1], datosProducto1[2], Float.parseFloat(datosProducto1[0]));
			Producto producto2 = new Producto(datosProducto2[1], datosProducto2[2], Float.parseFloat(datosProducto2[0]));
			Producto producto3 = new Producto(datosProducto3[1], datosProducto3[2], Float.parseFloat(datosProducto3[0]));
			
			Carrito carrito = new Carrito(producto1, producto2, producto3, LocalDateTime.parse("2023-10-14T18:03:00"));
			
			Persona persona1 = new Persona("Ian", "Lehmann", LocalDateTime.parse("1997-03-02T10:00:00"), carrito);
			
			Carrito miCarrito = persona1.getCarrito();
			float resultado = miCarrito.costoFinal();
			System.out.println(resultado);
		}
		catch(IOException e){
			System.out.println(e);
		}
		
	}

}
