<template>
    <div id="around">

        <h1>EVENTS</h1>
    <div id="disp">
        <block/>
    </div>
    </div>
</template>

<script>
import block from './block.vue'
export default {
  name: 'displayComp',
  components: {
   block
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#disp{
    /* background-color:#f0efee ; */
    background-image: url(../images/bk2.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment: fixed;
    display: flex;
    justify-content: center;
}
h1{
    font-family: good-times;
    font-size: 35px;
    color: #0a305f;
    margin: 0;
    padding: 10px;
}
#around{
    background-color: #f0efee;
    
}

@font-face {
  font-family: good-times;
  src: url("https://use.typekit.net/af/5dc877/000000000000000077359689/30/l?primer=7cdcb44be4a7db8877ffa5c0007b8dd865b3bbc383831fe2ea177f62257a9191&fvd=n5&v=3")
      format("woff2"),
    url("https://use.typekit.net/af/5dc877/000000000000000077359689/30/d?primer=7cdcb44be4a7db8877ffa5c0007b8dd865b3bbc383831fe2ea177f62257a9191&fvd=n5&v=3")
      format("woff"),
    url("https://use.typekit.net/af/5dc877/000000000000000077359689/30/a?primer=7cdcb44be4a7db8877ffa5c0007b8dd865b3bbc383831fe2ea177f62257a9191&fvd=n5&v=3")
      format("opentype");
  font-display: auto;
  font-style: normal;
  font-weight: 500;
  font-stretch: normal;
}
     /* #e46924 orange
    #0a305f navy
    #f0efee light grey
    #94b6e4 light blue
  */
</style>