package life.equester.logbookapp2.models.data;

import life.equester.logbookapp2.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}