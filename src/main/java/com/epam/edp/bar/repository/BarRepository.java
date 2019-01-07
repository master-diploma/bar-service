package com.epam.edp.bar.repository;

import com.epam.edp.bar.entity.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Roman_Martseniuk
 */
public interface BarRepository extends CrudRepository<Message, Long> {
}
