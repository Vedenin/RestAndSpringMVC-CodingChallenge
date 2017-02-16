package com.github.vedenin.codingchallenge.persistence;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Returns default properties
 *
 * Created by slava on 16.02.17.
 */
@Service
public class PropertyService {
    @Inject
    PropertyRepository repository;

    public DefaultProperty getDefaultProperties() {
        DefaultProperty properties = repository.findOne(1L);
        if(properties == null) {
            properties = new DefaultProperty();
            repository.save(properties);
        }
        return properties;
    }

    public void setDefaultProperties(DefaultProperty properties) {
        repository.save(properties);
    }
}
