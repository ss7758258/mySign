package com.xz.web.controller;

import com.github.pagehelper.PageInfo;
import com.xz.framework.bean.ajax.RequestHeader;
import com.xz.framework.bean.ajax.XZResponseBody;
import com.xz.framework.bean.enums.AjaxStatus;
import com.xz.framework.bean.weixin.Weixin;
import com.xz.framework.common.base.BeanCriteria;
import com.xz.framework.controller.BaseController;
import com.xz.framework.utils.BeanUtil;
import com.xz.framework.utils.DateUtil;
import com.xz.framework.utils.JsonUtil;
import com.xz.framework.utils.StringUtil;
import com.xz.web.bo.everydayQian.X500Bo;
import com.xz.web.dao.redis.RedisDao;
import com.xz.web.mapper.entity.TiQianList;
import com.xz.web.mapper.entity.TiUserQianList;
import com.xz.web.mapper.entity.WeixinUser;
import com.xz.web.service.TiQianListService;
import com.xz.web.service.TiUserQianListService;
import com.xz.web.service.WeixinUserService;
import com.xz.web.service.ext.EverydayQianService;
import com.xz.web.utils.ResultUtil;
import com.xz.web.vo.everydayQian.X510Vo;
import com.xz.web.vo.everydayQian.X511;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 一言
 */
@RequestMapping("/everydayQian")
@Controller
public class EverydayQianController extends BaseController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EverydayQianService everydayQianService;
    @Autowired
    TiUserQianListService tiUserQianListService;
    @Autowired
    TiQianListService tiQianListService;
    @Autowired
    WeixinUserService weixinUserService;
    @Autowired
    private RedisDao redisService;

    @Value("#{constants.qian_open_size}")
    private int qianOpenSize;

    /**
     * 每日一签
     *
     * @param requestBody
     * @return
     */
    @RequestMapping("x500")
    @ResponseBody
    public String x500(String requestBody) {
        XZResponseBody<X500Bo> responseBody = new XZResponseBody<X500Bo>();
        /**
         *  当天时间（有英文）；
         * 星座图片、描述（是否有多条）；
         * 星座总结话；
         */
        try {
            responseBody = everydayQianService.selectEverydayQian();
        } catch (Exception e) {
            ResultUtil.returnResultLog(responseBody, "服务器异常，请稍后再试", e.getMessage(), logger);
        } finally {
            return this.toJSON(responseBody);
        }
    }

    /**
     * 保存一签图片
     *
     * @param requestBody
     * @return
     */
    @RequestMapping("x501")
    @ResponseBody
    public String x501(String requestBody) {
        XZResponseBody<String> responseBody = new XZResponseBody<String>();
        try {
            responseBody = everydayQianService.saveEverydayQian();
        } catch (Exception e) {
            ResultUtil.returnResultLog(responseBody, "服务器异常，请稍后再试", e.getMessage(), logger);
        } finally {
            return this.toJSON(responseBody);
        }
    }

    /**
     * 拆签
     *
     * @param requestBody
     * @return
     */
    @RequestMapping("x504")
    @ResponseBody
    public String x504(String requestBody) {
        XZResponseBody<X511> responseBody = new XZResponseBody<X511>();
        responseBody.setStatus(AjaxStatus.SUCCESS);
        Weixin weixin = this.getWeixin();
        if (null == weixin || StringUtil.isEmpty(weixin.getOpenId())) {
            ResultUtil.returnResult(responseBody, "认证过期，请重新认证");
            return this.toJSON(responseBody);
        }

        String useridStr = redisService.get("openId-:" + weixin.getOpenId());
        Long userId = Long.valueOf(useridStr);
        String currentDate = DateUtil.getDate();
        try {
            BeanCriteria beanCriteria = new BeanCriteria(TiUserQianList.class);
            BeanCriteria.Criteria criteria = beanCriteria.createCriteria();
            criteria.andEqualTo("userId", userId);
            criteria.andEqualTo("qianDate", currentDate);
            beanCriteria.setOrderByClause("update_timestamp desc");
            PageInfo<TiUserQianList> pager = new PageInfo<TiUserQianList>();
            pager = tiUserQianListService.selectByPage(pager, beanCriteria);
            List<TiUserQianList> list = pager.getList();
            if (list.size() > 0) {
                TiUserQianList obj = list.get(0);
                X511 x511 = new X511();
                BeanUtil.copyProperties(obj, x511);
                String ownerOpenId = weixin.getOpenId();
                if (StringUtil.isNotEmpty(ownerOpenId)) {
                    String ownerImage = redisService.get("headImage-:" + ownerOpenId);
                    x511.setOwnerHeadImage(ownerImage);
                    x511.setOwnerOpenId(ownerOpenId);
                    String ownerNickName = redisService.get("nickName-:" + ownerOpenId);
                    x511.setOwnerNickName(ownerNickName);
                }
                String openId1 = obj.getFriendOpenId1();
                String openId2 = obj.getFriendOpenId2();
                String openId3 = obj.getFriendOpenId3();
                String openId4 = obj.getFriendOpenId4();
                String openId5 = obj.getFriendOpenId5();
                if (StringUtil.isNotEmpty(openId1)) {
                    String headImage1 = redisService.get("headImage-:" + openId1);
                    x511.setFriendHeadImage1(headImage1);
                }
                if (StringUtil.isNotEmpty(openId2)) {
                    String headImage2 = redisService.get("headImage-:" + openId2);
                    x511.setFriendHeadImage2(headImage2);
                }
                if (StringUtil.isNotEmpty(openId3)) {
                    String headImage3 = redisService.get("headImage-:" + openId3);
                    x511.setFriendHeadImage3(headImage3);
                }
                if (StringUtil.isNotEmpty(openId4)) {
                    String headImage4 = redisService.get("headImage-:" + openId4);
                    x511.setFriendHeadImage4(headImage4);
                }
                if (StringUtil.isNotEmpty(openId5)) {
                    String headImage5 = redisService.get("headImage-:" + openId5);
                    x511.setFriendHeadImage5(headImage5);
                }
                if (obj.getStatus() == 0) {
                    x511.setQianOpenSize(qianOpenSize);
                    responseBody.setStatus(AjaxStatus.SUCCESS);
                    responseBody.setMessage("");
                    responseBody.setData(x511);
                    return this.toJSON(responseBody);
                } else {
                    x511.setQianOpenSize(qianOpenSize);
                    responseBody.setStatus(AjaxStatus.ERROR);
                    responseBody.setMessage("无签");
                    responseBody.setData(x511);
                    return this.toJSON(responseBody);
                }
            } else {
                TiQianList qian = null;
                try{
                    String qianStr = redisService.get("randomQian");
                    qian = JsonUtil.deserialize(qianStr,TiQianList.class);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                if(null == qian)
                {
                    long count = everydayQianService.countActiveQianList();
                    int randomNum = (int) (Math.random() * count);
                    qian = everydayQianService.randomActiveQianList(randomNum);
                }
                if (null!=qian) {
                    TiUserQianList obj = new TiUserQianList();
                    obj.setQianDate(DateUtil.getDate());
                    obj.setQianName(qian.getName());
                    obj.setQianContent(qian.getContent());
                    obj.setFriendOpenId1(weixin.getOpenId());
                    obj.setStatus(0);
                    obj.setUserId(userId);
                    obj.setCreateTimestamp(DateUtil.getDatetime());
                    obj.setUpdateTimestamp(DateUtil.getDatetime());
                    everydayQianService.save(obj);

                    X511 x511 = new X511();
                    BeanUtil.copyProperties(obj, x511,true);
                    String ownerOpenId = weixin.getOpenId();
                    if (StringUtil.isNotEmpty(ownerOpenId)) {
                        String ownerImage = redisService.get("headImage-:" + ownerOpenId);
                        x511.setOwnerHeadImage(ownerImage);
                        x511.setOwnerOpenId(ownerOpenId);
                        String ownerNickName = redisService.get("nickName-:" + ownerOpenId);
                        x511.setOwnerNickName(ownerNickName);
                    }
                    x511.setId(obj.getId());
                    String openId1 = obj.getFriendOpenId1();
                    String openId2 = obj.getFriendOpenId2();
                    String openId3 = obj.getFriendOpenId3();
                    String openId4 = obj.getFriendOpenId4();
                    String openId5 = obj.getFriendOpenId5();
                    if (StringUtil.isNotEmpty(openId1)) {
                        String headImage1 = redisService.get("headImage-:" + openId1);
                        x511.setFriendHeadImage1(headImage1);
                    }
                    if (StringUtil.isNotEmpty(openId2)) {
                        String headImage2 = redisService.get("headImage-:" + openId2);
                        x511.setFriendHeadImage2(headImage2);
                    }
                    if (StringUtil.isNotEmpty(openId3)) {
                        String headImage3 = redisService.get("headImage-:" + openId3);
                        x511.setFriendHeadImage3(headImage3);
                    }
                    if (StringUtil.isNotEmpty(openId4)) {
                        String headImage4 = redisService.get("headImage-:" + openId4);
                        x511.setFriendHeadImage4(headImage4);
                    }
                    if (StringUtil.isNotEmpty(openId5)) {
                        String headImage5 = redisService.get("headImage-:" + openId5);
                        x511.setFriendHeadImage5(headImage5);
                    }
                    x511.setQianOpenSize(qianOpenSize);
                    responseBody.setStatus(AjaxStatus.SUCCESS);
                    responseBody.setMessage("");
                    responseBody.setData(x511);
                    return this.toJSON(responseBody);
                } else {
                    responseBody.setStatus(AjaxStatus.ERROR);
                    responseBody.setMessage("签已经用完!");
                    return this.toJSON(responseBody);
                }
            }
        } catch (Exception e) {
            e.getMessage();
            ResultUtil.returnResultLog(responseBody, "服务器异常，请稍后再试", e.getMessage(), logger);
        } finally {
            return this.toJSON(responseBody);
        }
    }

    /**
     * 解签列表
     *
     * @param requestBody
     * @return
     */
    @RequestMapping("x506")
    @ResponseBody
    public String x506(String requestBody) {
        XZResponseBody<X511> responseBody = new XZResponseBody<X511>();
        responseBody.setStatus(AjaxStatus.SUCCESS);
        Weixin weixin = this.getWeixin();
        if (null == weixin || StringUtil.isEmpty(weixin.getOpenId())) {
            ResultUtil.returnResult(responseBody, "认证过期，请重新认证");
            return this.toJSON(responseBody);
        }
        String useridStr = redisService.get("openId-:" + weixin.getOpenId());
        try {
            X510Vo obj = JsonUtil.deserialize(requestBody, X510Vo.class);
            if (obj == null) {
                ResultUtil.returnResultLog(responseBody, "ID为空!", null, logger);
            }
            TiUserQianList data = tiUserQianListService.selectByKey(obj.getId());

            X511 x511 = new X511();
            

            if(weixin.getOpenId().equals(data.getFriendOpenId1()))
                x511.setAlreadyOpen(1);
            if(weixin.getOpenId().equals(data.getFriendOpenId2()))
                x511.setAlreadyOpen(2);
            if(weixin.getOpenId().equals(data.getFriendOpenId3()))
                x511.setAlreadyOpen(3);
            if(weixin.getOpenId().equals(data.getFriendOpenId4()))
                x511.setAlreadyOpen(4);
            if(weixin.getOpenId().equals(data.getFriendOpenId5()))
                x511.setAlreadyOpen(5);

            if(x511.getAlreadyOpen()<1) {
                if (StringUtil.isEmpty(data.getFriendOpenId1())&&qianOpenSize>=1) {
                    if(qianOpenSize==1)
                        data.setStatus(1);
                    data.setFriendOpenId1(weixin.getOpenId());
                } else if (StringUtil.isEmpty(data.getFriendOpenId2())&&qianOpenSize>=2) {
                    if(qianOpenSize==2)
                        data.setStatus(1);
                    data.setFriendOpenId2(weixin.getOpenId());
                } else if (StringUtil.isEmpty(data.getFriendOpenId3())&&qianOpenSize>=3) {
                    if(qianOpenSize==3)
                        data.setStatus(1);
                    data.setFriendOpenId3(weixin.getOpenId());
                } else if (StringUtil.isEmpty(data.getFriendOpenId4())&&qianOpenSize>=4) {
                    if(qianOpenSize==4)
                        data.setStatus(1);
                    data.setFriendOpenId4(weixin.getOpenId());
                } else if (StringUtil.isEmpty(data.getFriendOpenId5())&&qianOpenSize>=5) {
                    if(qianOpenSize==5)
                        data.setStatus(1);
                    data.setFriendOpenId5(weixin.getOpenId());
                }
                data.setUpdateTimestamp(DateUtil.getDatetime());
                tiUserQianListService.update(data);
            }
            BeanUtil.copyProperties(data, x511,true);
            String ownerOpenId = weixin.getOpenId();
            if (StringUtil.isNotEmpty(ownerOpenId)) {
                String ownerImage = redisService.get("headImage-:" + ownerOpenId);
                x511.setOwnerHeadImage(ownerImage);
                x511.setOwnerOpenId(ownerOpenId);
                String ownerNickName = redisService.get("nickName-:" + ownerOpenId);
                x511.setOwnerNickName(ownerNickName);
            }
            String openId1 = data.getFriendOpenId1();
            String openId2 = data.getFriendOpenId2();
            String openId3 = data.getFriendOpenId3();
            String openId4 = data.getFriendOpenId4();
            String openId5 = data.getFriendOpenId5();
            if (StringUtil.isNotEmpty(openId1)) {
                String headImage1 = redisService.get("headImage-:" + openId1);
                x511.setFriendHeadImage1(headImage1);
            }
            if (StringUtil.isNotEmpty(openId2)) {
                String headImage2 = redisService.get("headImage-:" + openId2);
                x511.setFriendHeadImage2(headImage2);
            }
            if (StringUtil.isNotEmpty(openId3)) {
                String headImage3 = redisService.get("headImage-:" + openId3);
                x511.setFriendHeadImage3(headImage3);
            }
            if (StringUtil.isNotEmpty(openId4)) {
                String headImage4 = redisService.get("headImage-:" + openId4);
                x511.setFriendHeadImage4(headImage4);
            }
            if (StringUtil.isNotEmpty(openId5)) {
                String headImage5 = redisService.get("headImage-:" + openId5);
                x511.setFriendHeadImage5(headImage5);
            }

            x511.setQianOpenSize(qianOpenSize);
            responseBody.setData(x511);
        } catch (Exception e) {
            e.getMessage();
            ResultUtil.returnResultLog(responseBody, "服务器异常，请稍后再试", e.getMessage(), logger);
        } finally {
            return this.toJSON(responseBody);
        }
    }

    /**
     * 解签列表
     *
     * @param requestBody
     * @return
     */
    @RequestMapping("x510")
    @ResponseBody
    public String x510(String requestBody) {
        XZResponseBody<List<TiUserQianList>> responseBody = new XZResponseBody<List<TiUserQianList>>();
        responseBody.setStatus(AjaxStatus.SUCCESS);
        Weixin weixin = this.getWeixin();
        if (null == weixin || StringUtil.isEmpty(weixin.getOpenId())) {
            ResultUtil.returnResult(responseBody, "认证过期，请重新认证");
            return this.toJSON(responseBody);
        }
        String useridStr = redisService.get("openId-:" + weixin.getOpenId());
        Long userId = Long.valueOf(useridStr);
        try {
            RequestHeader requestHeader = this.getRequestHeader();
            X510Vo obj = JsonUtil.deserialize(requestBody, X510Vo.class);
            if (obj == null) {
                obj = new X510Vo();
            }
            if (obj.getPageSize() == null) {
                obj.setPageSize(5);
            }
            if (obj.getPageNum() == null) {
                obj.setPageNum(1);
            }
            BeanCriteria beanCriteria = new BeanCriteria(TiUserQianList.class);
            BeanCriteria.Criteria criteria = beanCriteria.createCriteria();
            criteria.andEqualTo("userId", userId);
            beanCriteria.setOrderByClause("update_timestamp desc");
            PageInfo<TiUserQianList> pager = new PageInfo<TiUserQianList>();
            pager.setPageSize(obj.getPageSize());
            pager.setPageNum(obj.getPageNum());
            pager = tiUserQianListService.selectByPage(pager, beanCriteria);
            responseBody.setData(pager.getList());
        } catch (Exception e) {
            ResultUtil.returnResultLog(responseBody, "服务器异常，请稍后再试", e.getMessage(), logger);
        } finally {
            return this.toJSON(responseBody);
        }
    }

    /**
     * 解签列表
     *
     * @param requestBody
     * @return
     */
    @RequestMapping("x511")
    @ResponseBody
    public String x511(String requestBody) {
        XZResponseBody<X511> responseBody = new XZResponseBody<X511>();
        responseBody.setStatus(AjaxStatus.SUCCESS);
        Weixin weixin = this.getWeixin();
        if (null == weixin || StringUtil.isEmpty(weixin.getOpenId())) {
            ResultUtil.returnResult(responseBody, "认证过期，请重新认证");
            return this.toJSON(responseBody);
        }
        try {
            X510Vo obj = JsonUtil.deserialize(requestBody, X510Vo.class);
            if (obj == null) {
                ResultUtil.returnResultLog(responseBody, "ID为空!", null, logger);
            }
            TiUserQianList data = tiUserQianListService.selectByKey(obj.getId());
            String useridStr = redisService.get("openId-:" + weixin.getOpenId());
            Long userId = Long.valueOf(useridStr);
            X511 x511 = new X511();
            BeanUtil.copyProperties(data, x511);
            if(data.getUserId()==userId)
            {
                x511.setIsMyQian(1);
            }
            if(weixin.getOpenId().equals(data.getFriendOpenId1()))
                x511.setAlreadyOpen(1);
            if(weixin.getOpenId().equals(data.getFriendOpenId2()))
                x511.setAlreadyOpen(2);
            if(weixin.getOpenId().equals(data.getFriendOpenId3()))
                x511.setAlreadyOpen(3);
            if(weixin.getOpenId().equals(data.getFriendOpenId4()))
                x511.setAlreadyOpen(4);
            if(weixin.getOpenId().equals(data.getFriendOpenId5()))
                x511.setAlreadyOpen(5);
            //通过userid获取openId
            String ownerOpenId = redisService.get("userId-:"+data.getUserId());
            if(null==ownerOpenId)
            {
                WeixinUser weixinUser = weixinUserService.selectByKey(data.getUserId());
                ownerOpenId = weixinUser.getOpenId();
            }
            if(null!=ownerOpenId)
            {
                if (StringUtil.isNotEmpty(ownerOpenId)) {
                    String ownerImage = redisService.get("headImage-:" + ownerOpenId);
                    x511.setOwnerHeadImage(ownerImage);
                    x511.setOwnerOpenId(ownerOpenId);
                    String ownerNickName = redisService.get("nickName-:" + ownerOpenId);
                    x511.setOwnerNickName(ownerNickName);
                }
            }
            String openId1 = data.getFriendOpenId1();
            String openId2 = data.getFriendOpenId2();
            String openId3 = data.getFriendOpenId3();
            String openId4 = data.getFriendOpenId4();
            String openId5 = data.getFriendOpenId5();
            if (StringUtil.isNotEmpty(openId1)) {
                String headImage1 = redisService.get("headImage-:" + openId1);
                x511.setFriendHeadImage1(headImage1);
            }
            if (StringUtil.isNotEmpty(openId2)) {
                String headImage2 = redisService.get("headImage-:" + openId2);
                x511.setFriendHeadImage2(headImage2);
            }
            if (StringUtil.isNotEmpty(openId3)) {
                String headImage3 = redisService.get("headImage-:" + openId3);
                x511.setFriendHeadImage3(headImage3);
            }
            if (StringUtil.isNotEmpty(openId4)) {
                String headImage4 = redisService.get("headImage-:" + openId4);
                x511.setFriendHeadImage4(headImage4);
            }
            if (StringUtil.isNotEmpty(openId5)) {
                String headImage5 = redisService.get("headImage-:" + openId5);
                x511.setFriendHeadImage5(headImage5);
            }
            x511.setQianOpenSize(qianOpenSize);
            responseBody.setData(x511);
        } catch (Exception e) {
            e.getMessage();
            ResultUtil.returnResultLog(responseBody, "服务器异常，请稍后再试", e.getMessage(), logger);
        } finally {
            return this.toJSON(responseBody);
        }
    }

    public int getQianOpenSize() {
        return qianOpenSize;
    }

    public void setQianOpenSize(int qianOpenSize) {
        this.qianOpenSize = qianOpenSize;
    }
}


