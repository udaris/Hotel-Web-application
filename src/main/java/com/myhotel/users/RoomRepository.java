package com.myhotel.users;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository <Rooms, Integer> {
    public Long countById(Integer id);
}
