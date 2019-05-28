import java.util.Collections;

// Implementation of Disjoint Set Union (Union Find)

public class UnionFind {
	
	int[] parent;
	int[] rank;
	
	public UnionFind(int size) {
		this.parent = new int[size];
		this.rank = new int[size];
		for(int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}
	
	public int find(int a) {
		if(a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	public boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) {
			return false;
		}
		if(rank[a] > rank[b]) {
			parent[b] = a;
		}else {
			parent[a] = b;
			if(rank[a] == rank[b]) {
				rank[b]++;
			}
		}
		return true;
	}
}
