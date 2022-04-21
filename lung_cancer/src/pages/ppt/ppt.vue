<style lang="css">
@import "ppt";
</style>

<template>
  <el-container id="container">
    <el-header style="height:60px;">
         Lung Cancer Subtype Intelligent Diagnosis System
    </el-header>
    <el-container>

      <el-aside >
        <el-aside >
            <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
                background-color="white"
                text-color="black"
                active-text-color="#ffd04b"
                >
                <el-menu-item index="1">
                    <i class="el-icon-location"></i>
                    <span>LungDIG</span>
                </el-menu-item>
                <el-menu-item index="2">
                    <i class="el-icon-menu"></i>
                    <span slot="title">ROI Filtering</span>
                </el-menu-item>
                <el-menu-item index="3" >
                    <i class="el-icon-document"></i>
                    <span slot="title">Results Display</span>
                </el-menu-item>
                <el-menu-item index="4">
                    <i class="el-icon-setting"></i>
                    <span slot="title">Self Center</span>
                </el-menu-item>
            </el-menu>
            <div style="height:300px;width:100%"></div>
            <img v-bind:src=imgSrc0  width="45%">
        </el-aside>
      </el-aside>
      <!--主要显示栏 -->
      <el-main>
          <el-table
            :data="tableData"
            style="width: 100%;"
            >
            <el-table-column
                prop="Work_ID"
                label="Work ID"
                width="200px">
            </el-table-column>
            <el-table-column
                prop="Name"
                label="Name"
                width="180px">
            </el-table-column>
            <el-table-column
                prop="Submit_Time"
                label="Submit Time "
                width="200px">
            </el-table-column>
            <el-table-column
                prop="Cancer_Subtypes"
                label="Cancer Subtypes"
                width="200px">
            </el-table-column>
            <el-table-column
                prop="Confidence"
                label="Confidence "
                width="200px">
            </el-table-column>
            <el-table-column
                prop="Results"
                label="Results "
                width="195px">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">Download</el-button>
                </template>
            </el-table-column>
        </el-table>
      </el-main>
      
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
      imgSrc0:'../static/000.png',
      imgSrc: '../static/123.png',
      imgSrc2: '../static/456.png',
      
      //table
     tableData: [{
          Work_ID: '1',
          Name: 'TCGA-2F-A3ED',
          Submit_Time: '01-20-2022',
          Cancer_Subtypes: 'LUAD',
          Confidence: '91.3%',
          Results: 200333
        }, {
          Work_ID: '2',
          Name: 'TCGA-3E-C3BM',
          Submit_Time: '01-23-2022 ',
          Cancer_Subtypes: 'LUAD',
          Confidence: '95.2%',
          Results: 200333
        },{
          Work_ID: '3',
          Name: 'TCGA-BB-1F2D',
          Submit_Time: '01-26-2022',
          Cancer_Subtypes: 'LUSC',
          Confidence: '97.1%',
          Results: 200333
        },{
          Work_ID: '4',
          Name: 'TCGA-AN-COPK',
          Submit_Time: '02-01-2022',
          Cancer_Subtypes: 'LUSC',
          Confidence: '96.4%',
          Results: 200333
        },{
          Work_ID: '5',
          Name: 'TCGA-FK-UNM9',
          Submit_Time: '02-11-2022',
          Cancer_Subtypes: 'LUSC',
          Confidence: '89.3%',
          Results: 200333
        },{
          Work_ID: '6',
          Name: 'TCGA-C0-FFKE',
          Submit_Time: '03-10-2022',
          Cancer_Subtypes: 'LUAD',
          Confidence: '98.9%',
          Results: 200333
        },{
          Work_ID: '7',
          Name: 'TCGA-2F-TTN4',
          Submit_Time: '03-20-2022',
          Cancer_Subtypes: 'LUAD',
          Confidence: '92.6%',
          Results: 200333
        },]
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

