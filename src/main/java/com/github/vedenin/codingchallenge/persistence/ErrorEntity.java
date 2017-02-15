package com.github.vedenin.codingchallenge.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by slava on 15.02.17.
 */
@Entity
public class ErrorEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long   id;
    private String errorMessage;
    private Exception exp;

    public ErrorEntity(String errorMessage, Exception exp) {
        this.errorMessage = errorMessage;
        this.exp = exp;
    }

    public ErrorEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Exception getExp() {
        return exp;
    }

    public void setExp(Exception exp) {
        this.exp = exp;
    }
}
