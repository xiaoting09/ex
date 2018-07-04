package com.xiao.ex.thread;

import com.xiao.ex.core.ExceptionService;
import com.xiao.ex.core.vo.req.ExceptionVo;
import com.xiao.ex.core.vo.resp.Result;
import com.xiao.ex.rpc.RegistryService;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 肖亭
 * @since 2017年09月15 16:29
 **/
public class ClientExThread implements Runnable {
    public static Logger log = Logger.getLogger(ClientExThread.class.toString());
    private static Queue<ExceptionVo> queue = new LinkedList<ExceptionVo>();
    private static ClientExThread instance;
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    private ClientExThread() {
    }


    public static synchronized ClientExThread getInstance(Long time) {
        if (instance == null) {
            instance = new ClientExThread();
            executor.scheduleAtFixedRate(instance, time, time, TimeUnit.MILLISECONDS);
        }
        return instance;
    }

    public void addExceptionVo(ExceptionVo vo) {
        if (vo != null) {
            queue.add(vo);
        }
    }

    @Override
    public void run() {
        if (queue != null && queue.size() > 0) {
            for (int i = 0; i < queue.size(); i++) {
                ExceptionVo poll = queue.poll();
                sendServiceMsg(poll);
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
            String resultStr = null;
            ExceptionService server = (ExceptionService) RegistryService.getRegistry();
            Result result = server.sendMsg(vo);
            resultStr = result.toString();
            if (log.isLoggable(Level.INFO)) {
                log.info("____异常上传结果:" + resultStr);
            }
        } catch (NoSuchObjectException suchObjectException) {
            RegistryService.refreshAndRetry();
            suchObjectException.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
