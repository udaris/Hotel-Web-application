package com.myhotel.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired private FoodRepository repo;

    public List<foods> listAll(){
        return (List<foods>) repo.findAll();
    }
}

