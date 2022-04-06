package com.company.workingWithFiles.users.services.impl;

import com.company.workingWithFiles.users.User;
import com.company.workingWithFiles.users.services.Services;
import static com.company.workingWithFiles.users.Users.*;

public class ServiceImpl implements Services {

    @Override
    public void add(User user) {
        USERS.add(user);
    }

    @Override
    public void remove(String userName) {
        for (User x:USERS) {
            if (x.getName().equals(userName)){
                USERS.remove(x);
                return;
            }
        }
    }

}
