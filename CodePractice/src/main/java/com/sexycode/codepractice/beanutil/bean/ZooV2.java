package com.sexycode.codepractice.beanutil.bean;

import java.util.List;


/**
 * Created by hongzeyang
 * Time 2018/8/20 下午7:19
 * Desc
 */
public class ZooV2 {

    public ZooV2() {
    }


    public ZooV2(String name, List<DogV2> dogs) {
        this.name = name;
        this.dogs = dogs;
    }


    private String name;

    private List<DogV2> dogs;


    private ZooConf zooConf;


    public ZooConf getZooConf() {
        return zooConf;
    }


    public void setZooConf(ZooConf zooConf) {
        this.zooConf = zooConf;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public List<DogV2> getDogs() {
        return dogs;
    }


    public void setDogs(List<DogV2> dogs) {
        this.dogs = dogs;
    }
}
