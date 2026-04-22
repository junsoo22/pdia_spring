package com.example.demo.injection;

import org.junit.jupiter.api.Test;

class InjectionControllerTest {


    @Test
    public void printData() throws Exception{

        InjectionController ic=new InjectionController(new ChildBModel());
        ic.parentMoodel= new ChildBModel();
        ic.printData();
        }

}