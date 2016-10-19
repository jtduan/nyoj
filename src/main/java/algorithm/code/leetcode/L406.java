package algorithm.code.leetcode;

/**
 * 重排序
 */
public class L406 {
    public int[][] reconstructQueue(int[][] people) {
        sort(people);
        for(int i=1;i<people.length;i++){
            if(people[i][1]<i){
                push(people,people[i][1],i);
            }
        }
        return people;
    }

    private void push(int[][] people, int begin,int end) {
        int[] temp = people[end];
        for(int i=end;i>begin;i--){
            people[i]=people[i-1];
        }
        people[begin]=temp;
    }

    private void sort(int[][] people) {
        for(int i=0;i<people.length;i++){
            for(int j=i;j<people.length;j++){
                if(people[i][0]<people[j][0] ||(people[i][0]==people[j][0] && people[i][1]>people[j][1])){
                    int temp = people[i][0];
                    people[i][0]=people[j][0];
                    people[j][0]=temp;

                    temp = people[i][1];
                    people[i][1]=people[j][1];
                    people[j][1]=temp;
                }
            }
        }
    }
}
