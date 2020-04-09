package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.models.Poll;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PollServiceImpl implements PollService {

    private Map<Integer, Poll> polls = new ConcurrentHashMap<>();
    private Integer counter = 0;

    public Map<Integer, Poll> getPolls() {
        return polls;
    }

    public void setPolls(Map<Integer, Poll> polls) {
        this.polls = polls;
    }

    @Override
    public Poll savePoll(Poll poll) {
        counter++;
        poll.setId(counter);
        return polls.put(poll.getId(), poll);
    }

    @Override
    public Poll getPoll(Integer id) {
        return polls.get(id);
    }

    @Override
    public void incrementYes(Integer id) {
        Poll poll = polls.get(id);
        poll.incrementYes();
    }

    @Override
    public void incrementNo(Integer id) {
        Poll poll = polls.get(id);
        poll.incrementNo();
    }
}
