package com.edison.algorithm.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description Floyd洛依德算法
 * @Date 2020/7/22下午11:33
 * @Created by edsiongeng
 */
public class Floyd<T> {


    /**
     * 使用Floyd（弗洛伊德）算法，返回所有节点间的最短距离<br>
     * 设置两个map<br>
     * 第一个 result，key为出发点，value是map，这个map的key是结束点，value是出发点到结束点的最短距离<br>
     * 第二个 path，key为出发点，value是map，这个map的key是结束点，value是出发点到结束点的最短距离的路径的最后的中转节点<br>
     * 一开始，result里的value为maxDouble(到自己的value为0），path里的value是结束点<br>
     * 然后，用图里的所有的边对result做初始化，当不经过任意第三节点时，其最短路径为初始路径，只对图里先有的只经过两点的边，对result里的value更新<br>
     * <br>
     * 进行循环
     * 当只允许经过1号节点时，求两点之间的最短路径该如何求呢？只需判断i到1号的min距离 + 1号到j的min距离是否比i到j的min距离要小即可。
     * 如果i到1号的min距离 + 1号到j的min距离 小于 i到j的min距离，说明经过1号的路径更好，
     * 让i到j的min距离=i到1号的min距离 + 1号到j的min距离，并且i到j的最后的中转节点为1号节点
     * 比如说a到b到c到d，a到c的中转为b，a到d的中转为c（根据c得到a到c的中转为b，a到b的中转为b，就可以得到a到b到c到d）
     * 循环遍历result，便可以获取在仅仅经过1号节点时的最短距离和中转节点。
     * 由于此时result的结果已经保存了中转1号节点的最短路径，此时如果继续并入2号节点为中转节点
     * 则是任意两个节点都经过中转节点1号节点和2号节点的最短路径，把所有节点作为中转节点后，得到的是所有节点间的最短距离
     *
     * @return
     */
    public Map<Vertex<T>, HashMap<Vertex<T>, Double>> getSmallestDistanceFloyd() {
        //第一个 result，key为出发点，value是map，这个map的key是结束点，value是出发点到结束点的最短距离
        Map<Vertex<T>, HashMap<Vertex<T>, Double>> result = new HashMap<>();
        //第二个 path，key为出发点，value是map，这个map的key是结束点，value是出发点到结束点的最短距离的路径的最后的中转节点
        Map<Vertex<T>, HashMap<Vertex<T>, Vertex<T>>> path = new HashMap<>();
        Set<Vertex<T>> vertexSet = null; //getVertexSet();
        Vertex vertex;
        Edge edge;

        for (Vertex<T> begin : vertexSet) {
            HashMap<Vertex<T>, Double> distanceMap = new HashMap<>();
            HashMap<Vertex<T>, Vertex<T>> pathMap = new HashMap<>();
            for (Vertex<T> end : vertexSet) {
                //一开始，result里的value为maxDouble(到自己的value为0），path里的value是结束点
                distanceMap.put(end, Double.MAX_VALUE);
                pathMap.put(end, end);
            }
            //result里的value为maxDouble(到自己的value为0），path里的value是结束点
            distanceMap.put(begin, 0.0);
            result.put(begin, distanceMap);
            path.put(begin, pathMap);
        }

        for (Vertex<T> begin : vertexSet) {
            HashMap<Vertex<T>, Double> distanceMap = result.get(begin);
            Iterator<Edge> edgeIterator = begin.getEdgeIterator();
            while (edgeIterator.hasNext()) {
                edge = edgeIterator.next();
                //用图里的所有的边对result做初始化，当不经过任意第三节点时，其最短路径为初始路径，只对图里先有的只经过两点的边，对result里的value更新
                distanceMap.put(edge.getEndVertex(), edge.getWeight());
            }
            result.put(begin, distanceMap);
        }

        for (Vertex<T> mid : vertexSet) {
            for (Vertex<T> begin : vertexSet) {
                HashMap<Vertex<T>, Double> distanceMap = result.get(begin);
                HashMap<Vertex<T>, Vertex<T>> pathMap = path.get(begin);
                for (Vertex<T> end : vertexSet) {
                    Double beginEnd = distanceMap.get(end);
                    Double beginMid = distanceMap.get(mid);
                    Double midEnd = result.get(mid).get(end);
                    if (beginMid == Double.MAX_VALUE || midEnd == Double.MAX_VALUE || beginMid + midEnd > beginEnd) {
                        //如果通过中转点不行，或者通过中转点的距离大于原先距离，就不考虑这个中转点
                        continue;
                    }
                    //让i到j的min距离=i到1号的min距离 + 1号到j的min距离，并且i到j的最后的中转节点为1号节点
                    distanceMap.put(end, beginMid + midEnd);
                    pathMap.put(end, mid);
                }
                result.put(begin, distanceMap);
                path.put(begin, pathMap);
            }
        }

        for (Vertex<T> begin : vertexSet) {
            HashMap<Vertex<T>, Double> distanceMap = result.get(begin);
            HashMap<Vertex<T>, Vertex<T>> pathMap = path.get(begin);
            for (Vertex<T> end : vertexSet) {
                System.out.println("从顶点:" + begin.getLabel() + " ，到顶点：" + end.getLabel() +
                        " ，最短距离为：" + distanceMap.get(end) + " ，最后中转点为:" + pathMap.get(end).getLabel());
            }
        }

        return result;
    }


}
