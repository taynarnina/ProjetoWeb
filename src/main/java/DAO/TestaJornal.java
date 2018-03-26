package DAO;

import java.sql.SQLException;

import biblio.Jornal;

public class TestaJornal {
	
	
	public static void main(String[] args) throws SQLException  {
		Jornal j = new Jornal();
		JornalDao jd = new JornalDao();
		
		jd.editar("comportas de boqueirão","jornal da correio");
			
		
	}
	

}
