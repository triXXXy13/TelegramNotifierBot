package com.thebytefox.telegram.bot.handler;

import com.thebytefox.telegram.service.UserService;

/**
 * Base class for handlers that affect users
 */
public abstract class AbstractUserHandler extends AbstractBaseHandler {
    protected final UserService userService;

    public AbstractUserHandler(UserService userService) {
        this.userService = userService;
    }
}
