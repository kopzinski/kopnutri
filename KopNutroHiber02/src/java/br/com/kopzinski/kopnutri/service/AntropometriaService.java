    package br.com.kopzinski.kopnutri.service;

import br.com.kopzinski.kopnutri.dao.AntropometriaDAO;
import br.com.kopzinski.kopnutri.entities.Antropometria;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author kopzinski
 */
@Path("antropometria")
public class AntropometriaService {

	private static AntropometriaDAO dao;

	public AntropometriaService() {
		dao = new AntropometriaDAO();
	}

	public void persist(Antropometria entity) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public void update(Antropometria entity) {
		dao.openCurrentSessionwithTransaction();
		dao.update(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public Antropometria findById(String id) {
		dao.openCurrentSession();
		Antropometria book = dao.findById(id);
		dao.closeCurrentSession();
		return book;
	}

	public void delete(String id) {
		dao.openCurrentSessionwithTransaction();
		Antropometria book = dao.findById(id);
		dao.delete(book);
		dao.closeCurrentSessionwithTransaction();
	}
        
	public void delete(Antropometria entidade) {
		delete(String.valueOf(entidade.getId()));
	}                

        @GET
        @Path("all")
	public List<Antropometria> findAll() {
            System.out.println("Kop! antropometria/findAll");
		dao.openCurrentSession();
		List<Antropometria> books = dao.findAll();
		dao.closeCurrentSession();
		return books;
	}
        
        
	public List<Antropometria> findAllByIdAtleta(int idAtleta) {
		dao.openCurrentSession();
		List<Antropometria> ants = dao.findAllbyAtleta(idAtleta);
		dao.closeCurrentSession();
		return ants;
	}

	public void deleteAll() {
		dao.openCurrentSessionwithTransaction();
		dao.deleteAll();
		dao.closeCurrentSessionwithTransaction();
	}

	public AntropometriaDAO dao() {
		return dao;
	}
}