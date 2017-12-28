package cn.et.lesson5.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.lesson5.dao.FeeDao;
@Repository
public class FeeDaoImpl implements FeeDao {
		@Autowired
		JdbcTemplate jdbcTemplate;
	
		/* (non-Javadoc)
		 * @see cn.et.lesson5.dao.FeeDao#addFee(int)
		 */
		public void addFee(int fee) {
			String sql="update fee set money=money+"+fee+" where id=1";
			jdbcTemplate.execute(sql);
		}
		/* (non-Javadoc)
		 * @see cn.et.lesson5.dao.FeeDao#queryFee()
		 */
		public int queryFee() {
			String sql="select money from fee where id=1";
			Integer count=jdbcTemplate.queryForObject(sql,Integer.class);
			return count;
		}
}
