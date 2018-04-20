package br.edu.ufab.dao.itens;

import java.sql.SQLException;
import java.util.List;

public interface ItemDaoIF {
	public boolean adiciona(Object o) throws SQLException;
	public Object pesquisa(int id) throws SQLException;
	public List<Object> lista() throws SQLException;
	public boolean altera(Object o) throws SQLException;
	public boolean remove(Object o) throws SQLException;
}
