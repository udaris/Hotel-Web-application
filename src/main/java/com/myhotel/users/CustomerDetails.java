package com.myhotel.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetails {
    @Autowired private UserRepository repo;

    public List<User> ListAll(){

        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any customers with ID "+id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if(count==null||count==0){
            throw new UserNotFoundException("Could not find any customers with ID "+id);
        }
        repo.deleteById(id);
    }


}





