<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程名字" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入课程名字"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程简介" prop="about">
        <el-input
          v-model="queryParams.about"
          placeholder="请输入课程简介"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课节" prop="lesson">
        <el-input
          v-model="queryParams.lesson"
          placeholder="请输入课节"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课时" prop="duration">
        <el-input
          v-model="queryParams.duration"
          placeholder="请输入课时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最大学生数" prop="maxStudents">
        <el-input
          v-model="queryParams.maxStudents"
          placeholder="请输入最大学生数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程教师" prop="teacher">
        <el-input
          v-model="queryParams.teacher"
          placeholder="请输入课程教师"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:course:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:course:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:course:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:course:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="courseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="课程id" align="center" prop="id" />
      <el-table-column label="课程名字" align="center" prop="name" />
      <el-table-column label="价格" align="center" prop="price" />
      <el-table-column label="课程简介" align="center" prop="about" />
      <el-table-column label="课程详情" align="center" prop="discroption" />
      <el-table-column label="课节" align="center" prop="lesson" />
      <el-table-column label="课时" align="center" prop="duration" />
      <el-table-column label="最大学生数" align="center" prop="maxStudents" />
      <el-table-column label="课程教师" align="center" prop="teacher" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:course:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:course:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改课程对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程名字" prop="name">
          <el-input v-model="form.name" placeholder="请输入课程名字" />
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="课程简介" prop="about">
          <el-input v-model="form.about" placeholder="请输入课程简介" />
        </el-form-item>
        <el-form-item label="课程详情" prop="discroption">
          <el-input v-model="form.discroption" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="课节" prop="lesson">
          <el-input v-model="form.lesson" placeholder="请输入课节" />
        </el-form-item>
        <el-form-item label="课时" prop="duration">
          <el-input v-model="form.duration" placeholder="请输入课时" />
        </el-form-item>
        <el-form-item label="最大学生数" prop="maxStudents">
          <el-input v-model="form.maxStudents" placeholder="请输入最大学生数" />
        </el-form-item>
        <el-form-item label="课程教师" prop="teacher">
          <el-input v-model="form.teacher" placeholder="请输入课程教师" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCourse, getCourse, delCourse, addCourse, updateCourse } from "@/api/system/course"

export default {
  name: "Course",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 课程表格数据
      courseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        price: null,
        about: null,
        discroption: null,
        lesson: null,
        duration: null,
        maxStudents: null,
        teacher: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "课程名字不能为空", trigger: "blur" }
        ],
        price: [
          { required: true, message: "价格不能为空", trigger: "blur" }
        ],
        about: [
          { required: true, message: "课程简介不能为空", trigger: "blur" }
        ],
        discroption: [
          { required: true, message: "课程详情不能为空", trigger: "blur" }
        ],
        lesson: [
          { required: true, message: "课节不能为空", trigger: "blur" }
        ],
        duration: [
          { required: true, message: "课时不能为空", trigger: "blur" }
        ],
        maxStudents: [
          { required: true, message: "最大学生数不能为空", trigger: "blur" }
        ],
        teacher: [
          { required: true, message: "课程教师不能为空", trigger: "blur" }
        ]
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询课程列表 */
    getList() {
      this.loading = true
      listCourse(this.queryParams).then(response => {
        this.courseList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        price: null,
        about: null,
        discroption: null,
        lesson: null,
        duration: null,
        maxStudents: null,
        teacher: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加课程"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getCourse(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改课程"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCourse(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addCourse(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除课程编号为"' + ids + '"的数据项？').then(function() {
        return delCourse(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/course/export', {
        ...this.queryParams
      }, `course_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
