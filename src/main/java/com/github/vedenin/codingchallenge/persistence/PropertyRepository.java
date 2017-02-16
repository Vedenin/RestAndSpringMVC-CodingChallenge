package com.github.vedenin.codingchallenge.persistence;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by slava on 11.02.17.
 */
public interface PropertyRepository extends CrudRepository<DefaultProperty, Long> {
}
