package com.optional.OptionalDemo.serviceImpls;

import com.optional.OptionalDemo.entities.Phone;
import com.optional.OptionalDemo.entities.User;
import com.optional.OptionalDemo.services.UserParallelStreamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserParallelStreamServiceImpl implements UserParallelStreamService {
    @Override
    public List<Phone> getPhoneNumberByUserId(List<User> userList, Long userId) {
        List<Phone> collect = userList.parallelStream()
                .filter(user -> user.getUserId().equals(userId))
                .map(user -> user.getPhones())
                .flatMap(phones -> phones.stream())
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public Map<String, List<Phone>> getPhoneNumbersForEachUser(List<User> userList) {
        long l = System.currentTimeMillis();
        System.out.println("Before method execution" + l);
        Map<String, List<Phone>> collect = userList.parallelStream()
                                                   .collect(Collectors.toMap(user -> user.getFirstName(),user -> user.getPhones()));
        System.out.println("After method execution with parallel stream " + (System.currentTimeMillis()-l));
        return collect;
    }
}
