package ggd.core.db;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import baytony.db.hibernate.BasicDao;

public class HibernateDao<Bean extends Serializable, ID extends Serializable> extends BasicDao<Bean, ID> {

	
	@Autowired(required = true)
	@Qualifier("SessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
