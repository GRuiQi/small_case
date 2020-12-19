package service;

import bean.User;

public interface UserService {
    User findUserByName(String name);
}
