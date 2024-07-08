//첫 컴포넌트는 클래스 형태로 만들어보자
//Hooks 문법이 추가된 이유는 클래스 형태보다는 function형태로 많이 만든다

import { Component } from "react";
import car1 from "../mycar1.png";
import car2 from "../mycar2.png";
import car3 from "../mycar3.png";
import './MyStyle.css';
class OneApp extends Component {

    render(){
        return (
            <div>
                <h1 className="alert alert-danger">OneApp--class 형태</h1>
                <h5>public 의 사진 가져오기</h5>
                {/* public 의 사진은 매핑 주소에 따라서 안나올때도 있다. -권장 x */}
                <img src="./1.jpg" alt="사진 1" width={200}></img>{/*사진 안나올때 alt*/}
                <img src="./2.jpg" alt="사진 2" style={{width:'200px',border:'5px solid green', borderRadius:'50px 20px 100px 10px'}}></img>
                <h5>src 폴더의 사진 가져오기</h5>
                <img src={car1} alt="자동차 1" className="photo line1"></img>
                <img src={car2} alt="자동차 2" className="photo line2"></img>
                <img src={car3} alt="자동차 3" className="photo line3"></img>
            </div>
        )
    }
}

//export default OneApp; //default는 파일안에서 단 한번만 사용가능 , import 시에 마음대로 이름을 지정할 수 있다.
export {OneApp};
//이 경우에는 import 시에 정확한 이름으로 import