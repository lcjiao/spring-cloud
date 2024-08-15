package com.jcl.lambda;

import java.security.cert.PKIXRevocationChecker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMap {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<Person> plist = new ArrayList<Person>();
        plist.add(new Person("jcl",18));
        plist.add(new Person("jcl",19));
        plist.add(new Person("wlh",20));

        Map<String,Person> pmap = plist.stream().collect( Collectors.toMap(Person::getName, Function.identity(), (x, y)->x));

        pmap.forEach((x,y)->System.out.println(x+" "+y.getAge()));


        Person p = new Person("wx",20);
        p=null;
        Optional<Person> op = Optional.ofNullable(p);
        Person pp = op.orElse(p);
        pp = op.orElseGet(()->new Person("wx1",20));
        System.out.println(pp.getName());






    }
}
