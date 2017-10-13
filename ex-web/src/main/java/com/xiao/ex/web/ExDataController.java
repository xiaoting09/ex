package com.xiao.ex.web;

import com.xiao.ex.service.ClientDataService;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.web.vo.ExDataReqVo;
import com.xiao.ex.web.vo.ExDataRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 异常数据控制
 *
 * @author 肖亭
 * @since 2017年10月13 9:35
 **/
@Controller
@RequestMapping(value = "data")
public class ExDataController {
    @Autowired
    private ClientDataService clientDataService;

    @RequestMapping("/toData")
    public String toData(ExDataReqVo vo, Model model) {
        PageObj listPage = clientDataService.getExList(vo);
        model.addAttribute("clientId", vo.getClientId());
        model.addAttribute("datas", listPage.getList());
        model.addAttribute("pageValue", listPage);
        model.addAttribute("titile", "异常列表");
        return "data";
    }

    @RequestMapping("/showData")
    public String showData(@RequestParam(value = "id", required = true) Long id, ExDataReqVo vo, Model model) {
        ExDataRespVo respVo = clientDataService.getData(id);
        model.addAttribute("page", vo.getPage() == null ? 1 : vo.getPage());
        model.addAttribute("clientId", vo.getClientId());
        model.addAttribute("data", respVo);
        model.addAttribute("titile", "异常详情");
        return "showData";
    }
}
