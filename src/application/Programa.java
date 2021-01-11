package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.ExcecaoDominio;

public class Programa {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int numeroQuarto = read.nextInt();
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			Date checkIn = dataSimples.parse(read.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			Date checkOut = dataSimples.parse(read.next());
			
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Informe uma data para atualizar a reserva:");
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			checkIn = dataSimples.parse(read.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			checkOut = dataSimples.parse(read.next());
			
			reserva.atualizaDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch (ExcecaoDominio e) {
			System.out.println("Erro! - " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		read.close();
	}

}
