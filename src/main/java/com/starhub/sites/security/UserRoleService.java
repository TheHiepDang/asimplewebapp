package com.starhub.sites.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/starhub/checkAuth")
public class UserRoleService {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }
}
