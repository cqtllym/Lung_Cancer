<style lang="css">
@import "index";
</style>

<template>
  <el-container id="container">
    <el-container>
       <!--功能栏 -->
      <el-aside >
        <el-collapse v-model="activeNames" @change="handleChange" accordion="true"><!-- 此处级联选择器后续改为动态加载 -->
          <el-collapse-item name="1">
            <template slot="title">
              <div style="width: 100%; font-size:18px">
                <p align="center">
                  已有信息
                </p>
              </div>
            </template>

            <div class="block">
              <span class="demonstration" style="font-size:16px">肺癌亚型及相应病例选择</span>
              <el-cascader
                v-model="value"
                :options="options"
                @change="handleChange"
                ref="first_choose">
              </el-cascader>
            </div>
            <br>
            <el-button id="select"  @click="addTab(editableTabsValue)">
              查看
            </el-button>
          </el-collapse-item>
          <el-collapse-item name="2" >
            <template slot="title">
              <div class="elco_title" style="width: 100%; font-size:18px">
                <p align="center">
                  信息插入
                </p>
              </div>
            </template>
            <div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
            <div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
          </el-collapse-item>
          
        </el-collapse>
      </el-aside>
      <!--主要显示栏 -->
      <el-main>
        
        <el-tabs v-model="editableTabsValue" type="card" closable tab-click @tab-remove="removeTab">
          <el-tab-pane class="el-tabs"
            v-for="item in editableTabs"
            :key="item.name"
            :label="item.title"
            :name="item.name"
          > 
          <div style="width:100%">
            <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
              详情
            </el-button>
            <el-switch
              v-model="value"
              active-color="#13ce66"
              inactive-color="#ff4949">
            </el-switch>
          </div>
          <br/>
          <div style="width:100%">
           <img v-bind:src=imgSrc width="45%">
           <img v-bind:src=imgSrc2 width="45%">
          </div>
          </el-tab-pane>
        </el-tabs>
      </el-main>
      <el-drawer
        title="病例信息展示"
        :visible.sync="drawer"
        size="25%">
        <el-table :data="gridData">
          <el-table-column property="date" label="项目" width="150"></el-table-column>
          <el-table-column property="name" label="信息" width="200"></el-table-column>
        </el-table>
      </el-drawer>
      
    </el-container>
    <!--底下信息介绍 -->
    <el-footer height="240px">
      
    </el-footer>
  </el-container>

  
</template>

<script>
export default {
  name: "index",
  data () {
    return {
      //图片
      imgSrc: '../static/123.png',
      imgSrc2: '../static/456.png',
      
      //抽屉
      drawer: false,
      gridData: [{
        date: '探针位点',
        name: '',
      }, {
        date: '探针表达值',
        name: '',
      }, {
        date: '基因位点',
        name: '',
      }],

      //查询数据
      PatientForm: {
        name: "admin",
        id: "123456"
      },

      activeNames: '1',
      value: [],
      options: [
        {
          value: 11,
          label: '肺腺癌(LUAD)',
          children: [{
            value: 10000,
            label: '案例10000'
          },{
            value: 10001,
            label: '案例10001'
          }]
        }
        ,{
          value: 22,
          label: '肺鳞癌(LUSC)',
          children: [{
            value: 10000,
            label: '案例20000'
          },{
            value: 10001,
            label: '案例20001'
          }]
        },
        {
          value: 33,
          label: '小细胞未分化癌',
          children: [{
            value: 10000,
            label: '案例30000'
          },{
            value: 10001,
            label: '案例30001'
          }]
        }
      ],

      url: "static/ceshi.html",


      editableTabsValue: '0',//标签页返回信息
        editableTabs: [],
        tabIndex: 0
    }     
  },

  created() {//页面被创建时的操作
    
  },

  methods: {
    getmsg(){//为左侧列表添加信息
      this.loading = true;
      this.PatientForm.name = this.$refs.first_choose.getCheckedNodes()[0].data.label;
      this.PatientForm.id = this.$refs.first_choose.getCheckedNodes()[0].data.value;
      this.$store
            .dispatch("Getlist",this.PatientForm)
            .then(response => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                const nodeContent = this.$refs.first_choose.getCheckedNodes()[0].data.label;
                let newTabName = ++this.tabIndex + '';
                this.editableTabs.push({
                  title: nodeContent, 
                  name: newTabName,
                  content: response.data.data
                });
                this.editableTabsValue = newTabName;
              }
              else if(code==500){
                aler("500");
              }
              else{
                // this.$router.push({
                //   path: "/error",
                //   query: { message: response.data.message }
                // });
                alert("false");
              }
            })
            .catch(() => {
              this.loading = false;
            });
    },
    
    addTab(targetName) {//
      if(this.$refs.first_choose.getCheckedNodes()!=""){
          this.getmsg();
      }else{
        alert("请选择")
      }
    },

    removeTab(targetName) {//删除标签页
      let tabs = this.editableTabs;
      let activeName = this.editableTabsValue;
      if (activeName === targetName) {
        tabs.forEach((tab, index) => {
          if (tab.name === targetName) {
            let nextTab = tabs[index + 1] || tabs[index - 1];
            if (nextTab) {
              activeName = nextTab.name;
            }
          }
        });
      }
      
      this.editableTabsValue = activeName;
      this.editableTabs = tabs.filter(tab => tab.name !== targetName);
    },
  }
}


</script>

