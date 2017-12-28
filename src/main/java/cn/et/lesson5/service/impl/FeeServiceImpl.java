package cn.et.lesson5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson5.dao.FeeDao;
import cn.et.lesson5.service.FeeService;
@Service
public class FeeServiceImpl implements FeeService {
		@Autowired
		FeeDao feeDao;
	
	
		/* (non-Javadoc)
		 * @see cn.et.lesson5.service.impl.FeeService#addFee(int)
		 */
		public void addFee(int fee) {
			feeDao.addFee(fee);
		}
	
		/* (non-Javadoc)
		 * @see cn.et.lesson5.service.impl.FeeService#queryFee()
		 */
		public int queryFee() {
			
			int count=feeDao.queryFee();
			return count;
		}
}
