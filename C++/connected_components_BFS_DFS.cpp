#include <iostream>
#include <bits/stdc++.h>
using namespace std;

template <typename T>
class Graph {
	map<T, list<T>> m;
public:
	void addEdge(T x, T y) {
		m[x].push_back(y);
		m[y].push_back(x);
	}
	void dfs_helper(T src, map<T, bool> &visited) {
		cout << src << ",";
		visited[src] = true;
		for (auto neigh : m[src]) {
			if (!visited[neigh]) {
				dfs_helper(neigh, visited);
			}
		}
	}
	void dfs() {
		map<T, bool> visited;
		// Mark all the nodes in graph as unvisited i.e false
		for (auto p : m) {
			T node = p.first;
			visited[node] = false;
		}

		// For counting the components
		int count = 0;
		// Make a dfs for every node if it is not visited
		for (auto p : m) {
			T node = p.first;
			if (!visited[node]) {
				count += 1;
				cout << "Component " << count << "--->";
				dfs_helper(node, visited);
				cout << endl;
			}
		}
	}
};
int main() {
// 	init();
	Graph<int> g;
	g.addEdge(0, 1);
	g.addEdge(0, 3);
	g.addEdge(0, 4);
	g.addEdge(1, 2);
	g.addEdge(2, 3);
	g.addEdge(5, 6);
	g.addEdge(6, 7);
	g.addEdge(8, 8);
	g.dfs();
	return 0;
}
