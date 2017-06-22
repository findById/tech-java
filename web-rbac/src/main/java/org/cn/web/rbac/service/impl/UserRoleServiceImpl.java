package org.cn.web.rbac.service.impl;

import org.cn.web.rbac.dao.UserRoleDao;
import org.cn.web.rbac.service.UserRoleService;
import org.cn.web.rbac.domain.UserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service(value = "userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    UserRoleDao userRoleDao;

    @Override
    public UserRole get(Serializable id) {
        return userRoleDao.get(id);
    }

    @Override
    @Transactional
    public UserRole save(UserRole userRole) {
        userRoleDao.save(userRole);
        return userRole;
    }

    @Override
    public UserRole update(UserRole userRole) {
        userRoleDao.update(userRole);
        return userRole;
    }

    @Override
    public void delete(Serializable id) {
        userRoleDao.delete(id);
    }

    @Override
    public List<UserRole> list() {
        return userRoleDao.list();
    }

}
