package com.sky.services;

import com.sky.exceptions.InvalidCustomerIdException;
import com.sky.others.Location;

import java.util.HashMap;
import java.util.Map;

import static com.sky.others.Location.LIVERPOOL;
import static com.sky.others.Location.LONDON;

public class StubCustomerLocationService implements CustomerLocationService {
    private static Map<String, Location> customerLocationMapper = new HashMap<>();
    static {
        customerLocationMapper.put("londonCustomer", LONDON);
        customerLocationMapper.put("liverpoolCustomer", LIVERPOOL);
    }

    @Override
    public Location getLocationIdFor(String customerId) {
        if(isValidCustomer(customerId)) {
            return customerLocationMapper.get(customerId);
        }else {
            throw new InvalidCustomerIdException("Invalid customerId : " + customerId);
        }
    }

    private boolean isValidCustomer(String customerId) {
        return customerLocationMapper.containsKey(customerId);
    }
}
