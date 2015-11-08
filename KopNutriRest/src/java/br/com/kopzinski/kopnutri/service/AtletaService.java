package br.com.kopzinski.kopnutri.service;

import br.com.kopzinski.kopnutri.dao.AtletaDAO;
import br.com.kopzinski.kopnutri.entities.Atleta;
import java.util.List;


public class AtletaService {

	private static AtletaDAO dao;

	public AtletaService() {
		dao = new AtletaDAO();
	}

	public void persist(Atleta entity) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public void update(Atleta entity) {
		dao.openCurrentSessionwithTransaction();
		dao.update(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public Atleta findById(String id) {
		dao.openCurrentSession();
		Atleta book = dao.findById(id);
		dao.closeCurrentSession();
		return book;
	}

	public void delete(String id) {
		dao.openCurrentSessionwithTransaction();
		Atleta entidade = dao.findById(id);
		dao.delete(entidade);
		dao.closeCurrentSessionwithTransaction();
	}

	public void delete(Atleta entidade) {
		delete(String.valueOf(entidade.getId()));
	}        
        
	public List<Atleta> findAll() {
		dao.openCurrentSession();
		List<Atleta> books = dao.findAll();
		dao.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		dao.openCurrentSessionwithTransaction();
		dao.deleteAll();
		dao.closeCurrentSessionwithTransaction();
	}

	public AtletaDAO dao() {
		return dao;
	}
}