package com.xz.web.controller;

import com.xz.framework.bean.ajax.XZResponseBody;
import com.xz.framework.bean.weixin.Weixin;
import com.xz.framework.controller.BaseController;
import com.xz.framework.utils.JsonUtil;
import com.xz.framework.utils.StringUtil;
import com.xz.web.bo.moreConstellation.X300Bo;
import com.xz.web.service.ext.MoreConstellationService;
import com.xz.web.utils.ResultUtil;
import com.xz.web.vo.moreConstellation.X300Vo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 查看更多
 */
@RequestMapping("/moreConstellation")
@Controller
public class MoreConstellationController extends BaseController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MoreConstellationService moreConstellationService;

    /**
     * 返回星座运势（更多）
     * @param requestBody
     * @return
     */
    @RequestMapping("x300")
    @ResponseBody
    public String x300(String requestBody) {
        X300Vo obj = JsonUtil.deserialize(requestBody, X300Vo.class);
        XZResponseBody<X300Bo> responseBody = new XZResponseBody<X300Bo>();
        if (null == obj || null == obj.getConstellationId()) {
            ResultUtil.returnResult(responseBody, "请选择星座");
            return this.toJSON(responseBody);
        }
        Weixin weixin = this.getWeixin();
        if (null == weixin || StringUtil.isEmpty(weixin.getOpenId())) {
            ResultUtil.returnResult(responseBody, "认证过期，请重新认证");
            return this.toJSON(responseBody);
        }
        //返回星座运势
        try {
            responseBody = moreConstellationService.selectMoreConstellation(obj.getConstellationId(), weixin);
        } catch (Exception e) {
            ResultUtil.returnResultLog(responseBody, "服务器异常，请稍后再试", e.getMessage(), logger);
        }finally {
            return this.toJSON(responseBody);
        }
    }

    /**
     * 保存图片
     * @param requestBody
     * @return
     */
    @RequestMapping("x301")
    @ResponseBody
    public String x301(String requestBody) {
        X300Vo obj = JsonUtil.deserialize(requestBody, X300Vo.class);
        XZResponseBody<X300Bo> responseBody = new XZResponseBody<X300Bo>();
        if (null == obj || null == obj.getConstellationId()) {
            ResultUtil.returnResult(responseBody, "请选择星座");
            return this.toJSON(responseBody);
        }
        Weixin weixin = this.getWeixin();
        if (null == weixin || StringUtil.isEmpty(weixin.getOpenId())) {
            ResultUtil.returnResult(responseBody, "认证过期，请重新认证");
            return this.toJSON(responseBody);
        }
        //返回星座运势
        try {
            responseBody = moreConstellationService.selectMoreConstellation(obj.getConstellationId(), weixin);
        } catch (Exception e) {
            ResultUtil.returnResultLog(responseBody, "服务器异常，请稍后再试", e.getMessage(), logger);
        }finally {
            return this.toJSON(responseBody);
        }
    }

}


