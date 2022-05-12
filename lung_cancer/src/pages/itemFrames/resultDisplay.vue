<style lang="css">
@import "../css/app";
</style>
<template>
    <el-table
    :data="tableData"
    style="width: 100%;"
    >
        <el-table-column
            prop="Work_ID"
            label="Work ID"
            width="150px">
        </el-table-column>
        <el-table-column
            prop="Name"
            label="Name"
            width="150px">
        </el-table-column>
        <el-table-column
            prop="Submit_Time"
            label="Submit Time "
            width="180px">
        </el-table-column>
        <el-table-column
            prop="Submit_File"
            label="Submit_File "
            width="120px">
        </el-table-column>
        <!-- <el-table-column
            prop="Complite_Diagnosis"
            label="Complite_Diagnosis"
            width="160px">
        </el-table-column> -->
        <el-table-column
            prop="Cancer_Subtypes"
            label="Cancer Subtypes"
            width="150px">
        </el-table-column>
        <el-table-column
            prop="Confidence"
            label="Confidence "
            width="150px">
        </el-table-column>
        <el-table-column
            prop="Interpretable_information"
            label="Interpretable Information "
            width="240px">
            <template slot-scope="scope">
              <el-button type="success" href='javascript:void(0)' @click="handleClick(scope.row.Work_ID,scope.row.Name)" :disabled="check_exist(scope.row.Results)">Download</el-button>
            </template>
            
        </el-table-column>
    </el-table>
</template>
<script>
export default {
  name: "index",
  data () {
    return {
      
      //table
     tableData: [
      //  {
      //     Work_ID: '1',
      //     Name: 'TCGA-2F-A3ED',
      //     Submit_Time: '01-20-2022',
      //     Submit_File: 'R D S W',
      //     Complite_Diagnosis: 'R D S W',
      //     Cancer_Subtypes: 'LUAD',
      //     Confidence: '91.3%',
      //     Results: 200333,
      //     is_show:false
      //   }, 
        ]
    }     
  },

  created() {//页面被创建时的操作
    this.getdownloadlist();
  },

  mounted(){
    setInterval(() => {
      this.getdownloadlist();
    }, 1000 * 5 * 60);
  },
  methods:{
    getdownloadlist(){
      // console.log(1)
      this.$store
            .dispatch("GetDownloadList")
            .then(response => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                this.theMsg(response.data.data)
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

    check_exist(src){
      if(src != null){
        return false;
      }
      return true;
    },
    show_href(src){
      var temp = src.split()
      is_show = false;
      for(i in temp){
        if(i == "W"){
          is_show = ture
        }
      }
    },

    theMsg(src){
      var items = [];
      for(var obj in src){
        var item = new Object;
        var sf = "";
        var cd = "";
        var is_show = false;
        if(src[obj].s_RNA != null){ sf += "R ";}
        if(src[obj].s_DNA != null){ sf += "D ";}
        if(src[obj].s_CNV != null){ sf += "S ";}
        if(src[obj].s_WSI != null){ 
          sf += "W ";
        }
        if(src[obj].rna != null){ cd += "R ";}
        if(src[obj].dna != null){ cd += "D ";}
        if(src[obj].cnv != null){ cd += "S ";}
        if(src[obj].wsi != null){ cd += "W ";}
        if(sf == cd){
          item = {
            Work_ID: src[obj].id,
            Name: src[obj].name,
            Submit_Time: src[obj].submit,
            Submit_File: sf,
            Complite_Diagnosis: cd,
            Cancer_Subtypes: src[obj].result,
            Confidence: src[obj].confidence,
            Results: src[obj].download,
          }
          items.push(item);
        }
      }
      this.tableData = items
    },

    handleClick(src,src2){
      let filePath = src + ".xlsx"
      this.$store
            .dispatch("GetResult",filePath)
            .then(data => {
              if(!data){
                return
              }
              let url = window.URL.createObjectURL(data.data)
              let link = document.createElement('a')
              link.style.display = 'none'
              link.href = url
              // 获取文件名
              let fileName = src2 + ".xlsx"
              // download 属性定义了下载链接的地址而不是跳转路径
              link.setAttribute('download', fileName)
              document.body.appendChild(link)
              link.click()
            } 
            )
            .catch(() => {
              this.loading = false;
            });
    }
  }
}
</script>