package com.optional.OptionalDemo.serviceImpls;

import com.optional.OptionalDemo.entities.Phone;
import com.optional.OptionalDemo.entities.User;
import com.optional.OptionalDemo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Phone> collect = userList.stream()
                .filter(user -> user.getUserId().equals(userId))
                .map(user -> user.getPhones())
                .flatMap(phones -> phones.stream())
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public Map<String, List<Phone>> getPhoneNumbersForEachUser(List<User> userList) {
        Map<String, List<Phone>> collect = userList.stream()
                .collect(Collectors.toMap(user -> user.getFirstName(),user -> user.getPhones()));
        return collect;
    }
}
