<template>
<div>
    <div style="height:110px;background-color:white;padding-top:10px;padding-right:10px">
        <el-row type="flex">
            <el-col :span="4">
                <div style="margin-top:10px">
                     Learning Rate
                </div>
            </el-col>
            <el-col :span="4">
                <div class="demo-input-suffix">
                    <el-input
                        placeholder="input > 0"
                        v-model="input1">
                    </el-input>
                </div>
            </el-col>
            <el-col :span="4">
                <div style="margin-top:10px">
                     Individual Factor
                </div>
            </el-col>
            <el-col :span="4">
                <div class="demo-input-suffix">
                    <el-input
                        placeholder="-1<= input <=1"
                        v-model="input2" >
                    </el-input>
                </div>
            </el-col>
            <el-col :span="4">
                <div style="margin-top:10px">
                     Batch Size
                </div>
                
            </el-col>
            <el-col :span="4">
                <div class="demo-input-suffix">
                    <el-input
                        placeholder="input > 0"
                        v-model="input3">
                    </el-input>
                </div>
            </el-col>
        </el-row>
        <el-row type="flex">
             <el-col :span="4">
                <div style="margin-top:10px">
                     Latent Space Dim
                </div>
            </el-col>
            <el-col :span="4">
                <div class="demo-input-suffix">
                    
                    <el-input
                        placeholder="input > 0"
                        v-model="input4">
                    </el-input>
                </div>
            </el-col>
             <el-col :span="4">
                <div style="margin-top:10px">
                     Epoch
                </div>
            </el-col>
            <el-col :span="4">
                <div class="demo-input-suffix">
                    <el-input
                        placeholder="input > 0"
                        v-model="input5">
                    </el-input>
                </div>
            </el-col>
            <el-col :span="4">
                <div style="margin-top:10px">
                     Test Size
                </div>
            </el-col>
            <el-col :span="4">
                <div class="demo-input-suffix">
                    <el-input
                        placeholder="0 < input < 1"
                        v-model="input6">
                    </el-input>
                </div>
            </el-col>
        </el-row>
    </div>
    <div>
        <div style="background-color:white;padding-right:10px;margin:0px">
            <el-collapse  style="padding-left:30px">
                <el-collapse-item title="miRNA" name="1">
                   <el-row type="flex">
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Encoder
                            </div>
                        </el-col>
                        <el-col :span="4">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="1881,1000,128"
                                    v-model="input_R1">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Dignosis
                            </div>
                        </el-col>
                        <el-col :span="3">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="128,50,2"
                                    v-model="input_R2">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Generator
                            </div>
                        </el-col>
                        <el-col :span="4">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="128,1000,1881"
                                    v-model="input_R3">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Adversarial
                            </div>
                        </el-col>
                        <el-col :span="5">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="1881,1000,128,50,1"
                                    v-model="input_R4">
                                </el-input>
                            </div>
                        </el-col>
                    </el-row>
                </el-collapse-item>
                <el-collapse-item title="DNA_methylation" name="2">
                    <el-row type="flex">
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Encoder
                            </div>
                        </el-col>
                        <el-col :span="4">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="9816,1000,128"
                                    v-model="input_D1">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Dignosis
                            </div>
                        </el-col>
                        <el-col :span="3">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="128,50,2"
                                    v-model="input_D2">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Generator
                            </div>
                        </el-col>
                        <el-col :span="4">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="128,1000,9816"
                                    v-model="input_D3">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Adversarial
                            </div>
                        </el-col>
                        <el-col :span="5">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="9816,1000,128,50,1"
                                    v-model="input_D4">
                                </el-input>
                            </div>
                        </el-col>
                    </el-row>
                </el-collapse-item>
                <el-collapse-item title="SNP" name="3">
                    <el-row type="flex">
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Encoder
                            </div>
                        </el-col>
                        <el-col :span="4">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="19728,11000,2048,128"
                                    v-model="input_S1">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Dignosis
                            </div>
                        </el-col>
                        <el-col :span="3">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="128,50,2"
                                    v-model="input_S2">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Generator
                            </div>
                        </el-col>
                        <el-col :span="4">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="128,2048,11000,19728"
                                    v-model="input_S3">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Adversarial
                            </div>
                        </el-col>
                        <el-col :span="5">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="19728,11000,2048,128,50,1"
                                    v-model="input_S4">
                                </el-input>
                            </div>
                        </el-col>
                    </el-row>
                </el-collapse-item>
                <el-collapse-item title="WSI" name="4">
                    <el-row type="flex">
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Encoder
                            </div>
                        </el-col>
                        <el-col :span="4">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="2048,1000,128"
                                    v-model="input_W1">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Dignosis
                            </div>
                        </el-col>
                        <el-col :span="3">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="128,50,2"
                                    v-model="input_W2">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Generator
                            </div>
                        </el-col>
                        <el-col :span="4">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="128,1000,2048"
                                    v-model="input_W3">
                                </el-input>
                            </div>
                        </el-col>
                        <el-col :span="2">
                            <div style="margin-top:10px">
                                Adversarial
                            </div>
                        </el-col>
                        <el-col :span="5">
                            <div class="demo-input-suffix">
                                
                                <el-input
                                    placeholder="2048,1000,128,50,1"
                                    v-model="input_W4">
                                </el-input>
                            </div>
                        </el-col>
                    </el-row>
                </el-collapse-item>
                </el-collapse>
        </div>
        <div>
            <el-button type="primary" style="font-size:16px;width:200px;margin-top:5px" @click="submit()">train</el-button>
        </div>
    </div>
        
</div>
    
</template>
<script>
export default {
  data() {
    return {
      input1: '',
      input2: '',
      input3: '',
      input4: '',
      input5: '',
      input6: '',
      input_R1:'',
      input_R2:'',
      input_R3:'',
      input_R4:'',

      input_D1:'',
      input_D2:'',
      input_D3:'',
      input_D4:'',

      input_S1:'',
      input_S2:'',
      input_S3:'',
      input_S4:'',

      input_W1:'',
      input_W2:'',
      input_W3:'',
      input_W4:'',
    }
  },
  methods:{
      submit(){
            let the_list =
                "learing_rate:"+this.input1+"&"+
                "individual_factor:"+this.input2+"&"+
                "batch_size:"+this.input3+"&"+
                "latent_space_dim:"+this.input4+"&"+
                "epoch:"+this.input5+"&"+
                "test_size:"+this.input6+"&"+
                "miRNA_econder:"+this.input_R1+"&"+
                "miRNA_dignosis:"+this.input_R2+"&"+
                "miRNA_generator:"+this.input_R3+"&"+
                "miRNA_adversarial:"+this.input_R4+"&"+
                "dna_methylation_econder:"+this.input_D1+"&"+
                "dna_methylation_dignosis:"+this.input_D2+"&"+
                "dna_methylation_generator:"+this.input_D3+"&"+
                "dna_methylation_adversarial:"+this.input_D4+"&"+
                "snp_econder:"+this.input_S1+"&"+
                "snp_dignosis:"+this.input_S2+"&"+
                "snp_generator:"+this.input_S3+"&"+
                "snp_adversarial:"+this.input_S4+"&"+
                "wsi_econder:"+this.input_W1+"&"+
                "wsi_dignosis:"+this.input_W2+"&"+
                "wsi_generator:"+this.input_W3+"&"+
                "wsi_adversarial:"+this.input_W4
            this.$store
                .dispatch("Dynamic",the_list)
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
  }
}
</script>