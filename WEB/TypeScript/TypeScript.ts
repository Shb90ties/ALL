// Types
var flag:boolean;
flag = true; 
flag = 'sdfsd' // error
var num:number = 100;
num = '100'; // error
var Arr:number[] = [1,2,3];
var ArrA:number[] = [1,2,'dsfsdf']; // error
// solution ^ //
var AnyArr:any[] = [1,2,3,'dsfsdf'];



// Enums
enum constants{
    pi = 3.14547,
    e = 2.73
}
console.log(2 * constants.pi);
constants.pi = 4451.22; // error cannot be changed



// Functions
function add(a:number,b:number):number{
    return a+b;
}   // if it doens't return then ^ no need
console.log(add(5,7));
console.log(add(5,'fdgdfsgs')); // error
function add(a:any){
    if(typeof a == "string"){
        console.log('this is a string');
    }
    if(isNaN(parseInt(a))){
        console.log('this is not a number');
    }
}
// Functions default arguments
function mul(a:number,b:number = a+1):number
{
    return a*b;
}
console.log(mul(5,7)); // OK
console.log(mul(5)); // OK => like(5,5+1)
function boolies(a:boolean = false,b?:boolean){
    return a;
}   // both a & b have default false
    // function doesn't have to specify return type
boolies(); // OK => (boolies(false,false))



// Function Overloading
function makeShape(a:number);
function makeShape(a:number,b:number);
function makeShape(a:number,b:number,c:number,d:number);
function makeShape(a:number,b?:number,c?:number,d?:number){
    // b === undefined ~ b === void 0
    if(b === undefined){
        console.log('square');
    }else if(c === undefined){
        console.log('Rectangle');
    }else{
        console.log('some shape');
    }
}
makeShape(5); // OK
makeShape(5,10); // OK
makeShape(5,10,88); // ERROR
makeShape(5,10,88,7); // OK



// Interface
    // Alternative
    function shape(x:{ a:number; b:number; }){
        return x.a*x.b;
    }
    var c = shape({ a:5, b:6 });
interface shapeIT{
    a: number;
    b: number;
    c?:string;
}
function shapeB(s:shapeIT){
    return s.a*s.b;
}
var cc = shapeB({ a:5, b:11 });

// Interface with Functions
interface player{
    run(): void;
    score(turn:number): number;
}
function makePlayer():player{
    return {
        run: function(){},
        score: function(turn:number){ return turn*5; }
    }
}
var myPlayer = makePlayer();





// Class
class website{
    url: string;
    views: number;
}
var google = new website();
google.url = "www.google.com";
google.views = 1000000;

// Class with constuctor & functions
class web{
    url: string;
    views: number;

    constructor(url:string,views:number){
        this.url = url;
        this.views = views;
    }

    print(){ console.log(this.url); }
    getViews():number{ return this.views; }
}
var youtube = new web('youtube.com',100000);
youtube.print();
var youtubeViews = youtube.getViews();

// Getters & Setters
class triangle{
    a:number;
    b:number;
    c:number;

    constructor(a:number,b:number,c:number){
        this.a = a; this.b = b; this.c = c;
    }

    get area():number{
        return this.a*this.b*this.c;
    }

    set setA(AA:number){
        this.a = AA*5 - this.b;
    }
}
var myT = new triangle(5,3,6);
console.log(myT.area); // like a virable
myT.setA = 77; // like a virable




// Lamda / fat => arrow & HTML elements
class car{
    gasAmount:number;
    carOBJ: HTMLElement;

    constructor(){
        this.gasAmount = 0;
        this.carOBJ = document.getElementById('myCar');
    }

    // Problem : this in a function will not the this in the class
        // function have their own scope
        // () => doesn't have their own scope
    run():void{
        //ERROR
        setInterval(function(){
            this.carOBJ.innerHTML = 'moving!';
                // this is no longer in the class
        },500);

        // solution // OK
        setInterval( () => {
            this.carOBJ.innerHTML = 'moving!';
        },500);
    }
}

// equivilence
var x = function(x:number){ return x*5; }
var y = (x:number) => { return x*5; }