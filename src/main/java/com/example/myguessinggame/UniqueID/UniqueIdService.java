package com.example.myguessinggame.UniqueID;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Data
public class UniqueIdService {
    private UUID id;

    public UniqueIdService() {
        this.id = UUID.randomUUID();
    }

}
