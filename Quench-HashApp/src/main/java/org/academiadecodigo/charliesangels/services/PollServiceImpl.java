package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.dao.PollDao;
import org.academiadecodigo.charliesangels.models.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PollServiceImpl implements PollService {

    private PollDao pollDao;

    @Autowired
    public void setPollDao(PollDao pollDao) {
        this.pollDao = pollDao;
    }

    @Transactional
    @Override
    public Poll savePoll(Poll poll) {
        return pollDao.saveOrUpdate(poll);
    }

    @Override
    public Poll getPoll(Integer id) {
        return pollDao.findById(id);
    }

    @Transactional
    @Override
    public void incrementYes(Integer id) {
        Poll poll = pollDao.findById(id);
        poll.incrementYes();
        pollDao.saveOrUpdate(poll);
    }

    @Transactional
    @Override
    public void incrementNo(Integer id) {
        Poll poll = pollDao.findById(id);
        poll.incrementNo();
        pollDao.saveOrUpdate(poll);
    }
}
