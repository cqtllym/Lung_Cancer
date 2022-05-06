<style lang="css">
@import "/pages/css/app";
</style>
<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin:0px;
  }
</style>

<template>
  <div id="app">
      <el-container id="container">
    <el-header style="height:60px;">
         Lung Cancer Subtype Intelligent Diagnosis System
    </el-header>
    <el-container>

      <el-aside >
        <el-aside >
            <el-menu
                :default-active="navList[0].name"
                class="el-menu-vertical-demo"
                background-color="white"
                text-color="black"
                active-text-color="#ffd04b"
                >
                <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name" @click="link(item)">
                  <template slot="title">
                    <i :class='item.iclass'></i>
                    <span> {{ item.navItem }}</span>
                  </template>
          
                </el-menu-item>
            </el-menu>
            <div style="height:300px;width:100%"></div>
            <img v-bind:src=imgSrc  width="45%">
        </el-aside>
      </el-aside>
      <!--主要显示栏 -->
      <el-main >
         <router-view/>
      </el-main>
      
    </el-container>
    <!--底下信息介绍 -->
    <el-footer height="140px">
      <!-- <h1>made by 罗艺铭</h1> -->
    </el-footer>
  </el-container>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() { 
    return { 
      //实验室图片
      imgSrc:'../static/实验室图标.png',
      navList:[ 
        {name:'/',navItem:'LungDIG',iclass:'el-icon-location'}, 
        {name:'/roiFlitering',navItem:'ROI Filtering',iclass:'el-icon-menu'},
        {name:'/resultDisplay',navItem:'Results Display',iclass:'el-icon-document'}, 
        // {name:'/selfCenter',navItem:'Self Center',iclass:'el-icon-setting'}, 
      ] 
    } 
  },
  methods:{
    link(item){
      this.$router.push({path: item.name}) 
    }
  }
  
}
</script>


