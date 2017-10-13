package com.xiao.ex.common.thread;

import com.xiao.ex.common.SpringContextUtil;
import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.service.ExClientListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * @author 肖亭
 * @since 2017年09月15 16:29
 **/
@Component
public class ServiceExThread implements Runnable {
    private static Queue<ExceptionVo> queue = new LinkedList<ExceptionVo>();
    public static Logger log = Logger.getLogger(ServiceExThread.class.toString());
    private static ExClientListService service;

    public static void addExceptionVo(ExceptionVo vo) {
        if (vo != null) {
            queue.add(vo);
        }
    }

    @Override
    public void run() {
        while (true) {
            if (queue != null && queue.size() > 0) {
                for (int i = 0; i < queue.size(); i++) {
                    ExceptionVo poll = queue.poll();
                    try {
                        // ExClientListService service = SpringContextUtil.getBean(ExClientListService.class);
                        getService().addExClinet(poll);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private ExClientListService getService() {
        if (service == null) {
            service = SpringContextUtil.getBean("exClientListService");
        }
        return service;
    }


}
