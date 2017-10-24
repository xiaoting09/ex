package com.xiao.ex.web;

import com.xiao.ex.core.vo.resp.Result;
import com.xiao.ex.entity.ExClientList;
import com.xiao.ex.entity.ExList;
import com.xiao.ex.service.ExClientListService;
import com.xiao.ex.service.ExListService;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.web.vo.ExListReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 肖亭
 * @since 2017年10月11 18:11
 **/
@Controller
@RequestMapping(value = "exList")
public class ExListClinetController {
    @Autowired
    private ExClientListService exClientListService;
    @Autowired
    private ExListService exListService;

    @RequestMapping("/toExEmail")
    public String toEx(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page, Model model) {
        PageObj pageObj = exClientListService.getPageList(page);
        model.addAttribute("exs", pageObj.getList());
        model.addAttribute("pageValue", pageObj);
        model.addAttribute("titile", "邮件发送管理");
        return "exEmail";
    }

    @RequestMapping("/addClientList")
    @ResponseBody
    public Result addClientList(ExListReqVo vo) {
        ExList exList = new ExList();
        exList.setName(vo.getExName());
        exList.setIsEnabled(true);
        ExList exOrAdd = exListService.findList(exList).get(0);
        ExClientList exClientList = new ExClientList();
        exClientList.setListId(exOrAdd.getId());
        exClientList.setClientId(vo.getClinetId());
        exClientListService.addExClinetList(exClientList);
        return new Result();
    }

    @RequestMapping("/updateList")
    @ResponseBody
    public Result updateList(ExListReqVo vo) {
        exClientListService.updateById(vo.getId());
        return new Result();
    }
}
