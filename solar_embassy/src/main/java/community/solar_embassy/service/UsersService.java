package community.solar_embassy.service;
import community.solar_embassy.dto.Users;

public interface UsersService {

    Users login(String userId, String pw);

    int signup_normal(Users users);
}