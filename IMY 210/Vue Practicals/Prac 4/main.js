const state = {
    task: ['Will i get sued by Whastapp','maybe','damm hold on I know some one','YES'],
    name: ['Carl','FBI','Carl','Elon Musk'],
    time: ['14:00','14:00', '14:02', '14:03']
}

const mutations = {
    ADD_TASK(state,paylaod){
        let newTask = paylaod;
        // alert("hi");
        state.task.push(newTask);
    },
    ADD_NAME(state,paylaod){
        let newName = paylaod;
        // alert("hi");
        state.name.push(newName);
    },
    ADD_TIME(state,paylaod){
        let now = new Date();
        let hours = `${now.getHours()}`;
        let mins;
        if(now.getMinutes() < 10)
            mins = `0${now.getMinutes()}`;
        else
            mins = `${now.getMinutes()}`;
    
        let timestamp = `${hours}:${mins}`;
        // console.log(timestamp);
        // alert("hi");
        state.time.push(timestamp);
    }
}

const actions = {
    addTask (context,paylaod){
        context.commit('ADD_TASK',paylaod);
    },
    addName(context,paylaod){
        context.commit('ADD_NAME',paylaod);
    },
    addTime(context,paylaod){
        context.commit('ADD_TIME',paylaod);
    }
}

const getters = {
    getTask (state){
        return state.task;
    },
    getUser(state) {
        return state.name;
    },
    getTimestamp (state){
        return state.time;
    }

}

const store = Vuex.createStore({
    state,
    mutations,
    actions,
    getters
})

const inputComp = {
    template: '<input v-model="inptname" type="text"><input v-model="input" type="text" @keyup.enter="enterKeyPress"/>',
    data(){
        return{
            input: '',
            inptname: '',
        }
    },
    methods: {
        enterKeyPress(){            
            this.$store.dispatch('addTask',this.input);
            this.$store.dispatch('addName',this.inptname);
            this.$store.dispatch('addTime',this.inptname);
            this.input="";
            this.inptname="";
        }
    }
}

const app = Vue.createApp({
    computed:{
        tasks(){
            return this.$store.getters.getTask;
        },
        names(){
            return this.$store.getters.getUser;
        },
        times(){
            return this.$store.getters.getTimestamp;
        }
    },
    components:{
        'input-component': inputComp,
    }
})

app.use(store);
app.mount("#app");