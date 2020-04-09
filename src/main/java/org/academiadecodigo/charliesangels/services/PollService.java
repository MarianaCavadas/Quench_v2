package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.models.Poll;

public interface PollService {

    Poll savePoll(Poll poll);

    Poll getPoll(Integer id);

    void incrementYes(Integer id);

    void incrementNo(Integer id);

}
