package com.example.myguessinggame.UniqueID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UniqueIdController {

    @Autowired
    private UniqueIdService uniqueIdService;

    @GetMapping("/start")
    public UUID showID(){
        return uniqueIdService.getId();
    }
}
