package com.example.myguessinggame.UniqueID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UniqueIdServiceTest {

    @Autowired
    UniqueIdService uniqueIdService;

    @Test
    void isNotNull(){
         uniqueIdService= new UniqueIdService();
        assertNotNull(uniqueIdService.getId());
    }

    @Test
    void idIsUnique(){
        uniqueIdService= new UniqueIdService();
        UniqueIdService uniqueIdService2= new UniqueIdService();
        assertNotEquals(uniqueIdService.getId(),uniqueIdService2.getId());
    }


}