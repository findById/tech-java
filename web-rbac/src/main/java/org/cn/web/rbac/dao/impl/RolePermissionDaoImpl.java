package org.cn.web.rbac.dao.impl;

import org.cn.web.core.database.JPAAccess;
import org.cn.web.rbac.dao.RolePermissionDao;
import org.cn.web.rbac.domain.RolePermission;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Repository(value = "rolePermissionDao")
public class RolePermissionDaoImpl implements RolePermissionDao {

    @Inject
    JPAAccess jpaAccess;

    @Override
    public RolePermission get(Serializable id) {
        return jpaAccess.find(RolePermission.class, id);
    }

    @Override
    public Serializable save(RolePermission rolePermission) {
        jpaAccess.save(rolePermission);
        return rolePermission;
    }

    @Override
    public void update(RolePermission rolePermission) {
        jpaAccess.update(rolePermission);
    }

    @Override
    public void delete(Serializable id) {
        jpaAccess.delete(RolePermission.class, id);
    }

    @Override
    public List<RolePermission> list() {
        List<RolePermission> list = jpaAccess.getEntityManager().createQuery("FROM " + RolePermission.class.getName(), RolePermission.class).getResultList();
        return list;
    }
}
