package solidprinciples.singleresponsibilityprinciple.corrected;

import com.fasterxml.jackson.databind.ObjectMapper;
import solidprinciples.singleresponsibilityprinciple.Store;
import solidprinciples.singleresponsibilityprinciple.User;

import java.io.IOException;

public class UserController {
    private UserPersistenceService persistenceService = new UserPersistenceService();

    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        UserValidator validator = new UserValidator();
        boolean valid = validator.validate(user);
        if (!valid)
            return "ERROR";

        persistenceService.saveUser(user);
        return "SUCCESS";
    }
}