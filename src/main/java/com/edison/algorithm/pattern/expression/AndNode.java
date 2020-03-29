package com.edison.algorithm.pattern.expression;

/**
 * @Description TODO
 * @Date 2020/3/29下午4:01
 * @Created by edsiongeng
 */
public class AndNode extends AbstractNode {
    private AbstractNode left;
    private AbstractNode right;

    public AndNode(AbstractNode left, AbstractNode right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public String interpret() {
        return left.interpret() + "再" + right.interpret();
    }
}
