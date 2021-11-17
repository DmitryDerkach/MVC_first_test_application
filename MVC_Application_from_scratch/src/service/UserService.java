package service;

import dao.UserDao;
import dto.CreateUserDto;
import entity.User;
import exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mapper.CreateUserMapper;
import validator.CreateUserValidator;
import validator.ValidationResult;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

	private final static UserService INSTANCE = new UserService();
	
	private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
	private final UserDao userDao = UserDao.getInstance(); 
	private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
	
	public Integer create(CreateUserDto userDto) {
		ValidationResult validationResult = createUserValidator.isValid(userDto);
		if (!validationResult.isValid()) {
			throw new ValidationException(validationResult.getErrors());
		}
		User userEntity = createUserMapper.mapFrom(userDto);
		userDao.save(userEntity);
		return userEntity.getId();
	};
	
	public static UserService getInstance() {
		return INSTANCE;
	}
	
}
