package mapper;

import org.apache.ibatis.annotations.Mapper;

import model.User;

@Mapper
public interface UserMapper {
	User findbyId(String username);
}
