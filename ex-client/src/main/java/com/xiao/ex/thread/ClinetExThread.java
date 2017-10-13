package com.xiao.ex.thread;

import com.xiao.ex.core.ExceptionService;
import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.core.vo.resp.Result;
import com.xiao.ex.rpc.RegistryService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * @author 肖亭
 * @since 2017年09月15 16:29
 **/
public class ClinetExThread implements Runnable {
    private static Queue<ExceptionVo> queue = new LinkedList<ExceptionVo>();
    /**
     * 默认十分钟上报一次
     */
    private Long time;
    public static Logger log = Logger.getLogger(ClinetExThread.class.toString());

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
                    sendServiceMsg(poll);
                }
            }
            try {
                Thread.sleep(getTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 上报到服务端
     *
     * @param vo
     */
    private void sendServiceMsg(ExceptionVo vo) {
        try {
            ExceptionService server = (ExceptionService) RegistryService.getRegistry().lookup("exService");
            Result result = server.sendMsg(vo);
            log.info("____异常上传结果:" + result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long getTime() {
        return time == null ? 600000L : this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
