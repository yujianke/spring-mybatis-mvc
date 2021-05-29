package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import model.User;

@Mapper
public interface UserMapper {
	User findbyId(String username);

	void insert(User user);

	Integer delete(String username);

	void update(User user);

	List<User> findbyname(String username);
}
