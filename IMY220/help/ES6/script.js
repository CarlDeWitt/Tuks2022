// Arrow functions

sum = (a,b) => a+b;
isPositive = (a) => a>=0;
randomNum = ()=>Math.random();
document.addEventListener("click.js", ()=> console.log("Clicked"));
document.querySelector()

console.log(sum(1,2));
console.log(isPositive(4));
console.log(randomNum());

// class
class Person {
    constructor(name, age) {
        this._name = name;
        this._age = age;
    }
    sayName = () => console.log(this._name);
    
    sayAge = () => console.log(this._age);
    

    get name() {
        return this._name;
    }
    set name(value) {
        this._name = value;
    }
}
let p = new Person("John", 30);
p.sayName();