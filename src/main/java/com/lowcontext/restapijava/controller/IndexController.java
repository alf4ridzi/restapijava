package com.lowcontext.restapijava.controller;

import com.lowcontext.restapijava.models.dto.JSendResponse;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.time.Duration;
import java.util.HashMap;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class IndexController {

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSendResponse<?>> index() {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();

        long uptimeMS = runtimeBean.getUptime();

        Duration duration = Duration.ofMillis(uptimeMS);

        long days = duration.toDays();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        HashMap<String, String> data = new HashMap<>();

        data.put(
            "uptime",
            String.format(
                "%d days, %d hours, %d minutes, %d seconds",
                days,
                hours,
                minutes,
                seconds
            )
        );

        return ResponseEntity.ok(JSendResponse.success(data));
    }
}
