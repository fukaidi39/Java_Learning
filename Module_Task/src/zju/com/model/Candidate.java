package zju.com.model;

/**
 * @Autor:godfu
 * @Date:2021/11/30-10:09
 */
public class Candidate implements Comparable<Candidate> {
    private String cname;
    private long cid;
    private int ticket;

    public Candidate(String cname, long cid, int ticket) {
        this.cname = cname;
        this.ticket = ticket;
        this.cid = cid;
    }

    public String getCname() {
        return this.cname;
    }

    public long getCid() {
        return this.cid;
    }

    public int getTicket() {
        return this.ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return this.cid + ":" + this.cname + "【" + this.ticket + "票】";
    }

    @Override
    public int compareTo(Candidate can) {
        return can.ticket - this.ticket;//从高到低
    }
}
