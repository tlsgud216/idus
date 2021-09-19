package com.idus.backend.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionUtil {
    static public Long currentMemberId() {
        Authentication test = SecurityContextHolder.getContext().getAuthentication();
        String auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if (auth.equals("anonymousUser")) return null;
        else return Long.parseLong(auth);
    }
}
