package org.jdtbee.spr.webapp.bootstrap;

import org.jdtbee.spr.webapp.domain.Author;
import org.jdtbee.spr.webapp.domain.Book;
import org.jdtbee.spr.webapp.domain.Publisher;
import org.jdtbee.spr.webapp.repositories.AuthorRepository;
import org.jdtbee.spr.webapp.repositories.BookRepository;
import org.jdtbee.spr.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;



  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    super();
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }



  @Override
  public void run(String... args) throws Exception {

    Author eric = new Author("Eric", "Evans");
    Author rod = new Author("Rod", "Johnson");

    Book ddd = new Book("Domain Driven Design", "123456");
    Book noEjb = new Book("JEE Developmment without EJB", "654321");

    Author ericSaved = authorRepository.save(eric);
    Book dddSaved = bookRepository.save(ddd);

    Author rodSaved = authorRepository.save(rod);
    Book noEjbSaved = bookRepository.save(noEjb);

    ericSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(noEjbSaved);

    authorRepository.save(ericSaved);
    authorRepository.save(rodSaved);

    Publisher publisher = new Publisher();
    publisher.setPublisherName("My Publisher");
    publisher.setAddress("123 Main");
    Publisher savedPublisher = publisherRepository.save(publisher);


    System.out.println("In Bootstrap");
    System.out.println("Author Count: " + authorRepository.count());
    System.out.println("Book Count: " + bookRepository.count());

    System.out.println("Publisher Count: " + publisherRepository.count());

  }

}
