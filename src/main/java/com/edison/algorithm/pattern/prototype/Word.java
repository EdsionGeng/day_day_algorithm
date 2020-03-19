package com.edison.algorithm.pattern.prototype;

/**
 * @Description TODO
 * @Date 2020/3/12下午11:11
 * @Created by edsiongeng
 */
public class Word implements OfficialDocument{
    @Override
    public OfficialDocument clone() {
        OfficialDocument  far = null;

        try

        {

            far  = (OfficialDocument)super.clone();

        }

        catch(CloneNotSupportedException  e)

        {

            System.out.println("不支持复制！");

        }

        return  far;
    }

    @Override
    public void display() {
        System.out.println("可行性分析报告");

    }
}
