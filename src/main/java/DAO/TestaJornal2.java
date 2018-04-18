package DAO;

import java.sql.SQLException;

import biblio.Jornal;

public class TestaJornal2 {
	
	
	public static void main(String[] args) throws SQLException  {
		Jornal j1 = new Jornal();
		JornalDao jd = new JornalDao();
		
		j1.setTitulo("comportas de boqueirão");
		j1.setDtpublic("10/02/2016");
		j1.setEdicao(5);
		
		jd.criar(j1);
		
	}
	

}
