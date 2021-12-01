package zju.com.service;

import zju.com.model.Candidate;

/**
 * @Autor:godfu
 * @Date:2021/11/30-10:11
 */
public interface IVoteService {
    /**
     * 判断选择编号，并增长票数
     * @param cid 投票的编号
     * @return
     */
    public boolean voteInc(long cid);

    /**
     * 返回全部的候选人信息
     * @return
     */
    public Candidate[] getData();

    /**
     * 返回最终的投票结果
     * @return
     */
    public Candidate[] getResult();
}
