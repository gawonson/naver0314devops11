//class에 method 만드는 방법
class Person{
    constructor(name,age){
        this.name=name;
        this.age=age;
    }
    //클래스 안의 메소드는 모두 클래스의 prototype
    //property에 추가된다
    printProfile(){
        console.log(`이름:${this.name}, 나이:${this.age}`);
    }
    //정적 함수
    static showTitle(){
        console.log("ES6의 정적함수 입니다.")
    }
}

//선언 
let p=new Person("손흥민",25);//생성
p.printProfile();//메서드 호출

//멤버 메서드로 드록되어있는지 확인
console.log("printProfile" in p.__proto__);
console.log("printProfile" in Person.prototype);

//정적 함수 호출방법
Person.showTitle();