package com.xz.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xz.web.entity.TiYanList;
import com.xz.web.service.TiYanListService;
import com.xz.framework.utils.bean.BeanUtil;
import com.xz.framework.utils.date.DateUtil;
import com.xz.framework.utils.string.StringUtil;
import com.xz.framework.common.base.AjaxBean;
import com.xz.framework.common.base.AjaxStatus;
import com.xz.framework.common.base.BaseController;
import com.xz.framework.common.base.PageInfo;
import com.xz.web.constant.Constant;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import com.xz.framework.utils.files.FileUtil;

@org.springframework.stereotype.Controller("tiYanListTiYanListController")
@RequestMapping("tiYanList")
public class TiYanListController extends BaseController {

    @Autowired
    private TiYanListService tiYanListService;

    

    @RequestMapping("json/addTiYanList")
    public
    @ResponseBody
    String addTiYanList(TiYanList tiYanList) {
        AjaxBean<TiYanList> ajaxBean = new AjaxBean<TiYanList>();
        TiYanList entity = new TiYanList();
        BeanUtil.copyProperties(tiYanList, entity, Constant.NotNul);
        entity.setCreateTimestamp(DateUtil.getCurrentTimestamp());
        entity.setUpdateTimestamp(DateUtil.getCurrentTimestamp());
        int flag = tiYanListService.add(entity);
        if(flag>0) {
            ajaxBean.setStatus(AjaxStatus.SUCCESS);
            ajaxBean.setMessage("增加成功!");
        }else
        {
            ajaxBean.setStatus(AjaxStatus.ERROR);
            ajaxBean.setMessage("增加失败!");
        }
        return this.ajaxJson(ajaxBean);
    }

    @RequestMapping("json/delTiYanListById")
    public
    @ResponseBody
    String delTiYanListById(Long id) {
        AjaxBean<Integer> ajaxBean = new AjaxBean<Integer>();
        int flag = tiYanListService.removeById(id);
        if(flag>0) {
            ajaxBean.setStatus(AjaxStatus.SUCCESS);
            ajaxBean.setMessage("删除成功!");
            ajaxBean.setData(flag);
        }else
        {
            ajaxBean.setStatus(AjaxStatus.ERROR);
            ajaxBean.setMessage("删除失败!");
            ajaxBean.setData(flag);
        }
        return this.ajaxJson(ajaxBean);
    }

    @RequestMapping("json/updateTiYanListById")
    public
    @ResponseBody
    String updateTiYanListById(TiYanList tiYanList) {
        AjaxBean<String> ajaxBean = new AjaxBean<String>();
        Long id = tiYanList.getId();
        if(id!=null) {
            TiYanList entity = tiYanListService.getById(id);
            if(null==entity) {
                ajaxBean.setStatus(AjaxStatus.ERROR);
                ajaxBean.setMessage("记录不存在!");
            }else
            {
                BeanUtil.copyProperties(tiYanList,entity,Constant.NotNul);
                entity.setUpdateTimestamp(DateUtil.getCurrentTimestamp());
                int flag = tiYanListService.update(entity);
                if(flag>0) {
                    ajaxBean.setStatus(AjaxStatus.SUCCESS);
                    ajaxBean.setMessage("更新成功!");
                }else
                {
                    ajaxBean.setStatus(AjaxStatus.ERROR);
                    ajaxBean.setMessage("更新失败!");
                }
            }
        }else
        {
            ajaxBean.setStatus(AjaxStatus.ERROR);
            ajaxBean.setMessage("记录不存在!");
        }
        return this.ajaxJson(ajaxBean);
    }

    @RequestMapping("json/getTiYanListById")
    public
    @ResponseBody
    String getTiYanListById(Long id) {
        AjaxBean<TiYanList> ajaxBean = new AjaxBean<TiYanList>();
        TiYanList obj = tiYanListService.getById(id);
        ajaxBean.setStatus(AjaxStatus.SUCCESS);
        ajaxBean.setData(obj);
        return this.ajaxJson(ajaxBean);
    }

    @RequestMapping("json/findTiYanListsByPage")
    public
    @ResponseBody
    String findTiYanListsByPage(TiYanList searchCondition, PageInfo<TiYanList> pager) {
        AjaxBean<PageInfo<TiYanList>> ajaxBean = new AjaxBean<PageInfo<TiYanList>>();
        pager = tiYanListService.findList(searchCondition, pager);
        ajaxBean.setStatus(AjaxStatus.SUCCESS);
        ajaxBean.setData(pager);
        return this.ajaxJson(ajaxBean);
    }

}
