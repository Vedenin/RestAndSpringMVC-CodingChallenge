package com.github.vedenin.codingchallenge.mvc.rest;

import com.github.vedenin.codingchallenge.persistence.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.collect.Lists;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by slava on 13.02.17.
 */
@RestController
public class MainRestController {
    private static final String ACCESS_KEY = "sg435jklj";

    @Inject
    UserRepository userRepository;
    @Inject
    HistoryRepository historyRepository;
    @Inject
    ErrorRepository errorRepository;

    @RequestMapping(value = "/rest/user",  method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> getUsers(@RequestParam(value="access_key", defaultValue = "") String accessKey) {
        if(ACCESS_KEY.equals(accessKey)) {
            return ResponseEntity.ok(Lists.newArrayList(userRepository.findAll()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @RequestMapping(value = "/rest/history",  method = RequestMethod.GET)
    public ResponseEntity<List<HistoryEntity>> getHistories(@RequestParam(value="access_key", defaultValue = "") String accessKey) {
        if(ACCESS_KEY.equals(accessKey)) {
            return ResponseEntity.ok(Lists.newArrayList(historyRepository.findAll()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @RequestMapping(value = "/rest/error",  method = RequestMethod.GET)
    public ResponseEntity<List<ErrorEntity>> getErrors(@RequestParam(value="access_key", defaultValue = "") String accessKey) {
        if(ACCESS_KEY.equals(accessKey)) {
            return ResponseEntity.ok(Lists.newArrayList(errorRepository.findAll()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
