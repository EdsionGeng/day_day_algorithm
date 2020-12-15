package com.edison.algorithm.pattern.flyweight;


import java.util.Hashtable;

/**
 * @Description TODO
 * @Date 2020/3/21上午11:58
 * @author by edsiongeng
 */
public class IgoChessmanFactory {

    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Hashtable ht;

    private IgoChessmanFactory() {
        ht = new Hashtable();
        IgoChessman black, white;
        black = new BlackIgoChessman();
        ht.put("b", black);
        white = new WhiteIgoChessman();
        ht.put("w", white);

    }

    public static IgoChessmanFactory getInstance() {
        return instance;
    }

    public static IgoChessman getIgoChessman(String color){
        return (IgoChessman) ht.get(color);
    }

}
