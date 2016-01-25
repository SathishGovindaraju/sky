package com.sky.services;

import com.sky.others.Location;
import com.sky.exceptions.InvalidCustomerIdException;
import org.junit.Test;

import static org.junit.Assert.*;

public class StubCustomerLocationServiceTest {

    private CustomerLocationService locationService = new StubCustomerLocationService();

    @Test
    public void shouldReturnLocationIdAs_LONDON_whenRequestedWithValidCustomerId(){
        final Location locationId = locationService.getLocationIdFor("londonCustomer");
        assertTrue(Location.LONDON.equals(locationId));
    }

    @Test
    public void shouldReturnLocationIdAs_LIVERPOOL_whenRequestedWithValidCustomerId(){
        final Location locationId = locationService.getLocationIdFor("liverpoolCustomer");
        assertTrue(Location.LIVERPOOL.equals(locationId));
    }

    @Test(expected = InvalidCustomerIdException.class)
    public void shouldThrowException_whenRequestedWithInvalidCustomerId(){
        locationService.getLocationIdFor("invalidCustomerId");
    }
}