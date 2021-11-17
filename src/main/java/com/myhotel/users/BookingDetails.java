package com.myhotel.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetails {
    @Autowired private BookingsRepository repo;

    public List<Bookings> listAll(){
    return (List<Bookings>) repo.findAll();
    }


    public void save(Bookings bookings) {
        repo.save(bookings);
    }

}







