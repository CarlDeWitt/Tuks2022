<template>
    <div id="create">
        <button v-on:click="tog" id="pop" >
            Create
        </button>
        <div id="inputs" class="nodisp" >
            Name: <input type="text" id="name" placeholder="Name here"/>
            EventID: <input type="text" id="evid" placeholder="eg. imy2312"/>
            Title: <input type="text" id="tit" placeholder="Title here"/>
            Date: <input type="date" id="date" placeholder="Name here"/>
            Start Time: <input type="time" id="strTime" placeholder="3:30/pm"/>
            End time: <input type="time" id="endTime" placeholder="3:30/am"/>
            Venue: <input type="text" id="ven" placeholder="Venue here"/>
            Description: <input type="text" id="desc" placeholder="Description here"/>
            <button type="submit">Submit</button>
        </div>
    </div>
</template>

<script>
export default {
  name: 'createComp',
  methods: {
      tog: function(){
          const btn = document.querySelector("#inputs");
          console.log("hit");
          btn.classList.toggle("nodisp");
      },
  }
}
</script>

<style scoped>
#create{
    background-color: #d1eefc;
    height: 600px;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;
    font-family: good-times;
    padding: 40px;
}
#inputs{
    display: flex;
    flex-direction: column;
    width:300px;
    background-color:  #f0efee;
    padding: 40px;
    border-radius: 40px;
    border-top-left-radius: 0;
    color: #111180;
    box-shadow: 5px 10px #000000;

}

.nodisp{
    display: none !important;
}

#inputs input{
    margin-bottom: 10px;
    border: 0; border-radius: 40px;
    border-top-left-radius: 0;
    padding: 5px;
    box-shadow: 5px 3px #000000;
}

#inputs button{
    margin-bottom: 10px;
    border: 0; border-radius: 40px;
    border-top-left-radius: 0;
    padding: 5px;
    background-color: #e46924;
    box-shadow: 5px 3px #000000;
    font-family: good-times;
    margin: 20px 0 0 0 ;
}

#pop{
    background-color: #e46924;
    font-size: 80px;
    border-radius: 40px;
    border-top-left-radius: 0;
    font-family: good-times;
    padding: 40px;
    border: 0;
    box-shadow: 5px 10px #000000;
}

/* #e46924 orange
    #111180 navy
    #f0efee light grey
    #94b6e4 light blue
  */

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

</style>