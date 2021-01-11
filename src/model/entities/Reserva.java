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
	
	public String atualizaDatas(Date checkIn, Date checkOut) {
		Date hoje = new Date();
		if (checkIn.before(hoje) || checkOut.before(hoje)) {
			return "Erro! - As novas datas devem ser futuras";
		}
		if (!checkOut.after(checkIn)) {
			return "Erro! - O check-out deve ser posterior a data do check-in";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
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
