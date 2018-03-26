package biblio;

import java.sql.Date;

public class Revista {
	private static String titulo;
	private static String editora;
	private static String dtpublicacao;
	private static int edicao;
	private static int numpaginas;
	
	public static String getTitulo() {
		return titulo;
	}
	public static void setTitulo(String titulo) {
		Revista.titulo = titulo;
	}
	public static String getEditora() {
		return editora;
	}
	public static void setEditora(String editora) {
		Revista.editora = editora;
	}
	public static String getDtpublicacao() {
		return dtpublicacao;
	}
	public static void setDtpublicacao(String dtpublicacao) {
		Revista.dtpublicacao = dtpublicacao;
	}
	public static int getEdicao() {
		return edicao;
	}
	public static void setEdicao(int edicao) {
		Revista.edicao = edicao;
	}
	public static int getNumpaginas() {
		return numpaginas;
	}
	public static void setNumpaginas(int numpaginas) {
		Revista.numpaginas = numpaginas;
	}

}
