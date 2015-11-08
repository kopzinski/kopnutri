package br.com.kopzinski.kopnutri.dao;

import br.com.kopzinski.kopnutri.entities.Antropometria;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class AntropometriaDAO implements CommonDaoInterface<Antropometria, String> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public AntropometriaDAO() {
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

	public void persist(Antropometria entity) {
            getCurrentSession().save(entity);
	}

	public void update(Antropometria entity) {
            getCurrentSession().update(entity);
	}

	public Antropometria findById(String id) {
		Antropometria book = (Antropometria) getCurrentSession().get(Antropometria.class, id);
		return book; 
	}

	public void delete(Antropometria entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Antropometria> findAll() {
		List<Antropometria> books = (List<Antropometria>) getCurrentSession().createQuery("from Antropometria").list();
		return books;
	}
        
        public List<Antropometria> findAllbyAtleta(int idAtleta) {
            Query query = getCurrentSession().createQuery("from Antropometria where idatleta = :idAtleta");
            query.setParameter("idAtleta", idAtleta);
            return (List<Antropometria>) query.list();
        }

	public void deleteAll() {
            List<Antropometria> entityList = findAll();
            for (Antropometria entity : entityList) {
                    delete(entity);
            }
	}
}
