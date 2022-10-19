new Vue({
  el: '#app',
  data: {
  		todos: [
      	{name: 'subscribe to IMY'},
        {name: 'like && comment'},
      ],
      inputings: "",
  },
  methods: {
  addList: function(){
  	return this.todos.push({name:this.inputings});
  },
  removeList: function(event){
  	return this.todos.splice(this.event,1)
  },
  deleteAll: function(event){
  return this.todos.splice(this.event)
  }
  }
});