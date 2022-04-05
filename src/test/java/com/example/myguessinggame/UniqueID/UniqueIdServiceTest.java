package com.example.myguessinggame.UniqueID;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueIdServiceTest {

    @Test
    void isNotNull(){
        UniqueIdService uniqueIdService= new UniqueIdService();
        assertNotNull(uniqueIdService.getId());
    }

    @Test
    void idIsUnique(){
        UniqueIdService uniqueIdService= new UniqueIdService();
        UniqueIdService uniqueIdService2= new UniqueIdService();
        assertNotEquals(uniqueIdService.getId(),uniqueIdService2.getId());
    }


}