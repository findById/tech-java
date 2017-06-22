package org.cn.web.rbac.service;

import org.cn.web.rbac.domain.User;

import java.io.Serializable;
import java.util.List;

public interface UserService {
    User get(Serializable id);

    User save(User user);

    User update(User user);

    void delete(Serializable id);

    List<User> list();

    User login(String email, String password);

    User findByEmail(String email);

}
