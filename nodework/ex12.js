//상속
class AA{
    constructor(name){
        this.name=name;
    }
    printName(){
        console.log("이름: "+this.name);
    }
}

class BB extends AA{
    constructor(name,addr){
        super(name);//java는 생략가능 하지만 js는 상속인 경우 super() 도 생락 안됨
        this.addr=addr;
    }
    printInfo(){
        this.printName();
        console.log("주소:"+this.addr);
    }
}

//선언
let bb=new BB("손흥민","영국");
bb.printInfo();



