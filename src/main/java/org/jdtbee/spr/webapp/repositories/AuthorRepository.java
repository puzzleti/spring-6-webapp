package org.jdtbee.spr.webapp.repositories;

import org.jdtbee.spr.webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
