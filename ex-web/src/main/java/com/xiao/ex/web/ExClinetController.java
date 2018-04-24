package com.xiao.ex.web;

import com.xiao.ex.core.ExceptionService;
import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.web.vo.ExceptionWevVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public String refreshExList(ExceptionWevVo vo) {
        try {
            exceptionService.sendMsg(vo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

}
