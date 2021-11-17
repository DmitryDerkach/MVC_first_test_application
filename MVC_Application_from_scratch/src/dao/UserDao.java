package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import entity.Gender;
import entity.User;
import lombok.SneakyThrows;
import util.ConnectionManager;

public class UserDao implements Dao<Integer, User> {
	
	private static final UserDao INSTANSE = new UserDao();
	
	private static final String SAVE_SQL = "insert into users ("
			+ "name, birthday, email, password, role, gender) values ("
			+ "?, ?, ?, ?, ?, ?)";
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@SneakyThrows
	public User save(User entity) {
		try(Connection connection = ConnectionManager.get();
			PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setObject(1, entity.getName());
			preparedStatement.setObject(2, entity.getBirthday());
			preparedStatement.setObject(3, entity.getEmail());
			preparedStatement.setObject(4, entity.getPassword());
			preparedStatement.setObject(5, entity.getRole().toString());
			preparedStatement.setObject(6, entity.getGender().toString());
			
			preparedStatement.executeUpdate();
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			generatedKeys.next();
			entity.setId(generatedKeys.getObject("id", Integer.class));
			return entity;
		}	
	}

	public static UserDao getInstance() {
		return INSTANSE;
	}
}
