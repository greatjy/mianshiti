package com.baidu.newcoder.gaopin.char2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MinTime {
	static class Vertex {

		public List<Vertex> adj; //邻接矩阵
		public int dist; //最短距离
		public Vertex path; //最短路径上一节点
		public boolean known;//是否被访问过
		public int id;
		public Vertex() {
			this(new ArrayList<Vertex>(), Integer.MAX_VALUE, null, false, 0);
		}
		public Vertex(List<Vertex> adj, int dist, Vertex path, boolean known, int id) {
			this.adj = adj;
			this.dist = dist;
			this.path = path;
			this.known = known;
			this.id = id;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Vertex[] nodes = new Vertex[n];
		for(int i=0; i<nodes.length; i++) {
			nodes[i] = new Vertex();
			nodes[i].id = i+1;
		}
		for(int j=0; j<n-1; j++) {
			int front = in.nextInt()-1;
			int back = in.nextInt()-1;
			nodes[front].adj.add(nodes[back]);
			nodes[back].adj.add(nodes[front]);
		}
		int count = 0;
		List<Vertex> next = new ArrayList<>();
		int max = 0;
		while(count<n-1) {
			//初级感染
			if(count==0) {
				List<Vertex> adj = nodes[0].adj;
				nodes[0].known = true;
				for(int i=0; i<adj.size(); i++) {
					adj.get(i).known = true;
					count++;
					adj.get(i).dist = 1;
					next.add(adj.get(i));
				}
				if(count==n-1) {
					max = 1;
				}
			}else {
				//二级感染
				List<Vertex> tmp = new ArrayList<>();
				for(Vertex vertex:next) {
					int sonSum = spreadSon(vertex, tmp);
					count += sonSum;
				}
				next = tmp;
				if(count==n-1) {
					max = next.get(0).dist;
				}
			}
		}
		System.out.println(max);
	}

	private static int spreadSon(Vertex vertex, List<Vertex> tmp) {
		List<Vertex> temp = vertex.adj;//邻接结点
		int ans = 0;
		int last = vertex.dist;
		for(Vertex son:temp) {
			if(!son.known) {
				ans++;
			}
		}
		for(Vertex son:temp) {
			if(!son.known) {
				son.known = true;
				son.dist = last + ans;
				tmp.add(son);
			}
		}
		return ans;
	}
}