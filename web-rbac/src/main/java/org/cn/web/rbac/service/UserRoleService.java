package org.cn.web.rbac.service;

import org.cn.web.rbac.domain.UserRole;

import java.io.Serializable;
import java.util.List;

public interface UserRoleService {
    UserRole get(Serializable id);

    UserRole save(UserRole userRole);

    UserRole update(UserRole userRole);

    void delete(Serializable id);

    List<UserRole> list();
}
