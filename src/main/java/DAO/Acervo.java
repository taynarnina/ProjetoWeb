package DAO;

import java.sql.SQLException;

public interface Acervo<obj> {
	public void criar(obj e) throws SQLException;
	public void editar(String param1,String param2)throws SQLException;
	public void pesquisar(String param)throws SQLException;
	public void excluir(String param)throws SQLException;
}
