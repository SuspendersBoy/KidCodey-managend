package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysCourse;

/**
 * 课程Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-06
 */
public interface SysCourseMapper 
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
     * 删除课程
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteSysCourseById(Long id);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysCourseByIds(Long[] ids);
}
