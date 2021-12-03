package zju.reflection.autoset.model;

/**
 * @Autor:godfu
 * @Date:2021/12/3-14:06
 */
public class Province {
    private String pname;
    private Country country;

    public String getPname() {
        return this.pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
