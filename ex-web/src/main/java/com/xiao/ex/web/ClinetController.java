package com.xiao.ex.web;

import com.xiao.ex.core.vo.resp.Result;
import com.xiao.ex.entity.ExClient;
import com.xiao.ex.service.ClientService;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.web.vo.ClinetReqVo;
import com.xiao.ex.web.vo.ClinetRespVo;
import com.xiao.ex.web.vo.StatisticsReqVo;
import com.xiao.ex.web.vo.StatisticsRespVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

/**
 * 客户端控制器
 *
 * @author 肖亭
 * @since 2017年10月10 16:06
 **/
@Controller
@RequestMapping(value = "client")
public class ClinetController {
    @Autowired
    private ClientService clientService;

    /**
     * 查询机器列表
     *
     * @return
     */
    @RequestMapping("/getClinetList")
    @ResponseBody
    public Result getClinetList() {
        List<ClinetRespVo> rList = clientService.getClinetList();
        return new Result(rList);
    }

    @RequestMapping("/toClient")
    public String toClient(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page, Model model) {
        PageObj clinetPageList = clientService.getClinetPageList(page);
        model.addAttribute("clients", clinetPageList.getList());
        model.addAttribute("pageValue", clinetPageList);
        model.addAttribute("titile", "客户端管理");
        return "client";
    }

    @RequestMapping("/updataClient")
    @ResponseBody
    public Result updataClient(ClinetReqVo reqVo) {
        if (reqVo.getId() == null) {
            return new Result(0, "请传入ID");
        }
        ExClient client = new ExClient();
        client.setId(reqVo.getId());
        if (reqVo.getState() != null) {
            client.setState(Objects.equals(reqVo.getState(), 1));
        }
        if (reqVo.getIsEnabled() != null) {
            client.setIsEnabled(reqVo.getIsEnabled());
        }
        if (StringUtils.isNotBlank(reqVo.getEmail())) {
            client.setEmail(reqVo.getEmail());
        } else {
            client.setEmail("");
        }
        if (StringUtils.isNotBlank(reqVo.getPhone())) {
            client.setPhone(reqVo.getPhone());
        } else {
            client.setPhone("");
        }
        if (StringUtils.isNotBlank(reqVo.getIp())) {
            client.setIp(reqVo.getIp());
        }
        if (StringUtils.isNotBlank(reqVo.getDingdingToken())) {
            client.setDingdingToken(reqVo.getDingdingToken());
        }
        if (StringUtils.isNotBlank(reqVo.getRemarks())) {
            client.setRemarks(reqVo.getRemarks());
        } else {
            client.setRemarks("");
        }
        clientService.updateExClient(client);
        return new Result();
    }

    @RequestMapping("/addClient")
    @ResponseBody
    public Result addClient(ClinetReqVo reqVo) {
        if (reqVo.getId() != null) {
            return updataClient(reqVo);
        }
        ExClient client = new ExClient();
        client.setState(Objects.equals(reqVo.getState(), 1));
        client.setIp(reqVo.getIp());
        client.setRemarks(reqVo.getRemarks());
        client.setType(Boolean.FALSE);
        client.setPhone(reqVo.getPhone());
        client.setEmail(reqVo.getEmail());
        client.setDingdingToken(reqVo.getDingdingToken());
        clientService.insertExClient(client);
        return new Result();
    }
}
