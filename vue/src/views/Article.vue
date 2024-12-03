<template>
  <div>
    <div class="card" style="margin-bottom: 5px">
      <el-input style="width: 240px; margin-right: 10px" v-model="data.title"  placeholder="请输入标题查询" prefix-icon="Search"></el-input>
        <el-button type="primary" @click="load">查 询</el-button>
        <el-button type="warning" @click="reset">重 置</el-button>
    </div>
    <div class="card" style="margin-bottom: 5px">
      <el-button type="primary" @click="handleAdd">新 增</el-button>
      <el-button type="danger" @click="handleDeleteBatch(data.ids)">批量删除</el-button>
<!--      <el-button type="info">导 入</el-button>-->
<!--      <el-button type="success">导 出</el-button>-->
    </div>
    <div class="card" style="margin-bottom: 5px">
      <el-table :data="data.tableData" stripe @selection-change="handleSelectionChange">
        <el-table-column type="selection" :selectable="selectable" width="55"/>
        <el-table-column label="标题" prop="title"/>
        <el-table-column label="封面">
          <template #default="scope">
            <img v-if="scope.row.img"  :src="scope.row.img" alt="" :preview-src-list=[scope.row.img] preview-teleported style="display: block; width: 40px; height: 40px" />
          </template>
        </el-table-column>
        <el-table-column label="简介" prop="description" show-overflow-tooltip/>
        <el-table-column label="内容">
          <template #default="scope">
            <el-button type="primary" @click="view(scope.row.content)">查看内容</el-button>
          </template>
        </el-table-column>
        <el-table-column label="发布时间" prop="time"/>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button @click="handleUpdate(scope.row)" type="primary" :icon="Edit" circle></el-button>
            <el-button @click="handleDelete(scope.row.id)" type="danger" :icon="Delete" circle></el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin-top: 10px">
        <el-pagination
            @size-change="load"
            @current-change="load"
            v-model:current-page="data.pageNum"
            v-model:page-size="data.pageSize"
            :page-sizes="[5,10,15,20]"
            background
            layout="total, sizes, prev, pager, next, jumper"
            :total="data.total"
            />
      </div>
    </div>
    <el-dialog title="文章信息" v-model="data.formVisible" width="50%" destory-on-close>
      <el-form ref="formRef" :model="data.form" label-width="80px" style="padding-right: 40px;padding-top:20px">
        <el-form-item label="标题" prop="title">
          <el-input  v-model="data.form.title" autocomplete="off" placeholder="请输入标题"/>
        </el-form-item>
        <el-form-item label="封面" prop="img">
          <el-upload
              action="http://localhost:9090/files/upload"
              list-type="picture"
              :on-success="handleImgSuccess"
          >
            <el-button type="primary">上传封面</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item label="简介" prop="description">
          <el-input type="textarea" :rows="3" v-model="data.form.description" autocomplete="off" placeholder="请输入简介" />
        </el-form-item>
        <el-form-item label="内容" prop="content">
          <div style="border: 1px soid #ccc; width: 100%">
            <Toolbar
                style="border-bottom: 1px solid #ccc"
                :editor="editorRef"
                :mode="mode"
                />
            <Editor
                style="height: 500px; overflow-y: hidden;"
                v-model="data.form.content"
                :mode="mode"
                :defaultConfig="editorConfig"
                @onCreated="handleCreated"
                />
          </div>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="data.formVisible = false">取 消</el-button>
          <el-button type="primary" @click="save">保 存</el-button>
        </div>
      </template>
    </el-dialog>
    <el-dialog title="内容" v-model="data.viewVisible" width="50%" :close-on-click-modal="false" destroy-on-close>
      <div class="editor-content-view" style="padding: 20px" v-html="data.content"></div>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="data.viewVisible=false">关闭</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>
<script setup>
import { reactive,ref } from "vue";
import {Delete, Edit, Search} from "@element-plus/icons-vue"
import request from "@/utils/requests.js";
import {ElMessage, ElMessageBox} from 'element-plus'
import '@wangeditor/editor/dist/css/style.css'// 引l入 css
import {onBeforeUnmount,shallowRef} from "vue"
import '@/assets/view.css'
import  {Editor,Toolbar} from '@wangeditor/editor-for-vue'
/*wangEditor5初始化开始*/
const baseUrl ='http://localhost:9090'
const editorRef=shallowRef()//编辑器实例，必须用shaLLowRef
const mode ='default'
const editorConfig ={ MENU_CONF:{ }}
//图片上传配置
editorConfig.MENU_CONF['uploadImage'] = {
  server: baseUrl + '/files/wang/upload',//服务端图片上传接口
  fieldName: 'file'//服务端图片上传接口参数
}
//组件销毁时，也及时销毁编辑器，否则可能会造成内存泄漏
onBeforeUnmount( () => {
  const editor = editorRef.value
  if (editor == null) return
  editor.destroy()
})
//记录 editor 实例，重要！
const handleCreated =(editor) => {
  editorRef.value = editor
}
    /*wangEditor5初始化结束*/
const view =(content) => {
  data.content = content
  data.viewVisible = true
}
const data = reactive({
  title: null,
  tableData:[],
  pageNum: 1,
  pageSize: 10,
  total:0,
  formVisible:false,//控制表单的显示与隐藏
  form:{},
  ids:[],
  viewVisible:false,
  content: null
})

const load = () => {
  request.get('/article/selectPage', {//?pageNum=1&pageSize=10
    params: {
      title:data.title,
      pageNum: data.pageNum,
      pageSize: data.pageSize
    }
  }).then(res=>{
    data.tableData=res.data.list
    data.total=res.data.total
  })
}
load()
const handleImgSuccess = (res) =>{
  data.form.img = res.data
}
const reset=()=>{
  data.title=null
  load()
}
const handleAdd=()=>{
  data.formVisible=true
  data.form={}
}

const update=()=> {
  request.put( '/article/update', data.form).then(res => {
    if (res.code === '200') {
      data.formVisible=false
      ElMessage.success('操作成功')
      load()//新增后一定要重新加载最新的数据
    } else {
      ElMessage.error(res.msg)
    }
  })
}

const save=()=>{//在一个保存方法里面做2个操作 一个是新增 一个是编辑
  data.form.id ? update() : add()
}
const add=()=> {
  console.log(data.form)
  request.post( '/article/add', data.form).then(res => {
    if (res.code === '200') {
      data.formVisible=false
      ElMessage.success('操作成功')
      load()//新增后一定要重新加载最新的数据
    } else {
      ElMessage.error(res.msg)
    }
  })
}
const handleUpdate=(row)=>{
  data.form=JSON.parse(JSON.stringify(row))//深拷贝一个新的对象 用于编辑 这样就不会影响行对象
  data.formVisible = true
}
const handleDelete=(id)=>{
  ElMessageBox.confirm('删除数据后无法恢复，您确认删除吗？','删除确认',{type:'warning'}).then(()=>{
    request.delete( '/article/deleteById/' +id).then(res => {
      if (res.code === '200') {
        ElMessage.success('操作成功')
        load()//删除后一定要重新加载最新的数据
      }else{
        ElMessage.error(res.msg)
      }
    })
  }).catch()

}
const handleSelectionChange =(rows)=> {// 返回所有选中的行对象数组
//从选中的行数组里面取出所有行的id组成一个新的数组
  data.ids = rows.map(row => row.id)
  console.log(data.ids)
}
const handleDeleteBatch=(ids)=>{
  if (data.ids.length === 0) {
    ElMessage.warning('请选择数据')
    return
  }
  ElMessageBox.confirm('删除数据后无法恢复，您确认删除吗？','删除确认',{type:'warning'}).then(()=>{
    request.delete( '/article/deleteBatch', { data: data.ids }).then(res => {
      if (res.code === '200') {
        ElMessage.success('操作成功')
        load()//删除后一定要重新加载最新的数据
      } else {
        ElMessage.error(res.msg)
      }
    })
  }).catch()
}
</script>
<style scoped>

</style>