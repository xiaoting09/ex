package com.xiao.ex.web;

import com.xiao.ex.core.vo.resp.Result;
import com.xiao.ex.entity.ExList;
import com.xiao.ex.service.ExListService;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.web.vo.ClinetRespVo;
import com.xiao.ex.web.vo.ExReqVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

/**
 * 异常控制器
 *
 * @author 肖亭
 * @since 2017年10月10 16:11
 **/
@Controller
@RequestMapping(value = "exList")
public class ExController {
    @Autowired
    private ExListService exListService;

    /**
     * 查询异常列表
     *
     * @return
     */
    @RequestMapping("/getExList")
    @ResponseBody
    public Result getExList() {
        List<String> rList = exListService.getExList();
        return new Result(rList);
    }

    @RequestMapping("/toEx")
    public String toEx(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page, Model model) {
        PageObj listPage = exListService.getExListPage(page);
        model.addAttribute("exs", listPage.getList());
        model.addAttribute("pageValue", listPage);
        model.addAttribute("titile", "异常管理");
        return "exftl";
    }

    @RequestMapping("/delEx")
    @ResponseBody
    public Result delEx(@RequestParam(value = "id",  required = true) Integer id) {
        ExList exList = new ExList();
        exList.setId(id);
        exList.setIsEnabled(Boolean.FALSE);
        exListService.updateEx(exList);
        return new Result();
    }

    @RequestMapping("/addOrUpdate")
    @ResponseBody
    public Result addOrUpdate(ExReqVo vo) {
        ExList exList = new ExList();
        BeanUtils.copyProperties(vo,exList);
        exList.setType(Objects.equals(vo.getType(),1));
        if (vo.getId()!=null){
            exListService.updateEx(exList);
        } else {
            exListService.addEx(exList);
        }
        return new Result();
    }

}
