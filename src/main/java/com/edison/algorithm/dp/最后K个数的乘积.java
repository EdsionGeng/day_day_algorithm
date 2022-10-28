package com.edison.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class 最后K个数的乘积 {

    class ProductOfNumbers {
        List<Integer> prod;

        public ProductOfNumbers() {
            prod = new ArrayList<>();
            prod.add(1);

        }

        public void add(int num) {
            if (num == 0) {
                prod.clear();
                prod.add(1);
            } else {
                prod.add(num * prod.get(prod.size() - 1));
            }
        }

        public int getProduct(int k) {
            int size = prod.size();
            if (k >= size) return 0;
            return prod.get(size - 1) / prod.get(size - 1 - k);
        }
    }
}
