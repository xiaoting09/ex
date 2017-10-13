package com.xiao.ex.common.thread;

import com.xiao.ex.common.SpringContextUtil;
import com.xiao.ex.core.ExceptionService;
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
    @Autowired
    private ExClientListService exClientListService;

    @PostConstruct
    public void init() {
        ServiceExThread thread = new ServiceExThread();
        new Thread(thread).start();
    }

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
                    exClientListService.addExClinet(poll);
                }
            }
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
