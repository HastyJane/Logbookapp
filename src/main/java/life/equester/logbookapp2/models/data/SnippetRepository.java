package life.equester.logbookapp2.models.data;

import life.equester.logbookapp2.models.Snippet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface SnippetRepository extends CrudRepository<Snippet, String> {
}
