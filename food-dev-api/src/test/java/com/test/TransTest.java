package com.test;

import com.yuancheng.Application;
import com.yuancheng.service.StuService;
import com.yuancheng.service.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private StuService stuService;

    @Autowired
    private TestTransService testTransService;

    //    @Test
    public void myTest() {
//        stuService.testPropagationTrans();
        testTransService.testPropagationTrans();
    }

}
