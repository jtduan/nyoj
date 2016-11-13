package algorithm.code.newcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by djt on 11/12/16.
 */
public class XiaoMiGit {
	public int getSplitNode(String[] matrix, int indexA, int indexB) {
		char[][] map = new char[matrix.length][matrix[0].length()];
		for(int i=0;i<map.length;i++){
			map[i]=matrix[i].toCharArray();
		}
		boolean[] visited = new boolean[map.length];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(indexA);
		int cur=0;
		int len=1;
		visited[indexA]=true;
		while(!queue.isEmpty()){
			for(int i=0;i<len;i++){
				int p = queue.poll();
				for(int j=0;j<map.length;j++){
					if(visited[j])continue;
					if(map[p][j]=='1'){
						if(j==indexB) return cur+1;
						else{
							visited[j]=true;
							queue.add(j);
						}
					}
				}
			}
			cur++;
			len=queue.size();
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new XiaoMiGit().getSplitNode(new String[]{"01011","10100","01000","10000","10000"},1,2));
	}
}
