package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程对象 sys_course
 * 
 * @author ruoyi
 * @date 2025-09-10
 */
public class SysCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程id */
    private Long id;

    /** 课程名字 */
    @Excel(name = "课程名字")
    private String name;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 课程简介 */
    @Excel(name = "课程简介")
    private String about;

    /** 课程详情 */
    @Excel(name = "课程详情")
    private String discroption;

    /** 课节 */
    @Excel(name = "课节")
    private Long lesson;

    /** 课时 */
    @Excel(name = "课时")
    private Long duration;

    /** 最大学生数 */
    @Excel(name = "最大学生数")
    private String maxStudents;

    /** 课程教师 */
    @Excel(name = "课程教师")
    private String teacher;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setAbout(String about) 
    {
        this.about = about;
    }

    public String getAbout() 
    {
        return about;
    }

    public void setDiscroption(String discroption) 
    {
        this.discroption = discroption;
    }

    public String getDiscroption() 
    {
        return discroption;
    }

    public void setLesson(Long lesson) 
    {
        this.lesson = lesson;
    }

    public Long getLesson() 
    {
        return lesson;
    }

    public void setDuration(Long duration) 
    {
        this.duration = duration;
    }

    public Long getDuration() 
    {
        return duration;
    }

    public void setMaxStudents(String maxStudents) 
    {
        this.maxStudents = maxStudents;
    }

    public String getMaxStudents() 
    {
        return maxStudents;
    }

    public void setTeacher(String teacher) 
    {
        this.teacher = teacher;
    }

    public String getTeacher() 
    {
        return teacher;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("price", getPrice())
            .append("about", getAbout())
            .append("discroption", getDiscroption())
            .append("lesson", getLesson())
            .append("duration", getDuration())
            .append("maxStudents", getMaxStudents())
            .append("teacher", getTeacher())
            .toString();
    }
}
