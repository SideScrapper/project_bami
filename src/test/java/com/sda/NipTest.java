package com.sda;

import com.sda.exceptions.InvalidNipNumberException;
import org.junit.Test;

import static org.junit.Assert.*;

public class NipTest {


    @Test
    public void nipIsCorrect() throws InvalidNipNumberException {
        Nip nip1 = new Nip("123-456-32-18");
        assertEquals("123-456-32-18", nip1.getNip());

        Nip nip2 = new Nip("123 456 32 18");
        assertEquals("123-456-32-18", nip2.getNip());
    }




}