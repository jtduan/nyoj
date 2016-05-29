package algorithm.code.nyoj.nyoj183;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jtduan
 * SFPA最长路径算法
 * 邻接矩阵存储
 */
public class Main {
	public static int n;
	public static int[] lowcost;

	public static Node[] nodes;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = null;
//		cin = new Scanner(new FileInputStream("src/main/resources/nyoj183.txt"), "utf8");
        cin= new Scanner(System.in);
		int N = cin.nextInt();
		for (int i = 0; i < N; i++) {
			everyTest(cin);
		}
	}

	private static void everyTest(Scanner cin) {
		int N = cin.nextInt();
		int M = cin.nextInt();
		n = N;
		lowcost = new int[n];
		nodes = new Node[n];
		for(int i=0;i<M;i++){
			int a = cin.nextInt();
			int b = cin.nextInt();
			int c = cin.nextInt();
			Node node = new Node(b,cin.nextInt()-c);
			node.next=nodes[a];
			nodes[a]=node;

			node = new Node(a,cin.nextInt()-c);
			node.next=nodes[b];
			nodes[b]=node;
		}
		solution();
	}

	private static void solution() {
		int res = SFPA(0);
		if(res== Integer.MAX_VALUE){
			System.out.println("$$$");
		}
		else{
			System.out.println(res);
		}
	}
	public static int SFPA(int start) {//假设从0开始遍历
		Arrays.fill(lowcost, Integer.MIN_VALUE);
		int[] queue = new int[n];
		int q;
		queue[start] = 1;
		lowcost[start] = 0;
		while (true) {
			q = 0;
			while (q < n && queue[q] <= 0) {
				q++;
			}
			if (q == n) break;
			Node temp = nodes[q];
			while(temp!=null){
				int next_city = temp.city;
				if (temp.val + lowcost[q] > lowcost[next_city]) {
					lowcost[next_city] = temp.val + lowcost[q];
					if(queue[next_city]<=0){
						queue[next_city] = -queue[next_city]+1; //入队
						if(queue[next_city]>n) return Integer.MAX_VALUE;
					}
				}
				temp=temp.next;
			}
			queue[q] = -queue[q]; //出队
		}
		return lowcost[n-1];
	}
}
class Node{
	int city;
	int val;
	Node next;

	public Node(int city, int val) {
		this.city = city;
		this.val = val;
		next = null;
	}
}