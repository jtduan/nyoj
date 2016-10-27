package algorithm.code.codewars;

/**
 * @author jtduan
 * @date 2016/10/25
 */
public class ShortestPath {
    public static String[] directions(String[] goal) {
        int[] dirs = new int[4];
        for (int i = 0; i < goal.length; i++) {
            if (goal[i] == "N") {
                if (dirs[1] > 0) {
                    dirs[1]--;
                } else
                    dirs[0]++;
            }
            if (goal[i] == "S") {
                if(dirs[0] > 0){
                    dirs[0]--;
                }else{
                    dirs[1]++;
                }
            }
            if (goal[i] == "E"){
                if(dirs[3] > 0){
                    dirs[3]--;
                }
                else{
                    dirs[2]++;
                }
            }
            if (goal[i] == "W"){
                if(dirs[2] > 0){
                    dirs[2]--;
                }else{
                    dirs[3]++;
                }
            }
        }
        if(dirs[0] + dirs[1] + dirs[2] + dirs[3]==0){
            return new String[]{""};
        }
        String[] res = new String[dirs[0] + dirs[1] + dirs[2] + dirs[3]];
        int i = 0;
        for (int j = 0; j < dirs[0]; j++, i++) res[i] = "N";
        for (int j = 0; j < dirs[1]; j++, i++) res[i] = "S";
        for (int j = 0; j < dirs[2]; j++, i++) res[i] = "E";
        for (int j = 0; j < dirs[3]; j++, i++) res[i] = "W";
        return res;
    }
}
