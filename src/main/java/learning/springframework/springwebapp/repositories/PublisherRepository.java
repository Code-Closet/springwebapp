package learning.springframework.springwebapp.repositories;

import learning.springframework.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
}
