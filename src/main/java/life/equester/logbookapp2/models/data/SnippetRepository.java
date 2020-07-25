package life.equester.logbookapp2.models.data;

import life.equester.logbookapp2.models.Snippet;
import life.equester.logbookapp2.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;



@Repository
@Transactional
public interface SnippetRepository extends CrudRepository<Snippet, Integer> {
    List<Snippet> findByTimeStampBetweenAndUserIdOrderByTimeStampDesc(Date start, Date end, int userId);
    List<Object> findAllById(int userId);
}
