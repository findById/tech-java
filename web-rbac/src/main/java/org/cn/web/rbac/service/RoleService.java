package org.cn.web.rbac.service;

import org.cn.web.rbac.domain.Role;

import java.io.Serializable;
import java.util.List;

public interface RoleService {
    Role get(Serializable id);

    Role save(Role role);

    Role update(Role role);

    void delete(Serializable id);

    List<Role> list();
}
