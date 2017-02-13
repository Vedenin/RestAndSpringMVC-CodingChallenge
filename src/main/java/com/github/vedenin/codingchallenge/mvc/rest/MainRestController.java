package com.github.vedenin.codingchallenge.mvc.rest;

import com.github.vedenin.codingchallenge.persistence.UserEntity;
import com.github.vedenin.codingchallenge.persistence.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/rest/users")
    public ResponseEntity<List<UserEntity>> getUsers(@RequestParam(value="access_key", defaultValue = "") String accessKey) {
        if(ACCESS_KEY.equals(accessKey)) {
            return ResponseEntity.ok(Lists.newArrayList(userRepository.findAll()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
