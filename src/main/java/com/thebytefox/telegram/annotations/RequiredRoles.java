package com.thebytefox.telegram.annotations;

import com.thebytefox.telegram.model.Role;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RequiredRoles {
    Role[] roles();
}
