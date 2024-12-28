package solidprinciples.singleresponsibilityprinciple.corrected;

import solidprinciples.singleresponsibilityprinciple.Store;
import solidprinciples.singleresponsibilityprinciple.User;

public class UserPersistenceService {
    private Store store = new Store();

    public void saveUser(User user) {
        store.store(user);
    }

}
