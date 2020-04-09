package org.academiadecodigo.charliesangels.dao.jpa;

import org.academiadecodigo.charliesangels.dao.UserDao;
import org.academiadecodigo.charliesangels.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserJpaDao extends GenericJpaDao<User> implements UserDao {

    public UserJpaDao() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("username"), username));
        return em.createQuery(criteriaQuery).getSingleResult();
    }
}
