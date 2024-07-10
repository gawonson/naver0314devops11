import { Alert } from "@mui/material"
import FiveChildApp from "./FiveChildApp";
import FiveChild2App from "./FiveChild2App";

const FiveApp=()=>{
    return (
        <div>
            <Alert>FiveApp-부모자식 컴포넌트의 통신</Alert>
            <h5>FiveChildApp 컴포넌트 호출</h5>
            <FiveChildApp irum={'손흥민'} age={32} addr={'제주도'}/>
            <FiveChildApp irum={'황희찬'} age={30} addr={'서울시'}/>
            <FiveChildApp irum={'이강인'} age={24} addr={'독도리'}/>
            <h5>FiveChild2App 컴포넌트 호출</h5>
            <FiveChild2App irum='이미자' photo='mycar11.png' msg='노랑이 차'/>
            <FiveChild2App irum='강미자' photo='mycar13.png' msg='분홍이 차'/>
        </div>
    )
}
export default FiveApp;