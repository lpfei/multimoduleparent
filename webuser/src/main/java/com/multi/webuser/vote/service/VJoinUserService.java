package com.multi.webuser.vote.service;


import com.multi.webcommon.model.PageModel;
import com.multi.webcommon.model.ServiceResult;
import com.multi.webuser.vote.entity.VJoinUser;
import com.multi.webuser.vote.entity.VJoinUserExample;
import com.multi.webuser.vote.mapper.VJoinUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class VJoinUserService {
    @Autowired
    VJoinUserMapper vJoinUserMapper;

    /**
     * 分页查询
     *
     * @param example
     * @param pageModel
     * @return
     */
    public PageModel selectByExample4Page(VJoinUserExample example, PageModel pageModel) {
        if (null == example) {
            example = new VJoinUserExample();
        }
        if (null == pageModel) {
            pageModel = new PageModel();
        }
        example.setPageModel(pageModel);
        int rowsCount = vJoinUserMapper.countByExample(example);
        Collection dataSouce = vJoinUserMapper.selectByExample(example);
        pageModel.setRowsCount(rowsCount);
        pageModel.setDataSource(dataSouce);
        return pageModel;
    }

    /**
     * 插入数据
     *
     * @return
     */
    public int insertSelective(VJoinUser record) {
        return vJoinUserMapper.insertSelective(record);
    }

    /**
     * 查询数据
     *
     * @return
     */
    public VJoinUser selectByPrimaryKey(Integer id) {
        return vJoinUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新数据
     *
     * @return
     */
    public int updateByPrimaryKeySelective(VJoinUser record) {
        return vJoinUserMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除数据
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteByPrimaryKey(Integer id) {
        VJoinUser managerPO = vJoinUserMapper.selectByPrimaryKey(id);
        if (managerPO == null) {
            return ServiceResult.error("记录不存在");
        }
        vJoinUserMapper.deleteByPrimaryKey(id);
        return ServiceResult.success();
    }


    /**
     * 查询实体
     *
     * @return
     */
    public VJoinUser selectOneByUserName(String userName) {
        VJoinUserExample example = new VJoinUserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<VJoinUser> list = vJoinUserMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }
}
