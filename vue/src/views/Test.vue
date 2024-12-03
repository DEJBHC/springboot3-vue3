<template>
  <div>
    <el-button type="primary" @click="router.back()">返回主页</el-button>
  </div>
  <div style="font-size: 20px;font-weight: bold;color: red;text-decoration: underline;font-style: italic;margin-bottom: 20px">
    欢迎大家跟着青哥哥一起学项目，一起提升自己，实现自己从0到1的突破！
  </div>
  <div style="font-size: 30px;margin-bottom: 20px">
    {{a}}  {{b}}
  </div>
  <div style="margin-bottom: 20px">
    {{data.a}}
    {{data.b}}
    {{data.c}}
    {{data.d}}
  </div>
  <div style="margin-bottom: 20px">
    <input v-model="data.a"/>
  </div>
  <div style="margin-bottom:20px">
    <span style="color:red" v-if="data.name ==='佩奇'">小猪佩奇</span>
    <span style="color:blue" v-if="data.name ==='乔治'">小猪乔治</span>
    <span style="color:hotpink" v-else>小猪朵朵</span>
  </div>
  <div style="display:flex; margin-bottom:20px">
    <div @click="show(item)" v-for="item in data.arr" style="width: 300px; height: 300px; text-align: center; line-height: inherit"/>
    <div>
      <select style="width:200px">
        <option v-for="item in data.fruits">{{ item }}</option>
      </select>
    </div>
  </div>
  <div style="margin-bottom:20px">
    <button @click="click">点我加好运</button>
  </div>
  <div style="margin-bottom: 30px">
    <div :style="data.box"></div>
    <div>
      <img :src="data.img" alt="">
    </div>
  </div>
  <div style="margin: 30px">
    <el-button @click="clickData" :style="{color:'red'}">青哥哥</el-button>
    <el-button type="primary" plain size="large">武哥哥</el-button>
    <el-button type="success">小猪佩奇</el-button>
    <el-button type="info">Info</el-button>
    <el-button type="warning">Warning</el-button>
    <el-button type="danger">Danger</el-button>
  </div>
  <div style="margin: 30px">
    <el-icon :size="20">
    <Edit/>
    </el-icon>
    <span style="margin-left:30px;color:#666">
<el-icon :size="20" color="#666" style="top:4px"><View /></el-icon> 100
</span>
    <el-button type="danger" :icon="Delete" circle />
    <el-input
        V-model="data.a"
style="width:240px"
    placeholder="Type something"
    :prefix-icon="Search"/>
  </div>
<!--  </div>-->
</template>
<script setup>
import {onMounted, reactive, ref} from 'vue'
import {Delete, Search} from "@element-plus/icons-vue";
import router from "@/router/index.js";
const a = ref(1)
const b=ref("青哥哥真的很帅")
const data = reactive({
  id:router.currentRoute.value.query.id,
  name1:router.currentRoute.value.query.name,
  a: 123,
  b: "亲哥哥你真的很骚哦",
  c: "1122312313123",
  d: false,
  name: '',
  arr: [7, 8, 9],
  fruits: ['苹果', '香蕉', '橘子'],
  box: {
    width: '100px',
    height: '100px',
    backgroundcolor: 'red'
  },
  img: 'https://www.runoob.com/wp-content/uploads/2017/01/vue.png'
})
console.log('获取到传递过来的id='+data.id)
console.log('获取到传递过来的name='+data.name1)
onMounted(() => {
  console.log('页面加载完成')
})
const clickData =() =>{
  alert("我当前使用的是Element-PLus组件的点击事件")
}
const show=(value) => {
  alert(value)
}
const click=()=> {
  alert("好运+1")
}
</script>