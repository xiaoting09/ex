package com.xiao.ex.service.impl;

import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.service.ExClientListService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * ExClientListServiceImpl Tester.
 *
 * @author xiaoting
 * @version 1.0
 * @since <pre>ʮ�� 12, 2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExClientListServiceImplTest {
    @Autowired
    private ExClientListService exClientListService;

    @Test
    public void addEx() {
        ExceptionVo vo = new ExceptionVo();
        vo.setContentType("html");
        vo.setIp("134.25.36.01");
        vo.setType("post");
        vo.setException(new Exception("ddddd"));
        vo.setExTime(new Date());
        exClientListService.addExClinet(vo);
    }

} 
