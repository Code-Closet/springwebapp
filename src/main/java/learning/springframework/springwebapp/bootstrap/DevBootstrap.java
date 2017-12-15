package learning.springframework.springwebapp.bootstrap;

import learning.springframework.springwebapp.model.Author;
import learning.springframework.springwebapp.model.Book;
import learning.springframework.springwebapp.model.Publisher;
import learning.springframework.springwebapp.repositories.AuthorRepository;
import learning.springframework.springwebapp.repositories.BookRepository;
import learning.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepo;
    private BookRepository bookRepo;
    private PublisherRepository publisherRepo;

    public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        init();
    }

    private void init(){
        Publisher publisher = new Publisher("DC Books");
        publisherRepo.save(publisher);

        Author che = new Author("Chetan", "Bhagat");
        Book fps = new Book("Five Point Someone", "1234", publisher);
        che.getBooks().add(fps);
        authorRepo.save(che);
        bookRepo.save(fps);

        Author rp = new Author("Raman", "Pillai");
        Book mrt = new Book("Marthanda Varma", "1235", publisher);
        rp.getBooks().add(mrt);
        authorRepo.save(rp);
        bookRepo.save(mrt);
    }
}
