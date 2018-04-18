package DAO;

import java.sql.SQLException;

public interface Acervo<obj> {
	public boolean criar(obj e) throws SQLException;
	public boolean editar(String param1,String param2)throws SQLException;
	public boolean pesquisar(String param)throws SQLException;
	public boolean excluir(String param)throws SQLException;
}
