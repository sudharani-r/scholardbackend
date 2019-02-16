package com.elearning.controller;

 
import java.util.function.Supplier;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.model.ResponseObject;
import com.elearning.repository.ApplicationRepositoryUtil;
 
@RestController
@RequestMapping(value = "/app")
public class ApplicationController {
 
    @Autowired
    ApplicationRepositoryUtil applicationRepositoryUtil;
 
    @RequestMapping("/test")
    public ResponseObject handleRequest() {
    	System.out.println("working");
        System.out
                .println("---------------------Testing method called---------------- Mongo Template :"
                        + applicationRepositoryUtil.getMongoTemplate()
                        + " Repository Object : "
                        + applicationRepositoryUtil.getUserRepository().count());
        Supplier<ResponseObject> supplier = ResponseObject::new;
        ResponseObject responseObject = supplier.get();
        responseObject.setMessage("Sample Data Object");
        return responseObject;
    }
}