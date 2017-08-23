package ggd.core.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import baytony.db.hibernate.BasicQuery;

public class HibernateQuery extends BasicQuery {

	@Autowired(required=true)
	@Qualifier("SessionFactory")
	private SessionFactory sessionFactory;
	
	private DBURLWork work;
	
	@Override
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 取得Hibernate DB URL的相關資訊．
	 * @return
	 */
	public synchronized String getDBUrlMetaData(){
		if(work == null){
			work = new DBURLWork();
			super.doWork(work);
		}
		return work.getDBUrlMetaData();
	}

}
