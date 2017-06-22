package org.cn.web.rbac.dao.impl;

import org.cn.web.core.database.JPAAccess;
import org.cn.web.rbac.dao.PermissionDao;
import org.cn.web.rbac.domain.Permission;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository(value = "permissionDao")
public class PermissionDaoImpl implements PermissionDao {

    @Inject
    JPAAccess jpaAccess;

    @Override
    public List<Permission> getResultList(String sql, Map<String, Object> params, int offset, int size) {
        return jpaAccess.getResultList(sql, params, offset, size, Permission.class);
    }

    @Override
    public Permission get(Serializable id) {
        return jpaAccess.find(Permission.class, id);
    }

    @Override
    public Serializable save(Permission permission) {
        jpaAccess.save(permission);
        return permission;
    }

    @Override
    public void update(Permission permission) {
        jpaAccess.update(permission);
    }

    @Override
    public void delete(Serializable id) {
        jpaAccess.delete(Permission.class, id);
    }

}
