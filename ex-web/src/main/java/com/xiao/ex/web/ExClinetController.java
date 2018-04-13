package com.xiao.ex.web;

import com.xiao.ex.core.ExceptionService;
import com.xiao.ex.core.vo.req.ExceptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;

/**
 * 客户端上报异常
 *
 * @author 肖亭
 * @since 2018年04月13 9:13
 **/
@RestController
@RequestMapping(value = "ex")
public class ExClinetController {
    @Autowired
    private ExceptionService exceptionService;

    @PostMapping(value = "refreshExList")
    public String refreshExList(@RequestBody ExceptionVo vo) {
        try {
            exceptionService.sendMsg(vo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

}
