package com.example.demo.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectionController {

    public ChildBModel parentMoodel;
    private  ParentModel parentModel;

    @Autowired
    InjectionController(ParentModel parentModel, ChildAModel childAModel, ChildBModel childBModel){
        System.out.println("Injection Controller");
        this.parentModel=parentModel;
    }

    public InjectionController(ChildBModel childBModel) {

    }

    public void printData(){
        InjectionController ic=new InjectionController(new ChildBModel());
        System.out.println(parentModel.getData());
    }
//
//    public void setParentModel(ParentModel parentModel){
//        this.parentModel=parentModel;
//    }

}