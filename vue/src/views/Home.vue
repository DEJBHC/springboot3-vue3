<template>
  <div style="margin-bottom:20px">
    <RouterLink to="/test">通过router跳转到Test.vue</RouterLink> |
    <a href="/test">通过a标签跳转到Test.vue</a>
  </div>
  <div style="margin-bottom:20px">
    <el-button type="primary" @cLick="router.push('/test')">push跳转到新的test页面</el-button> |
    <el-button type="primary" @click="router.replace('/test')">replace跳转到新的test页面</el-button>

  </div>
  <div style="margin-bottom:20px">
    <el-button type="primary" @click="router.push('/test?id=2&name=青哥哥')">路由传参id=1</el-button> |
    <el-button type="primary" @click="router.push({path:'/test',query:{id:2,name:'青哥哥'}})">路由传参id=1</el-button>

  </div>
  <div style="margin-bottom: 20px">
    <el-input v-model="data.input" style="width: 240px" disabled placeholder="请输入内容" :prefix-icon="Search"/> {{data.input}}
    <el-input style="width: 200px" :suffix-icon="Calendar"></el-input>
    <el-input type="textarea" v-model="data.descr" style="width:300px" placeholden="请输入一段描述"></el-input>
  </div>
  <div style="margin:20px 0">
    <el-select
        clearable
        multiple
        vaLue-key="id"
        v-model="data.value"
        placeholder="请选择水果"
        style="width:240px">
    <el-option
        v-for="item in data.options"
        :key="item.id"
        :label="item.label"
        :value="item.name"/>
    </el-select>{{ data.value }}
</div>
  <div style="margin:20px 0">
    <el-radio-group v-model="data.sex">
      <el-radio value="男">男</el-radio>
      <el-radio value="女">女</el-radio>
    </el-radio-group><span style="margin-left:50px">{{ data.sex }}</span>
    <el-radio-group style="margin-left:100px" v-model="data.tag" size="large">
      <el-radio-button label="我发布的内容" value="1"/>
      <el-radio-button label="我点赞的内容" value="2"/>
      <el-radio-button label="我收藏的内容" value="3"/>
    </el-radio-group>
  </div>
  <div style="margin:20px 0">
    <el-checkbox-group v-model="data.checkList">
      <el-checkbox v-for="item in data.options" :key="item.id" :value="item.name" :label="item.label"/>
    </el-checkbox-group>
    <span style="margin-left:20px">{{ data.checkList }}</span>
  </div>
  <div style="margin:20px 0">
    <img src="@/assets/logo.svg" alt="" style="width: 100px">
    <el-image :src="img" style="width: 100px;margin-left: 100px" :preview-src-list="[img,'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg','https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg']"/>
</div>
  <div style="margin:20px 0">
    <el-carousel height="400px" style="width:550px">
      <el-carousel-item v-for="item in data.imgs" :key="item">
        <img style="width:100%;height:400px" :src="item" alt="">
      </el-carousel-item>
    </el-carousel>
  </div>
  <div style="margin:20px 0">
    <el-date-picker
        style="margin-left: 50px"
        v-model="data.date"
        type="date"
        placehoLder="请选择日期"
        format="YYYY-MM-DD"
        value-format="YYYY-MM-DD"
    />{{data.date}}
    <el-date-picker
      style="margin-left: 50px"
      v-model="data.date1"
      type="datetime"
      placehoLder="请选择日期时间"
      format="YYYY-MM-DD HH:mm:ss"
      value-format="YYYY-MM-DD HH:mm:ss"
  />{{data.date1}}
    <el-date-picker
        style="margin-left: 50px"
        v-model="data.time"
        type="datetime"
        placehoLder="请选择时间"
        format="HH:mm:ss"
        value-format="HH:mm:ss"
    />{{data.time}}
    <el-date-picker
        style="margin-left: 50px"
        v-model="data.daterange"
        type="daterange"
        range-separator="至"
        start-placehoLder="开始日期"
        end-placeholder="结束日期"
        format="YYYY-MM-DD"
        value-format="YYYY-MM-DD"
    />{{ data.daterange?.length?data.daterange[0]:''}} {{data.daterange?.length?data.daterange[1]:''}}
  </div>
  <div style="margin:20px 0">
    <el-table :data="data.tableData" style="width:100%" stripe border>
      <el-table-column prop="date" label="日期" width="180"/>
      <el-table-column prop="name" label="名称" width="180"/>
      <el-table-column prop="address" label="地址"/>
      <el-table-column prop="content" label="内容">
        <template #default="scope">
          <div v-html="scope.row.content"></div>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="primary" @click="editContent(scope.row)">
            编辑富文本
          </el-button>
          <el-button type="primary" circle @click="edit(scope.row)">
            <el-icon><Edit /></el-icon>
          </el-button>
          <el-button type="danger" circle @click="del(scope.row.id)">
            <el-icon><Delete /></el-icon>
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin:20px 0">
      <el-pagination
          v-model:current-page="data.currentPage"
          v-model:page-size="data.pageSize"
          :page-sizes="[5,10,15,20]"
          background
          layout="total, sizes, prev, pager, next, jumper"
          :total="19"
      />
    </div>
  </div>
  <div style="margin:20px 0">
    <el-dialog v-model="data.dialogVisible" title="编辑行对象" width="500">
      <div style="padding:20px">
        <div style="margin-bottom:10px">日期:{{ data.row.date }}</div>
        <div style="margin-bottom:10px">名称:{{ data.row.name }}</div>
        <div>地址:{{ data.row.address }}</div>
      </div>
    </el-dialog>

    <el-dialog v-model="data.formContentVisible" title="编辑内容" width="500">
      <div style="padding: 20px">
        <div style="border: 1px solid #ccc; width: 100%">
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
            @on-created="handleCreated"
          />
        </div>
      </div>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="data.formContentVisible = false">取 消</el-button>
          <el-button type="primary" @click="saveContent">保 存</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { ref } from 'vue';
import { ElDialog, ElButton } from 'element-plus';
// import Toolbar from './components/Toolbar.vue'; // 确保路径正确
// import Editor from './components/Editor.vue'; // 确保路径正确

const data = ref({
  form: {
    content: '' // 初始化 content
  },
  formContentVisible: false
});

const editorRef = ref(null);
const mode = ref('default'); // 根据实际情况设置模式
const editorConfig = ref({}); // 根据实际情况设置配置

const handleCreated = (editor) => {
  // 处理编辑器创建事件
  editorRef.value = editor;
};

const saveContent = () => {
  // 保存内容的逻辑
  console.log(data.value.form.content);
  data.value.formContentVisible = false;
};
</script>

<style scoped>
.dialog-footer {
  display: flex;
  justify-content: flex-end;
}
</style>

<script setup>
import img from '@/assets/logo.svg'
import lun1 from '@/assets/lun1.png'
import lun2 from '@/assets/lun2.png'
import lun3 from '@/assets/lun3.png'
import {reactive} from 'vue'
import {Calendar, Search} from "@element-plus/icons-vue";
import router from "@/router/index.js";
import request from "@/utils/requests.js";
import '@wangeditor/editor/dist/css/style.css'// 引l入 css
import {onBeforeUnmount,ref,shallowRef} from "vue";
import {Editor,Toolbar} from '@wangeditor/editor-for-vue'
const data=reactive({
  input:'青哥哥棒棒哒',
  descr:'用于输入多行文本信息可缩放的输入框。添加 type="textarea"属性来将 input 元素转换为原生的textarea 元素。用于输入多行文本信息可缩放的输入框。添加 type="textarea"属性来将 input 元素转换为原生的textarea 元素。',
  options:[{id:1,label:'苹果',name:'苹果1'},
           {id:2,label:'香蕉',name:'香蕉'},
           {id:3,label:'桃子',name:'桃子'},
           {id:4,label:'苹果',name:'苹果2'},],
  sex:'男',
  tag:'1',
  checkList:[],
  imgs:[lun1,lun2,lun3],
  date:'',
  date1:'',
  time:'',
  daterange:null,
  tableData:[
    {date:'2024-10-11',name:'亲哥哥哥',address:'安徽合肥',content:'<h1>哈哈哈</h1>'},
    {date:'2024-10-12',name:'小鲁班',address:'上海浦东'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
    {date:'2024-10-13',name:'小姐己',address:'北京大兴'},
  ],
  currentPage:1,
  pageSize:5,
  dialogVisible: false,
  row: null,
  employeeList: [],
  formContentVisible: false,
  form:{}
})
request.get('employee/selectAll').then(res=>{
  console.log(res)
  console.log(res.data)
  data.employeeList=res.data
})
const del =(id)=>{
  alert("删除ID="+id+"的数据")
}
const edit =(row) =>{
  data.row=row
  data.dialogVisible = true
}
data.tableData =data.tableData.splice(0,5)//假数据处理
const editContent =(row) =>{
  data.form = JSON.parse(JSON.stringify(row))
  data.formContentVisible = true
}
/*wangEditor5初始化开始*/
// const baseUrl='http://localhost:9090'
const editorRef=shallowRef()//编辑器实例，必须用shallowRef
const mode='default'
const editorConfig={MENU_CONF:{}}
// //图片上传配置
// editorConfig.MENU_CONF['uploadImage']= {
//   server: baseUrl + '/files/wang/upload',//服务端图片上传接口
//   fieldName: 'file'
// }//服务端图片上传接口参数
//组件销毁时，也及时销毁编辑器，否则可能会造成内存泄漏
onBeforeUnmount(() =>{
  const editor = editorRef.value
  if (editor == null) return
  editor.destroy()
})
//记录editor实例，重要！
const handleCreated=(editor)=> {
  editorRef.value = editor
}
/*wangEditor5初始化结束*/
</script>