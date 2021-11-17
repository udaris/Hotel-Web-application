package com.myhotel.users;

public class RoomNotFoundException extends Throwable {
    public RoomNotFoundException(String message) {
        super(message);
    }
}
