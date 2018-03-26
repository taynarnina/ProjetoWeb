package biblio;

public class Livro {
	
	private String titulo;
	private String autor;
	private int isbn;
	private String editora;
	private int anopublic;
	private int numpaginas;
	private String area_conhecimento;
	private String tema;
	private static String con;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAnopublic() {
		return anopublic;
	}
	public void setAnopublic(int anopublic) {
		this.anopublic = anopublic;
	}
	public int getNumpaginas() {
		return numpaginas;
	}
	public void setNumpaginas(int numpaginas) {
		this.numpaginas = numpaginas;
	}
	public String getArea_conhecimento() {
		return area_conhecimento;
	}
	public void setArea_conhecimento(String area_conhecimento) {
		this.area_conhecimento = area_conhecimento;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public static String getCon() {
		return con;
	}
	public static void setCon(String con) {
		Livro.con = con;
	}
	

	
}
