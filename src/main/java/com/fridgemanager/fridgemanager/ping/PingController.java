package com.fridgemanager.fridgemanager.ping;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/ping")
public class PingController {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<PingResponse> ping() {
        PingResponse response = new PingResponse();
        response.setApplicationStatus("UP");
        response.setDate(LocalDateTime.now().format(formatter));
        return ResponseEntity.ok(response);
    }
}
