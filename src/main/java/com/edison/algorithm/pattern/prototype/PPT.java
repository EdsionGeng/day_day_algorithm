package com.edison.algorithm.pattern.prototype;

/**
 * @Description TODO
 * @Date 2020/3/12下午11:13
 * @Created by edsiongeng
 */
public class PPT implements OfficialDocument {

    @Override
    public OfficialDocument clone() {
        OfficialDocument  srs = null;

        try

        {

            srs  = (OfficialDocument)super.clone();

        }

        catch(CloneNotSupportedException  e)

        {

            System.out.println("不支持复制！");

        }

        return  srs;
    }

    @Override
    public void display() {

    }
}
