package service.serimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.UserMapper;
import model.User;
import service.IuserService;

@Service
@Transactional
public class UserServiceimpl implements IuserService{
    @Autowired
    UserMapper userMapper;
	@Override
	public User findbyId(String username) {
		
		return userMapper.findbyId(username);
	}

}
