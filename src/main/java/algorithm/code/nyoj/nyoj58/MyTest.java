package algorithm.code.nyoj.nyoj58;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by hero on 2016/5/25.
 */
public class MyTest extends TestCase {

    @Test
    public void testEquals(){
        Main main=new Main();
        Main2 main2 = new Main2();
        for(int bi=1;bi<=7;bi++){
            for(int bj=1;bj<=7;bj++){
                for(int ei=1;ei<=7;ei++){
                    for(int ej=1;ej<=7;ej++){
                        if(Main.maps[bi][bj]==1 || Main.maps[ei][ej]==1) continue;
                        assertEquals(bi+" "+bj+" "+ei+" "+ej,Main.soultion(bi,bj,ei,ej),Main2.soultion(bi,bj,ei,ej));
                    }
                }
            }
        }
    }
}
