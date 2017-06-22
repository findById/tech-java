package org.cn.web.rbac.service.impl;

import org.cn.web.rbac.dao.UserDao;
import org.cn.web.rbac.domain.User;
import org.cn.web.rbac.service.UserService;
import org.cn.web.rbac.utils.AuthUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User get(Serializable id) {
        return userDao.get(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        userDao.save(user);
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        userDao.update(user);
        return user;
    }

    @Override
    @Transactional
    public void delete(Serializable id) {
        userDao.delete(id);
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public User login(String email, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", String.valueOf(email));
        List<User> list = userDao.getResultList("SELECT * FROM user WHERE username=:email OR email=:email OR mobile=:email", params, 0, 0);
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (User user : list) {
            if (AuthUtil.verify(user.getPassword(), user.getSalt(), password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", String.valueOf(email));
        List<User> list = userDao.getResultList("SELECT * FROM user WHERE email=:email", params, 0, 0);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
