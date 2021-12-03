package zju.reflection.autoset.model;

import java.util.Date;

/**
 * @Autor:godfu
 * @Date:2021/11/30-10:09
 */
public class Candidate {
    private long cid;
    private String cname;
    private int age;
    private Date birthdate;
    private String job;
    private Province pro;//级联属性

    public Candidate() {
    }

    public Candidate(long cid, String cname, int age, Date birthdate, String job) {
        this.cid = cid;
        this.cname = cname;
        this.age = age;
        this.birthdate = birthdate;
        this.job = job;
    }

    public long getCid() {
        return this.cid;
    }

    public String getCname() {
        return this.cname;
    }

    public int getAge() {
        return this.age;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public String getJob() {
        return this.job;
    }

    public Province getPro() {
        return this.pro;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setPro(Province pro) {
        this.pro = pro;
    }

    @Override
    public String toString() {
        return "[员工编号]:"+this.cid+"、[姓名]:"+this.cname+"、[年龄]"
                +this.age+"、[出生日期]"+this.birthdate+"、[职业]:"+this.job;
    }

}
