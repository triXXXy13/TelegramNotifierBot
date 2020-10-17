package com.thebytefox.telegram.security;

import com.thebytefox.telegram.annotations.RequiredRoles;
import com.thebytefox.telegram.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Checks if user is authorized to use the desired command
 */
@Component
@Slf4j
public class AuthorizationService {
    /**
     * Checks user's permissions if class has method annotated with {@link RequiredRoles}
     *
     * @param user
     * @return authorization result
     */
    public final boolean authorize(Class<?> clazz, User user) {
        log.debug("Authorizing {} to use {}", user, clazz.getSimpleName());
        try {
            final RequiredRoles annotation = Stream.of(clazz.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(RequiredRoles.class))
                    .findFirst()
                    .orElseThrow(NoSuchMethodException::new)
                    .getDeclaredAnnotation(RequiredRoles.class);
            log.debug("User roles: {}\nRequired roles: {}", user.getRoles(), annotation.roles());
            return !Collections.disjoint(user.getRoles(), List.of(annotation.roles()));
        } catch (NoSuchMethodException e) {
            log.debug("No secured methods in class {}", clazz.getSimpleName());
            return true;
        }
    }
}
