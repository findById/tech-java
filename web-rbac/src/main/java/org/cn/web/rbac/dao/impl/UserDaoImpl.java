package org.cn.web.rbac.dao.impl;

import org.cn.web.core.database.JPAAccess;
import org.cn.web.rbac.dao.UserDao;
import org.cn.web.rbac.domain.User;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

    @Inject
    JPAAccess jpaAccess;

    @Override
    public List<User> getResultList(String sql, Map<String, Object> params, int offset, int size) {
        return jpaAccess.getResultList(sql, params, offset, size, User.class);
    }

    @Override
    public User get(Serializable id) {
        return jpaAccess.find(User.class, id);
    }

    @Override
    public Serializable save(User user) {
        jpaAccess.save(user);
        return user;
    }

    @Override
    public void update(User user) {
        jpaAccess.update(user);
    }

    @Override
    public void delete(Serializable id) {
        String sql = "DELETE FROM user WHERE id=:id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jpaAccess.update(sql, params);
    }

    @Override
    public List<User> list() {
        List<User> list = jpaAccess.getEntityManager().createNativeQuery("SELECT * FROM user", User.class).getResultList();
        return list;
    }
}
