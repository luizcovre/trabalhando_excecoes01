package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizaDatas(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", check-in: "
				+ dataSimples.format(checkIn)
				+ ", check-out: "
				+ dataSimples.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";
	}
	
}
