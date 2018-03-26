package biblio;

import java.sql.Date;

public class Jornal {
	
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
	public Date getDtpublic() {
		return dtpublic;
	}
	public void setDtpublic(Date dtpublic) {
		this.dtpublic = dtpublic;
	}
	private String titulo;
	private int edicao;
	private Date dtpublic;

	




}
