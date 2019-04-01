package com.multi.webcommon.util;


import com.multi.webcommon.model.PageModel;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhuxh on 2017/12/20.
 */
public class PageUtil {
    /**
     * 分页参数自动封装
     * @return
     */
    public static PageModel initPageModel() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(null == request){
            return  new PageModel();
        }
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        if( NullUtil.isNotEmpty(pageNum) &&  NullUtil.isNotEmpty(pageSize) ){
            return new PageModel(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        }
        return  new PageModel();
    }
    public static PageModel initDataTablePage(Integer pageNumber, Integer pageSize) {
        int pNum = 1;
        int pSize = 10;
        if (NullUtil.isNotEmpty(pageNumber)) {
            pNum = pageNumber;
        }
        if (NullUtil.isNotEmpty(pageSize)) {
            pSize = pageSize;
        }
        pSize = pSize > 50 ? 50 : pSize;
        return new PageModel(pNum, pSize);
    }

    public static void main(String[] args) {
        System.out.println(-1>>1);
    }
}
