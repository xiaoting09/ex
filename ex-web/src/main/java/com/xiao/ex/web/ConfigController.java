package com.xiao.ex.web;

import com.xiao.ex.core.vo.resp.Result;
import com.xiao.ex.entity.ExConfig;
import com.xiao.ex.service.ConfigService;
import com.xiao.ex.utils.PageObj;
import com.xiao.ex.web.vo.ConfigReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 字典配置
 *
 * @author 肖亭
 * @since 2017年10月11 11:26
 **/
@Controller
@RequestMapping(value = "config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @RequestMapping("/toConfig")
    public String toConfig(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page, Model model) {
        PageObj clinetPageList = configService.getConfgList(page);
        model.addAttribute("configs", clinetPageList.getList());
        model.addAttribute("pageValue", clinetPageList);
        model.addAttribute("titile", "配置管理");
        return "config";
    }
    @RequestMapping("/addConf")
    @ResponseBody
    public Result addConf(ConfigReqVo vo) {
        ExConfig config = new ExConfig();
        config.setName(vo.getName());
        config.setValue(vo.getValue());
        config.setDescription(vo.getDesc());
        configService.addConfig(config);
        return new Result();
    }
    @RequestMapping("/delConf")
    @ResponseBody
    public Result delConf(ConfigReqVo vo) {
        configService.delConfig(vo.getId());
        return new Result();
    }
}
