package org.cn.web.rbac.dao;

import org.cn.web.rbac.domain.UserRole;

import java.io.Serializable;
import java.util.List;

public interface UserRoleDao {
    UserRole get(Serializable id);
    Serializable save(UserRole userRole);
    void update(UserRole userRole);
    void delete(Serializable id);

    List<UserRole> list();
}
