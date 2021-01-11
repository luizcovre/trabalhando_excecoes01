package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner read = new Scanner(System.in);
		SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numeroQuarto = read.nextInt();
		System.out.print("Data do check-in (dd/mm/aaaa): ");
		Date checkIn = dataSimples.parse(read.next());
		System.out.print("Data do check-out (dd/mm/aaaa): ");
		Date checkOut = dataSimples.parse(read.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro! - O check-out deve ser posterior a data do check-in");
		}else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Informe uma data para atualizar a reserva:");
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			checkIn = dataSimples.parse(read.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			checkOut = dataSimples.parse(read.next());
			
			Date hoje = new Date();
			if (checkIn.before(hoje) || checkOut.before(hoje)) {
				System.out.println("Erro! - As novas datas devem ser futuras");
			}else if (!checkOut.after(checkIn)) {
				System.out.println("Erro! - O check-out deve ser posterior a data do check-in");
			}else {
				reserva.atualizaDatas(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
		}
		
		read.close();
	}

}
