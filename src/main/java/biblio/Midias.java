package biblio;

import java.sql.Date;

public class Midias {
	private static String titulo;
	private static String tipo;
	private static Date dtgravacao;
	public static String getTitulo() {
		return titulo;
	}
	public static void setTitulo(String titulo) {
		Midias.titulo = titulo;
	}
	public static String getTipo() {
		return tipo;
	}
	public static void setTipo(String tipo) {
		Midias.tipo = tipo;
	}
	public static Date getDtgravacao() {
		return dtgravacao;
	}
	public static void setDtgravacao(Date dtgravacao) {
		Midias.dtgravacao = dtgravacao;
	}
}
