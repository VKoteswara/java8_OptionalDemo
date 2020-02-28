package com.optional.OptionalDemo.services;

import com.optional.OptionalDemo.entities.Phone;
import com.optional.OptionalDemo.entities.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User addUser(User user);
    public List<User> getUserS();
    public List<Phone> getPhoneNumberByUserId(List<User> userList,Long userId);
    public Map<String,List<Phone>> getPhoneNumbersForEachUser(List<User> userList);
}
