package com.xiao.ex.web;

import com.xiao.ex.core.vo.resp.Result;
import com.xiao.ex.service.ClientDataService;
import com.xiao.ex.web.vo.StatisticsReqVo;
import com.xiao.ex.web.vo.StatisticsRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 首页控制
 *
 * @author 肖亭
 * @since 2017年10月10 14:11
 **/
@Controller
public class IndexController {
    @Autowired
    private ClientDataService clientDataService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("titile", "首页");
        return "index";
    }

    /**
     * 查询饼图
     *
     * @param reqVo
     * @return
     */
    @RequestMapping("/getDataList")
    @ResponseBody
    public Result getDataList(StatisticsReqVo reqVo) {
        List<StatisticsRespVo> rList = clientDataService.getDataList(reqVo);
        return new Result(rList);
    }

    /**
     * 查询折线图统计
     *
     * @param reqVo
     * @return
     */
    @RequestMapping("/getLineData")
    @ResponseBody
    public Result getLineData(StatisticsReqVo reqVo) {
        List<StatisticsRespVo> rList = clientDataService.getLineData(reqVo);
        return new Result(rList);
    }

}
