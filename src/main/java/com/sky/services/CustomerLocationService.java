package com.sky.services;

import com.sky.exceptions.InvalidCustomerIdException;
import com.sky.others.Location;

public interface CustomerLocationService {
    Location getLocationIdFor(String customerId) throws InvalidCustomerIdException;
}
