package com.edison.algorithm.struct.graph;

/**
 * @Description TODO
 * @Date 2020/7/21下午11:47
 * @Created by edsiongeng
 */
public class Edge {

    private Vertex beginVertex;

    private Vertex endVertex;


    private double weight;

    public Edge(Vertex beginVertex, Vertex endVertex, double weight) {
        this.beginVertex = beginVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public Vertex getBeginVertex() {
        return beginVertex;
    }

    public void setBeginVertex(Vertex beginVertex) {
        this.beginVertex = beginVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
