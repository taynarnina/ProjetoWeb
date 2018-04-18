package biblio;

public class Anais {
	private static String titulo;
	private static String tipo;
	private static String autores;
	private static String nome_congresso;
	private static int anopublic;
	private static String local;
	
	public static String getTitulo() {
		return titulo;
	}
	public static void setTitulo(String titulo) {
		Anais.titulo = titulo;
	}
	public static String getAutores() {
		return autores;
	}
	public static void setAutores(String autores) {
		Anais.autores = autores;
	}
	public static String getNome_congresso() {
		return nome_congresso;
	}
	public static void setNome_congresso(String nome_congresso) {
		Anais.nome_congresso = nome_congresso;
	}
	public static int getAnopublic() {
		return anopublic;
	}
	public static void setAnopublic(int anopublic) {
		Anais.anopublic = anopublic;
	}
	public static String getLocal() {
		return local;
	}
	public static void setLocal(String local) {
		Anais.local = local;
	}
	public static String getTipo() {
		return tipo;
	}
	public static void setTipo(String tipo) {
		Anais.tipo = tipo;
	}
	
}
