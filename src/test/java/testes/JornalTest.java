package testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import DAO.Conexao;
import DAO.JornalDao;
import biblio.Jornal;

public class JornalTest {
	
	private static Connection con;
	private PreparedStatement sql;
	private JornalDao jd;
	private static final Logger logger = LogManager.getLogger(JornalTest.class);
	
	@BeforeClass
	public static void testaconexao(){
		try {
			con = Conexao.fazconexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("ocorreu alguma fala na conexão");
			e.printStackTrace();
			
		}	
	}
	
	@AfterClass
	public static void fecharConexao() {
		try {
			if(!con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("ocorreu uma falha ao fechar conexão");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCriar() {
		Jornal j1 = new Jornal();
		
		j1.setTitulo("comportas de boqueirão");
		j1.setDtpublic("10/10/2001");
		j1.setEdicao(5);
		
		try {
			testaconexao();
			assertFalse(jd.criar(j1));
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
