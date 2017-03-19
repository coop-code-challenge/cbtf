package org.cbtf.f2f.helloworld;

import org.cbtf.f2f.security.model.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${org.cbtf.apiRoot}/user")
public class UserController {

    @GetMapping()
    public UserInfo getUserInfo(){
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userInfo;
    }
}
