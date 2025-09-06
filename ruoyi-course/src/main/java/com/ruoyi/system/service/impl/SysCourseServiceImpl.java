package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCourseMapper;
import com.ruoyi.system.domain.SysCourse;
import com.ruoyi.system.service.ISysCourseService;

/**
 * 课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-06
 */
@Service
public class SysCourseServiceImpl implements ISysCourseService 
{
    @Autowired
    private SysCourseMapper sysCourseMapper;

    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public SysCourse selectSysCourseById(Long id)
    {
        return sysCourseMapper.selectSysCourseById(id);
    }

    /**
     * 查询课程列表
     * 
     * @param sysCourse 课程
     * @return 课程
     */
    @Override
    public List<SysCourse> selectSysCourseList(SysCourse sysCourse)
    {
        return sysCourseMapper.selectSysCourseList(sysCourse);
    }

    /**
     * 新增课程
     * 
     * @param sysCourse 课程
     * @return 结果
     */
    @Override
    public int insertSysCourse(SysCourse sysCourse)
    {
        return sysCourseMapper.insertSysCourse(sysCourse);
    }

    /**
     * 修改课程
     * 
     * @param sysCourse 课程
     * @return 结果
     */
    @Override
    public int updateSysCourse(SysCourse sysCourse)
    {
        return sysCourseMapper.updateSysCourse(sysCourse);
    }

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteSysCourseByIds(Long[] ids)
    {
        return sysCourseMapper.deleteSysCourseByIds(ids);
    }

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    @Override
    public int deleteSysCourseById(Long id)
    {
        return sysCourseMapper.deleteSysCourseById(id);
    }
}
