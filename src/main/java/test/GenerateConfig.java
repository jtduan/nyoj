package test;

import net.sf.json.JSONObject;

/**
 * @author jtduan
 * @date 2016/11/8
 */

public class GenerateConfig {
    private boolean ssq;
    private boolean dlt;
    private boolean pl;
    private boolean seven;
    private boolean sevenstar;
    private boolean welfare3d;

    public boolean isSsq() {
        return ssq;
    }

    public void setSsq(boolean ssq) {
        this.ssq = ssq;
    }

    public boolean getDlt() {
        return dlt;
    }

    public void setDlt(boolean dlt) {
        this.dlt = dlt;
    }

    public boolean isPl() {
        return pl;
    }

    public void setPl(boolean pl) {
        this.pl = pl;
    }

    public boolean isSeven() {
        return seven;
    }

    public void setSeven(boolean seven) {
        this.seven = seven;
    }

    public boolean isSevenstar() {
        return sevenstar;
    }

    public void setSevenstar(boolean sevenstar) {
        this.sevenstar = sevenstar;
    }

    public boolean isWelfare3d() {
        return welfare3d;
    }

    public void setWelfare3d(boolean welfare3d) {
        this.welfare3d = welfare3d;
    }

    public static void main(String[] args) {
        GenerateConfig p = new GenerateConfig();
        p.ssq=true;
        p.dlt=false;
        p.pl=false;
        p.seven=true;
        p.sevenstar=false;
        p.welfare3d=false;
        JSONObject pp = JSONObject.fromObject(p);
        System.out.println(pp);
    }
}