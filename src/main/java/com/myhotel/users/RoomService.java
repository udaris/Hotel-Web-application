package com.myhotel.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired private RoomRepository repo;

    public List<Rooms> listAll(){
    return (List<Rooms>) repo.findAll();
    }

    public void save(Rooms room) {
        repo.save(room);
    }
 public Rooms get(Integer id) throws RoomNotFoundException {
     Optional<Rooms> result = repo.findById(id);
     if(result.isPresent()){
         return result.get();
     }
     throw new RoomNotFoundException("Could not Room founded");
 }

 public void delete(Integer id) throws RoomNotFoundException {
     Long count = repo.countById(id);
     if(count==null||count==0){
         throw new RoomNotFoundException("Could not find any customers with ID "+id);
     }
        repo.deleteById(id);
 }

}











