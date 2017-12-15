package learning.springframework.springwebapp.repositories;

import learning.springframework.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
