package com.starhub.sites.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
@Component
public class StarhubPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return evaluate(authentication);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        /*Just a placeholder as this app would not use this at all*/
        return false;
    }

    protected boolean evaluate(Authentication authentication) {
        User user = (User)authentication.getPrincipal();
        return false;
    }

}
