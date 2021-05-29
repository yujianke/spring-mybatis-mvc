package service.serimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import mapper.UserMapper;
import model.User;
import service.IuserService;
@Service("IuserService1")
//@Transactional
public class UserServiceimpl implements IuserService{
	private static final Logger logger = LogManager.getLogger(UserServiceimpl.class);
    @Autowired
    UserMapper userMapper;
    @Autowired
    PlatformTransactionManager txManager;
	@Override
	public User findbyId(String username) {
		
		return userMapper.findbyId(username);
	}
	@Override
	public void insert(User user) {
		//定义事务隔离级别，传播行为，
	    DefaultTransactionDefinition def = new DefaultTransactionDefinition();  
	    def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);  
	    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);  
	    //事务状态类，通过PlatformTransactionManager的getTransaction方法根据事务定义获取；获取事务状态后，Spring根据传播行为来决定如何开启事务
	    TransactionStatus status = txManager.getTransaction(def);  
	    try {  
    	  userMapper.insert(user);
    	  txManager.commit(status);
	    } catch (RuntimeException e) {
	    	e.printStackTrace();
	        txManager.rollback(status);  //回滚
	    }  
		 
	}
	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		 userMapper.delete(username);
	}
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		 userMapper.update(user);
	}
	@Override
	public void insert2(User user) {
		  userMapper.insert(user);
		  int i=1/0;
	}
	@Override
	public List<User> findbyname(String username) {
		logger.info("查詢成功");
		
		logger.info("from:{}",username);
		logger.info("from:[{}]aaaaaaaaa",username);
		PageHelper.startPage(2, 3);
		PageHelper.orderBy("username asc");
		List<User> list = userMapper.findbyname(username);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		List<User> res = pageInfo.getList();    //返回分页记录
		return res;
	}

}
