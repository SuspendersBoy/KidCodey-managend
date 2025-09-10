package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysCourse;

/**
 * 课程Service接口
 * 
 * @author ruoyi
 * @date 2025-09-10
 */
public interface ISysCourseService 
{
    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    public SysCourse selectSysCourseById(Long id);

    /**
     * 查询课程列表
     * 
     * @param sysCourse 课程
     * @return 课程集合
     */
    public List<SysCourse> selectSysCourseList(SysCourse sysCourse);

    /**
     * 新增课程
     * 
     * @param sysCourse 课程
     * @return 结果
     */
    public int insertSysCourse(SysCourse sysCourse);

    /**
     * 修改课程
     * 
     * @param sysCourse 课程
     * @return 结果
     */
    public int updateSysCourse(SysCourse sysCourse);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键集合
     * @return 结果
     */
    public int deleteSysCourseByIds(Long[] ids);

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteSysCourseById(Long id);
}
