<template>
  <div>
      <button id="Eb" v-on:click="edit" type="submit">Edit</button>
      <button id="Db" v-on:click="del" type="submit">Delete</button>
  </div>
</template>

<script>
export default {
  name: 'editComp',
  methods: {
      edit: function(){
          console.log("edit");
      },
      del: function(){
          console.log("del");
      },
  }
}
</script>
<style scoped>
div{
    margin: 10px 0 0 0;
}

button{
    border: 0;
    margin: 0 10px 0 0;
    padding: 10px;
    border-radius: 40px;
    border-top-left-radius: 0;
     box-shadow: 5px 5px #000000;
      background-color: #e46924;
}

#Eb{
    background-color: #fbc208a1;
}

</style>