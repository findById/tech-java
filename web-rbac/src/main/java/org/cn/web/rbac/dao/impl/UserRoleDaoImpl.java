package org.cn.web.rbac.dao.impl;

import org.cn.web.core.database.JPAAccess;
import org.cn.web.rbac.dao.UserRoleDao;
import org.cn.web.rbac.domain.UserRole;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Repository(value = "userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {

    @Inject
    JPAAccess jpaAccess;

    @Override
    public UserRole get(Serializable id) {
        return jpaAccess.find(UserRole.class, id);
    }

    @Override
    public Serializable save(UserRole userRole) {
        jpaAccess.save(userRole);
        return userRole;
    }

    @Override
    public void update(UserRole userRole) {
        jpaAccess.update(userRole);
    }

    @Override
    public void delete(Serializable id) {
        jpaAccess.delete(UserRole.class, id);
    }

    @Override
    public List<UserRole> list() {
        List<UserRole> list = jpaAccess.getEntityManager().createQuery("FROM " + UserRole.class.getName(), UserRole.class).getResultList();
        return list;
    }
}
