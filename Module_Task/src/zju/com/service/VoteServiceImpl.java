package zju.com.service;

import zju.com.model.Candidate;

import java.util.Arrays;

/**
 * @Autor:godfu
 * @Date:2021/11/30-10:17
 */
public class VoteServiceImpl implements IVoteService {
    private Candidate[] candidates = new Candidate[]{
            new Candidate("傅凯迪", 1, 0), new Candidate("郝文杰", 2, 0),
            new Candidate("刘云鹏", 3, 0), new Candidate("宋浩伟", 4, 0)
    };

    @Override
    public boolean voteInc(long cid) {
        for (int i = 0; i < candidates.length; i++) {
            if (cid == candidates[i].getCid()) {
                candidates[i].setTicket(candidates[i].getTicket() + 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public Candidate[] getData() {
        return this.candidates;
    }

    @Override
    public Candidate[] getResult() {
        Arrays.sort(candidates);
        return candidates;
    }
}
