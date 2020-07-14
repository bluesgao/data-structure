package com.bluesgao.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphDemo {
    private static class Vertex {
        int data;

        public Vertex(int data) {
            this.data = data;
        }
    }

    //邻接链表法
    //在邻接链表中，图的每一个顶点都是一个链表的头节点，其后连接着该顶点能够直接达到的相邻顶点。
    private static class Graph {
        private int size;
        private Vertex[] vertices;//顶点
        private LinkedList<Integer> adj[];//邻接链表

        Graph(int size) {
            this.size = size;
            this.adj = new LinkedList[size];
            this.vertices = new Vertex[size];
            //初始化邻接表
            for (int i = 0; i < size; i++) {
                vertices[i] = new Vertex(i);
                adj[i] = new LinkedList<Integer>();
            }
        }
    }

    //深度优先
    public static void dfs(Graph graph, int start, boolean[] visited) {
        System.out.println(graph.vertices[start].data);
        visited[start] = true;
        for (int index : graph.adj[start]) {
            if (!visited[index]) {
                dfs(graph, index, visited);
            }
        }
    }

    //广度优先
    public static void bfs(Graph graph, int start, boolean[] visited, Queue<Integer> queue) {
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur]) {
                continue;
            }
            System.out.println(graph.vertices[cur].data);
            visited[cur] = true;
            for (int i : graph.adj[cur]) {
                queue.add(i);
            }
        }
    }

    public static void main(String[] args) {
        /*
         *                   2
         *                   |
         *         1 <------ 0 ---- 3
         *
         *             4          5
         *
         *
         * */
        Graph graph = new Graph(6);
        graph.adj[0].add(1);
        graph.adj[0].add(2);
        graph.adj[0].add(3);

        graph.adj[1].add(0);
        graph.adj[1].add(3);
        graph.adj[1].add(4);

        graph.adj[2].add(0);

        graph.adj[3].add(0);
        graph.adj[3].add(1);
        graph.adj[3].add(4);
        graph.adj[3].add(5);

        graph.adj[4].add(1);
        graph.adj[4].add(3);
        graph.adj[4].add(5);

        graph.adj[5].add(3);
        graph.adj[5].add(4);


        System.out.println("图的深度优先遍历：");
        dfs(graph, 0, new boolean[graph.size]);

        System.out.println("图的广度优先遍历：");
        bfs(graph, 0, new boolean[graph.size], new LinkedList<Integer>());
    }
}
