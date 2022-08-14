<template>
<div>
  
  <button v-on:click="GR">Get</button>
  <titleDoc/>
  <display/>
  <create/>
</div>
</template>

<script>
import titleDoc from './titlePart.vue'
import display from './display.vue'
import create from './create.vue'

export default {
  name: 'HelloWorld',
  components: {
    titleDoc,
    display,
    create,
  },
  props: {
    msg: String
  },methods: {
     GR: function(){
        fetch("https://localhost:3001/")
        .then(async response => {
            console.log(response);
        });
      },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
