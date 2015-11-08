package br.com.kopzinski.kopnutri.dao;

import br.com.kopzinski.kopnutri.entities.Atleta;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class AtletaDAO implements CommonDaoInterface<Atleta, String> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public AtletaDAO() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Atleta entity) {
		getCurrentSession().save(entity);
	}

	public void update(Atleta entity) {
		getCurrentSession().update(entity);
	}

	public Atleta findById(String id) {
		Atleta book = (Atleta) getCurrentSession().get(Atleta.class, id);
		return book; 
	}

	public void delete(Atleta entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Atleta> findAll() {
		List<Atleta> books = (List<Atleta>) getCurrentSession().createQuery("from Atleta").list();
		return books;
	}

	public void deleteAll() {
		List<Atleta> entityList = findAll();
		for (Atleta entity : entityList) {
			delete(entity);
		}
	}
}
