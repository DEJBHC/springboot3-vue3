<script setup>
import {reactive} from "vue";
import request from "@/utils/requests.js";
const data = reactive({
  title: '',
  pageNum: 1,
  pageSize: 10,
  total: 0,
  tableData: [],

})
const toLogin=()=>{
  window.location.href='/login'
}
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

</script>

<template>
<div class="card" style="margin-bottom: 5px">
<p style="font-size: 25px;color: red;font-style: italic;">文章管理系统</p>
</div>
  <div class="card" style="margin-bottom: 5px">
    <div class="card" style="margin-bottom: 5px">
      <el-row :gutter="20">
        <el-col
            v-for="(cell, index) in data.tableData"
            :key="index"
            :span="8"
        >
          <el-card>
            <div slot="header" class="clearfix">
              <span>{{ cell.title }}</span> <!-- 使用cell对象的title属性作为标题 -->
            </div>
            <div class="card-content">
              <img :src="cell.img" :alt="cell.description" class="card-image"> <!-- 使用cell对象的img属性作为图片源，description属性作为alt文本 -->
              <p class="card-description">{{ cell.description }}</p> <!-- 使用cell对象的description属性作为描述 -->
            </div>
            <div class="card-footer">
              <el-button type="primary" @click="toLogin">Read More</el-button>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
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
</template>

<style scoped>
.card-image {
  width: 100%;
  height: auto;
  display: block;
}

.el-card__header {
  text-align: center;
  font-size: 16px;
  font-weight: bold;
}
</style>