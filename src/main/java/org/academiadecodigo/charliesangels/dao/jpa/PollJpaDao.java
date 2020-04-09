package org.academiadecodigo.charliesangels.dao.jpa;

import org.academiadecodigo.charliesangels.dao.PollDao;
import org.academiadecodigo.charliesangels.models.Poll;
import org.springframework.stereotype.Repository;

@Repository
public class PollJpaDao extends GenericJpaDao<Poll> implements PollDao {

    public PollJpaDao() {
        super(Poll.class);
    }
}
