package org.cn.web.rbac.dao.impl;

import org.cn.web.core.database.JPAAccess;
import org.cn.web.rbac.dao.RoleDao;
import org.cn.web.rbac.domain.Role;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Repository(value = "roleDao")
public class RoleDaoImpl implements RoleDao {

    @Inject
    JPAAccess jpaAccess;

    @Override
    public Role get(Serializable id) {
        return jpaAccess.find(Role.class, id);
    }

    @Override
    public Serializable save(Role role) {
        jpaAccess.save(role);
        return role;
    }

    @Override
    public void update(Role role) {
        jpaAccess.update(role);
    }

    @Override
    public void delete(Serializable id) {
        jpaAccess.delete(Role.class, id);
    }

    @Override
    public List<Role> list() {
        List<Role> list = jpaAccess.getEntityManager().createQuery("FROM " + Role.class.getName(), Role.class).getResultList();
        return list;
    }
}
