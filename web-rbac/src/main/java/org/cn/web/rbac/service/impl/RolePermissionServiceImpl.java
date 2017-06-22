package org.cn.web.rbac.service.impl;

import org.cn.web.rbac.dao.RolePermissionDao;
import org.cn.web.rbac.domain.RolePermission;
import org.cn.web.rbac.service.RolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service(value = "rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

    @Resource
    RolePermissionDao rolePermissionDao;

    @Override
    public RolePermission get(Serializable id) {
        return rolePermissionDao.get(id);
    }

    @Override
    @Transactional
    public RolePermission save(RolePermission rolePermission) {
        rolePermissionDao.save(rolePermission);
        return rolePermission;
    }

    @Override
    public RolePermission update(RolePermission rolePermission) {
        rolePermissionDao.update(rolePermission);
        return rolePermission;
    }

    @Override
    public void delete(Serializable id) {
        rolePermissionDao.delete(id);
    }

    @Override
    public List<RolePermission> list() {
        return rolePermissionDao.list();
    }

}
