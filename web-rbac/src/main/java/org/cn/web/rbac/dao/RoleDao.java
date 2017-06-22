package org.cn.web.rbac.dao;

import org.cn.web.rbac.domain.Role;

import java.io.Serializable;
import java.util.List;

public interface RoleDao {
    Role get(Serializable id);
    Serializable save(Role role);
    void update(Role role);
    void delete(Serializable id);

    List<Role> list();
}
