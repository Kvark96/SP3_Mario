package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> soldPizzas = new HashMap<>();
        addPizza(soldPizzas, "pepperoni");
        addPizza(soldPizzas, "hawaii");
        addPizza(soldPizzas, "pepperoni");
        System.out.println(soldPizzas);
    }

    /*
    * map <type, type>
    * {key, value}
    * map.get(key) -> value
    * map.put(key,value) -> {key, value}
    * */

    static void addPizza(Map<String,Integer> map, String pizza){
        if(map.containsKey(pizza)){
            map.put(pizza, map.get(pizza) + 1);
        } else {
            map.put(pizza, 1);
        }
    }
}