package org.jdtbee.spr.webapp.repositories;

import org.jdtbee.spr.webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
