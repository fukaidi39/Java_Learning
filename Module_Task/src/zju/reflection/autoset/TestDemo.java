package zju.reflection.autoset;

import zju.reflection.autoset.model.Candidate;
import zju.reflection.autoset.Factory.ClassInstanceFactory;

/**
 * @Autor:godfu
 * @Date:2021/11/30-11:23
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        String value = "cid:39|cname:fkd|age:22|birthdate:1999-01-28|job:CTO"+
                "|pro.pname:浙江省|pro.country.name:中国";
        Candidate can = ClassInstanceFactory.create(Candidate.class, value);
        System.out.println("[员工编号]:"+can.getCid()+"、[姓名]:"+can.getCname()+"、[年龄]:"
                +can.getAge()+"、[出生日期]:"+can.getBirthdate()+"、[职业]:"+can.getJob()+
                "、[省]:"+can.getPro().getPname()+"、[国家]:"+can.getPro().getCountry().getName());
    }
}

