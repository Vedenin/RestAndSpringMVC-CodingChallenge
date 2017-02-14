package com.github.vedenin.codingchallenge.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by slava on 11.02.17.
 */
public interface ErrorRepository extends CrudRepository<ErrorEntity, Long> {
}
