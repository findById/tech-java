package org.cn.web.rbac.service.impl;

import org.cn.web.rbac.dao.RoleDao;
import org.cn.web.rbac.domain.Role;
import org.cn.web.rbac.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleDao roleDao;

    @Override
    public Role get(Serializable id) {
        return roleDao.get(id);
    }

    @Override
    @Transactional
    public Role save(Role role) {
        roleDao.save(role);
        return role;
    }

    @Override
    public Role update(Role role) {
        roleDao.update(role);
        return role;
    }

    @Override
    public void delete(Serializable id) {
        roleDao.delete(id);
    }

    @Override
    public List<Role> list() {
        return roleDao.list();
    }
}
