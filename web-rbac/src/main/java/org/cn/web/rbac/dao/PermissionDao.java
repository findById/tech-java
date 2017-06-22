package org.cn.web.rbac.dao;

import org.cn.web.rbac.domain.Permission;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface PermissionDao {
    List<Permission> getResultList(String sql, Map<String, Object> params, int offset, int size);

    Permission get(Serializable id);
    Serializable save(Permission permission);
    void update(Permission permission);
    void delete(Serializable id);

}
