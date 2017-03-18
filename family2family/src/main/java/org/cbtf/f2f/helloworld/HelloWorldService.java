package org.cbtf.f2f.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${org.cbtf.apiRoot}/hello")
public class HelloWorldService {

    @GetMapping("/{name}")
    public String getHello(@PathVariable("name") String name) {
        return "Hello, " + name;
    }
}
