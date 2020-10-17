package com.thebytefox.telegram.bot.handler;

import com.thebytefox.telegram.service.ScheduleService;

/**
 * Base class for handlers that affect user's schedule
 */
public abstract class AbstractScheduleHandler extends AbstractBaseHandler {
    protected final ScheduleService scheduleService;

    public AbstractScheduleHandler(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
}
