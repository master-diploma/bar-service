package org.martseniuk.diploma.bar.repository;

import org.martseniuk.diploma.bar.entity.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Roman_Martseniuk
 */
public interface BarRepository extends CrudRepository<Message, Long> {
}
