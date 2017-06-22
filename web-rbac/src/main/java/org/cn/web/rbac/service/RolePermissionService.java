package org.cn.web.rbac.service;

import org.cn.web.rbac.domain.RolePermission;

import java.io.Serializable;
import java.util.List;

public interface RolePermissionService {
    RolePermission get(Serializable id);

    RolePermission save(RolePermission rolePermission);

    RolePermission update(RolePermission rolePermission);

    void delete(Serializable id);

    List<RolePermission> list();
}
