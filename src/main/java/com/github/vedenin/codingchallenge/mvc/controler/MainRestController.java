package com.github.vedenin.codingchallenge.mvc.controler;

import com.github.vedenin.codingchallenge.mvc.model.ResponseChangeStatus;
import com.github.vedenin.codingchallenge.persistence.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @Inject
    PropertyService propertyService;

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

    @RequestMapping(value = "/rest/property",  method = RequestMethod.GET)
    public ResponseEntity<DefaultProperty> getProperty(@RequestParam(value="access_key", defaultValue = "") String accessKey) {
        if(ACCESS_KEY.equals(accessKey)) {
            return ResponseEntity.ok(propertyService.getDefaultProperties());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @RequestMapping(value = "/rest/property",  method = RequestMethod.POST)
    public ResponseEntity<ResponseChangeStatus> setProperty(
            @RequestParam(value="access_key", defaultValue = "") String accessKey,
            @RequestBody DefaultProperty defaultProperties) {
        if(ACCESS_KEY.equals(accessKey)) {
            propertyService.setDefaultProperties(defaultProperties);
            return ResponseEntity.ok(new ResponseChangeStatus());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
