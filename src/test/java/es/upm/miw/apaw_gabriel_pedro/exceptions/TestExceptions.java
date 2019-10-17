package es.upm.miw.apaw_gabriel_pedro.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExceptions {

    @Test
    void testBadRequestException(){
        Assertions.assertEquals("Bad", new BadRequestException("test").getMessage().substring(0,3));
    }

    @Test
    void testConflictException(){
        Assertions.assertEquals("Conflict", new ConflictException("test").getMessage().substring(0,8));
    }

    @Test
    void testNotFoundException(){
        Assertions.assertEquals("Not", new NotFoundException("test").getMessage().substring(0,3));
    }

    @Test
    void testErrorMessage(){
        Assertions.assertEquals("ErrorMessage",new ErrorMessage(new BadRequestException("test"),"test").toString().substring(0,12));
    }
}
