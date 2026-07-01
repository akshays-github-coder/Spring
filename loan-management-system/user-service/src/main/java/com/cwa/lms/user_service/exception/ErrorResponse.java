package com.cwa.lms.user_service.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        String message,
        int status,
        String error,
        String path,
        LocalDateTime timestamp
) {
}
