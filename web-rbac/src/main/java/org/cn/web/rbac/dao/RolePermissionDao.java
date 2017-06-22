package org.cn.web.rbac.dao;

import org.cn.web.rbac.domain.RolePermission;

import java.io.Serializable;
import java.util.List;

public interface RolePermissionDao {
    RolePermission get(Serializable id);
    Serializable save(RolePermission rolePermission);
    void update(RolePermission rolePermission);
    void delete(Serializable id);

    List<RolePermission> list();
}
