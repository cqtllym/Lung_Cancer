<style lang="css">
@import "../css/app";
</style>
<template>
    <el-container>
      <!--主要显示栏 -->
      <el-main style="height:700px">
        <div class="block">
          <el-cascader
            v-model="value"
            :options="options"
            ref="first_choose">
          </el-cascader>
          <el-button id="select"  @click="select()">
            select
          </el-button>
        </div>
        <br/>
        <div style="background-color:black;width:1000px;margin:auto">
          <!-- <br/>
          <el-switch
          v-model="value1"
          active-color="#13ce66"
          inactive-color="#ff4949">
          </el-switch> -->
            <div style="width:100%;height:600px;padding:0px;margin:auto">
              <iframe src="../static/openseadragon/svs_files/ceshi.html" style="width:100%;height:100%;border:0px"></iframe>       
            </div>      
        </div>
      </el-main>
  </el-container>

  
</template>
<script>
export default {
  name: "index",
  data () {
    return {
      value1: true,
      imgSrc: '../static/123.png',

      //返回数据
      PatientForm: {
        name: "admin",
        id: "123456"
      },
      
      activeNames: '1',
      value: [],
      options: [
        {
          value: 11,
          label: 'LUAD',
          children: [{
            value: 10000,
            label: "TCGA-97-7938-01"
          }]
        }
        ,
      ],
    }     
  },

  created() {//页面被创建时的操作
    this.getlist();
  },

  methods: {
    getlist(){
       this.$store
            .dispatch("Getlist")
            .then(response => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                alert(response.data.data)
              }
              else if(code==500){
                aler("500");
              }
              else{
                alert("false");
              }
            })
            .catch(() => {
              this.loading = false;
            });
    },

    getmsg(){//为列表添加信息
      this.loading = true;
      this.PatientForm.name = this.$refs.first_choose.getCheckedNodes()[0].data.label;
      this.PatientForm.id = this.$refs.first_choose.getCheckedNodes()[0].data.value;
      this.$store
            .dispatch("Getmsg",this.PatientForm)
            .then(response => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                // alert(response.data.data)
              }
              else if(code==500){
                aler("500");
              }
              else{
                alert("false");
              }
            })
            .catch(() => {
              this.loading = false;
            });
    },
    select() {//
      if(this.$refs.first_choose.getCheckedNodes()!=""){
          this.getmsg();
      }else{
        alert("请选择")
      }
    },
   
  }
}


</script>

