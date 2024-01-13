package com.betting.karakoc.security;



import com.betting.karakoc.exceptions.GeneralException;
import com.betting.karakoc.model.real.UserEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextUtil {


    public UserEntity getCurrentUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if (authentication.getPrincipal() instanceof AnonymousAuthenticationToken) {
            throw new GeneralException("Please log in.",403);
        }
        UserCustomDetails userDetails = (UserCustomDetails) authentication.getPrincipal();
        return userDetails.getUser();
    }
}