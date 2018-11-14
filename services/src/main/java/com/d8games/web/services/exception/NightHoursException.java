package com.d8games.web.services.exception;

import com.d8games.web.services.config.ConfigManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FAILED_DEPENDENCY)
public class NightHoursException extends RuntimeException {

    public NightHoursException() {
        super(String.format("You cannot vouch between %s:00 and %s:00!",
                ConfigManager.getNightHoursStart(), ConfigManager.getNightHoursEnd()));
    }
}
