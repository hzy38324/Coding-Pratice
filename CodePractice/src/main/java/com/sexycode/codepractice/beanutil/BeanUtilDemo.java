package com.sexycode.codepractice.beanutil;

import com.sexycode.codepractice.beanutil.bean.Dog;
import com.sexycode.codepractice.beanutil.bean.DogV2;
import com.sexycode.codepractice.beanutil.bean.Zoo;
import com.sexycode.codepractice.beanutil.bean.ZooV2;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by hongzeyang
 * Time 2018/8/20 下午7:15
 * Desc
 */
public class BeanUtilDemo {

    @Test
    public void test_basic() throws InvocationTargetException, IllegalAccessException {
        Zoo zoo = new Zoo();
        zoo.setName("zoo");

        ZooV2 zooV2 = new ZooV2();

        BeanUtils.copyProperties(zoo,zooV2);

        System.out.println(zooV2.getName());
    }


    /**
     * 直接拷贝List时会丢失泛型，导致类型转换失败
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void test_copy_list_miss_generic() throws InvocationTargetException, IllegalAccessException {
        Dog dog = new Dog("bei");
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        Zoo zoo = new Zoo("zoo", dogs);

        ZooV2 zooV2 = new ZooV2();

        BeanUtils.copyProperties(zoo,zooV2);

        List<DogV2> dogV2s = zooV2.getDogs();

        System.out.println(dogV2s.size());

        // die!!! 这里dogV2s里面的dog是com.sexycode.codepractice.beanutil.bean.Dog 不是com.sexycode.codepractice.beanutil.bean.DogV2
        DogV2 dogV2 = dogV2s.get(0);

        System.out.println(dogV2.getName());
    }

}
