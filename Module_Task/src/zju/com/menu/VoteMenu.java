package zju.com.menu;

import zju.com.Factory.Factory;
import zju.com.service.IVoteService;
import zju.com.util.InputUtil;

import java.util.Arrays;

/**
 * @Autor:godfu
 * @Date:2021/11/30-10:10
 */
public class VoteMenu {
    private IVoteService ivs;
    public VoteMenu(){
        ivs = Factory.getInstance("VoteServiceImpl",IVoteService.class);//初始化投票服务
        System.out.println(Arrays.toString(ivs.getData()));//显示候选人面板
        this.menuShow();
    }
    public void menuShow(){
        String vote = InputUtil.getString("请输入班长候选人代号(数字0退出):");
        if(!vote.matches("[0-4]")){//投票无效
            System.out.println("次选票无效，请重新输入正确的候选人编号！");
            this.menuShow();//重新获取输入
        }else if (ivs.voteInc(Long.parseLong(vote))){//投票有效
            this.menuShow();
        }else{
            System.out.println(Arrays.toString(ivs.getResult()));
            System.out.println("投票最终结果:" + ivs.getResult()[0].getCname() + "同学,最后以" +ivs.getResult()[0].getTicket()+ "票当选班长");
        }
    }
}
