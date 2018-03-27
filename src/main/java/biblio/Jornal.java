package biblio;

import java.sql.Date;

public class Jornal {
	
	private String titulo;
	private int edicao;
	private String dtpublic;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getDtpublic() {
		return dtpublic;
	}
	public void setDtpublic(String dtpublic) {
		this.dtpublic = dtpublic;
	}
}
