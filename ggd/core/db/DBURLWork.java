/**
 * 
 */
package ggd.core.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.hibernate.jdbc.Work;

/**
 * 實作Hibernate {@link Work}的物件，用以取得Hibernate DB URL的相關資訊．
 *
 * @author baytony
 *
 */
public class DBURLWork implements Work {
	
	private String url; 
	
	protected DBURLWork() {
	}

	/* (non-Javadoc)
	 * @see org.hibernate.jdbc.Work#execute(java.sql.Connection)
	 */
	@Override
	public void execute(Connection conn) throws SQLException {
		DatabaseMetaData meta = conn.getMetaData();
		url = meta.getURL();
	}
	
	/**
	 * 取得Hibernate DB URL的相關資訊．
	 * @return
	 */
	public String getDBUrlMetaData(){
		return url;
	}

}
