package com.cwa.lms.ls.client;

import com.cwa.lms.ls.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service",
        url = "http://localhost:8080"
)
public interface UserClient {

    @GetMapping("/lms/api/users/profile/{id}")
    UserResponse getUser(@PathVariable Long id);
}
