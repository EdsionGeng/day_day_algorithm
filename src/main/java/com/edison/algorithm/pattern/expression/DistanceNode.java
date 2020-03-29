package com.edison.algorithm.pattern.expression;

/**
 * @Description TODO
 * @Date 2020/3/29下午4:08
 * @Created by edsiongeng
 */
public class DistanceNode extends AbstractNode {
    private String distance;


    public DistanceNode(String distance) {
        this.distance = distance;
    }


    @Override
    public String interpret() {
        return this.distance;
    }
}
