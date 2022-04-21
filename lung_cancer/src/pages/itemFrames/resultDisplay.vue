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
</template>
<script>
export default {
  name: "index",
  data () {
    return {
      
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
}
</script>