package org.cn.web.rbac.dao;

import org.cn.web.rbac.domain.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getResultList(String sql, Map<String, Object> params, int offset, int size);

    User get(Serializable id);
    Serializable save(User user);
    void update(User user);
    void delete(Serializable id);

    List<User> list();
}
