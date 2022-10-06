// // Arrow functions

// sum = (a,b) => a+b;
// isPositive = (a) => a>=0;
// randomNum = ()=>Math.random();
// document.addEventListener("click.js", ()=> console.log("Clicked"));
// document.querySelector()

// console.log(sum(1,2));
// console.log(isPositive(4));
// console.log(randomNum());

// // class
// class Person {
//     constructor(name, age) {
//         this._name = name;
//         this._age = age;
//     }
//     sayName = () => console.log(this._name);
    
//     sayAge = () => console.log(this._age);
    

//     get name() {
//         return this._name;
//     }
//     set name(value) {
//         this._name = value;
//     }
// }
// let p = new Person("John", 30);
// p.sayName();
// var btn = document.querySelector('.btn');

// btn.onclick = dosomething;
    

// function dosomething(){
//     var dosomething2 = function(){
//         console.log('aweh');  
//     }
//     return dosomething2();
// }

// $(`#firstTop`).append(`<h1>HI</h1>`);

// $(`body`).find(`a`).val(1).css("fontSize", "32px");

// $(`body`).each(function(){
//     console.log($(this).text());
    
//     if($(this).text() == 1){
//         console.log('yapsdo'); 
//     }else{
//         console.log('no'); 
//     }
// })

$(`div`).each(function(){
    $(this).each(function(){
        if($(this).text() === "1"){
            console.log('yaa');            
        }else{
            console.log('na');
            
        }
        console.log($(this).text());
    })

    // console.log($(this).text());
    
    
    // if($(this).text() == 1){
    //     console.log('yapsdo'); 
    // }else{
    //     console.log('no'); 
    // }
})
    
