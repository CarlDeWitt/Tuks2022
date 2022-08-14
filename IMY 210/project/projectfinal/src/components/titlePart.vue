<template>
  <div id="title">
    <p id="h1">
        Welcome to CalendarLY
    </p>
    <img src="../images/logo.jpg"/>
    <p id="name">
      {user name}
    </p>
  </div>
  
</template>

<script>
export default {
  name: 'titleComp',
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  #h1{
    font-size: 70px;
    color: #e46924;
  }

  #name{
    color: #e46924;
  }
  img{
    height: 200px;
    border-radius: 40px;
    border-top-left-radius: 0;
  }
  #title{
    display: flex;
    justify-content: space-around;
    align-items: center;
    background-color: #0a305f;
    font-family: good-times;
    text-shadow: 5px 5px 5px black;
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
    #111180 navy
    #f0efee light grey
    #94b6e4 light blue
  */
</style>