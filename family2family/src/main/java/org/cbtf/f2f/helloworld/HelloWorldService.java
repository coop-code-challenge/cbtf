package org.cbtf.f2f.helloworld;

import org.cbtf.f2f.security.model.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldService {

    @GetMapping("api/hello/{name}")
    public String getHello(@PathVariable("name") String name) {
        return "Hello, " + name;
    }

    @GetMapping("api/user")
    public UserInfo getUserInfo(){
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userInfo;
    }
}
