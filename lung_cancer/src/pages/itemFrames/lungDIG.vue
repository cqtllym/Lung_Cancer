<style lang="css">
@import "../css/app";
</style>
<template>
    <div class="resultDisplay">
        <br/>
        <div style="margin-right:1000px;font-size:20px;font-weight:Blod;color:#77070d">
          LungDIG
        </div>
        <br/>
          <div style="width:1000px; margin-left:100px">
            Description: LungDIG(Wang, et al. Lung Cancer Subtype Diagnosis by Fusing Image-genomics Data and Hybrid Deep Networks, IEEE/ACM Transactions on Computational Biology and Bioinformatics, 2021) integrates milti-omics data by feature fusion and attention mechanism  to diagnose lung cancer subtypes.
        </div>
        <br/>
        <img v-bind:src=imgSrc  width="60%">
        <br/><br/>
        <div style="margin-right:1000px;font-size:20px;font-weight:Blod;color:#77070d;margin-left:20px;width:200px">
          Data Upload
        </div>
        <div style="width:1100px;height:180px;background-color:white;margin-left:40px;padding-top:10px" class="block">
          <el-form>
            <div style="height:120px;">
              <el-form-item>
                  <el-row>
                    <el-col :span="6" 
                    v-for="(k,v) in uploadarr" 
                    :key="v"
                    >
                      <el-upload
                        refs="upload"
                        action=" "
                        :auto-upload="false"
                        :on-preview="handlePreview"
                        :on-remove="handleRemove"
                        :before-remove="beforeRemove"
                        :on-change="handleChange"
                        multiple
                        :http-request="handleUpload"
                        :limit="1"
                        :on-exceed="handleExceed"
                        :file-list="k"
                        >
                        <span slot="tip" class="el-upload__tip" style="font-size:16px;margin-left:8px">{{v}} Data</span>
                        <el-button type="primary" style="font-size:16px" @click="changeChoose(v)">Document</el-button>
                      </el-upload>
                    </el-col>
                  </el-row>
              </el-form-item>
            </div>
            <div style="height:60px;">
              <el-form-item>
                  <el-button  type="success" @click="upload">Upload</el-button>
              </el-form-item>
            </div>
          </el-form>
        </div>
    </div>
</template>

<script>
export default {
  name: "index",
  data () {
    return {
      imgSrc:"../static/流程图.png",
      DNA:[],
      RNA:[],
      WSI:[],
      CNV:[],
      uploadarr:{"RNA":this.RNA , "DNA":this.DNA, "SNV":this.CNV, "WSI":this.WSI},
      choose:"",
    }
  },
  methods:{
    handleRemove(file, fileList) {
      console.log("remove");
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log("preview");
      console.log(file);
    },
    handleExceed(files, fileList) {
      console.log("exceed");
      this.$message.warning(`The current limit is 1 file, but you select ${files.length} files，and a total of ${files.length + fileList.length} files were selected`);
    },
    beforeRemove(file, fileList) {
      console.log("before remove");
      return this.$confirm(`Sure to remove ${ file.name }？`);
    },
    changeChoose(v){
      this.choose = v;
    },
    handleChange(file, fileList) {
      if(this.choose == "DNA"){
        this.DNA = fileList
      }else if(this.choose == "RNA"){
        this.RNA = fileList
      }else if(this.choose == "WSI"){
        this.WSI = fileList
      }else if(this.choose == "SNV"){
        this.CNV = fileList
      }
      if(file.status === 'ready'){
          this.progressFlag = true; // 显示进度条
          this.loadProgress = 0; 
          const interval = setInterval(() => {
            if(this.loadProgress >=99){
              clearInterval(interval)
              return
            }
            this.loadProgress += 1
            
          }, 20);
      }
      if (file.status === 'success') {
        this.progressFlag = false; // 显示进度条
        this.loadProgress = 100;
      }
    },
    handleUpload(file){
      
    },
    upload(){//为列表添加信息
    const d = new Date()
    let s = `${d.getFullYear()}${d.getMonth()}${d.getDate()-1}${d.getHours()}${d.getMinutes()}${d.getSeconds()}`
    var return_list = {
        kind1:0,
        kind2:0,
        dataPackage:s
      }
      if(this.RNA.length != 0){
        return_list.kind1 = 1;
        let fd =new FormData()
        fd.set("name",s+"&RNA")
        fd.set("files",this.RNA[0].raw)
        this.$store
            .dispatch("Upload",fd)
            .then(response => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                console.log(response.data.data)
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
      }
      if(this.DNA.length != 0){
        return_list.kind1 = 1;
        let fd =new FormData()
        fd.set("name",s+"&DNA")
        fd.set("files",this.DNA[0].raw)
        this.$store
            .dispatch("Upload",fd)
            .then(response => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                console.log(response.data.data)
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
      }
      
      if(this.CNV.length != 0){
        return_list.kind1 = 1;
        let fd =new FormData()
        fd.set("name",s+"&CNV")
        fd.set("files",this.CNV[0].raw)
        this.$store
            .dispatch("Upload",fd)
            .then(response => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                console.log(response.data.data)
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
      }
      if(this.WSI.length != 0){
        return_list.kind2 = 1;
        let fd =new FormData()
        fd.set("name",s+"&WSI")
        fd.set("files",this.WSI[0].raw)
        this.$store
            .dispatch("Upload",fd)
            .then(response => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                console.log(response.data.data)
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
      }
      
      this.$store
            .dispatch("Diagnosis",return_list)
            .then(response => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                console.log(response.data.data)
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
  },
}
</script>