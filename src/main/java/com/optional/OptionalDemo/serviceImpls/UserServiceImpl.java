package com.optional.OptionalDemo.serviceImpls;

import com.optional.OptionalDemo.Exceptions.EntityNotFoundException;
import com.optional.OptionalDemo.entities.Phone;
import com.optional.OptionalDemo.entities.User;
import com.optional.OptionalDemo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final List<User> userList = new ArrayList();
    @Override
    public User addUser(User user) {
       Optional<Long> userId= userList.stream()
                .filter(user1 -> user1.getUserId().equals(user.getUserId()))
                .map(user1 -> user1.getUserId())
                .findAny();
        if(!userId.isPresent())
        userList.add(user);
        return user;
    }

    @Override
    public List<User> getUserS() {
        return userList;
    }

    @Override
    public List<Phone> getPhoneNumberByUserId(List<User> userList, Long userId) {
        List<Phone> collect =Optional.ofNullable( userList.stream()
                .filter(user -> user.getUserId().equals(userId))
                .map(user -> user.getPhones())
                .flatMap(phones -> phones.stream())
                .filter(Objects::nonNull)
                .collect(Collectors.toList()))
                .filter(lt -> !lt.isEmpty())
                .orElseThrow(()->new EntityNotFoundException("no data found"));
        return collect;
    }

    @Override
    public Map<String, List<Phone>> getPhoneNumbersForEachUser(List<User> userList) {
        long l = System.currentTimeMillis();
        System.out.println("Before method execution" + l);
        Map<String, List<Phone>> collect = Optional.ofNullable(userList.stream()
                                                                        .filter(Objects::nonNull)
                                                                        .collect(Collectors.toMap(user -> user.getFirstName(),user -> user.getPhones())))
                                                                         .orElseThrow(()->new EntityNotFoundException("No data fount"));
        System.out.println("After method execution with stream" + (System.currentTimeMillis()-l));
        return collect;
    }
}
