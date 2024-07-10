import { Alert, Button } from "@mui/material"
import { useRef, useState } from "react";

const ThreeApp=()=>{
    /*
        useRef : 변수를 관리하는 기능, 값이 변경되어도 다시 랜더링되지 않는다
            -형식(useState 는 매번 화면이 랜더링 된다.)
                const ref=useRef(value);
        갑을 가져오려면 ref.current
    */

    const countRef=useRef(1);
    const [count,setCount]=useState(1);
    console.log("랜더링중 ....")

    const countIncre=()=>setCount(count+1);
    const countRefIncre=()=>{
        countRef.current=countRef.current+1;
        //화면이 랜더링되지않아 확인이 안되므로 콘솔로 바뀐값을 확인해보자
        console.log(countRef.current);
    }

    return (
        <div>
            <Alert>ThreeApp-useRef</Alert>
            <h1>state 변수 : {count}</h1>
            <h1>Ref 변수 : {countRef.current}</h1>
            <hr/>
            <Button variant="contained" color="success" onClick={countIncre}>state 변수 1 증가하기</Button>
            <Button variant="contained" color="success" onClick={countRefIncre}>ref 변수 1 증가하기</Button>


        </div>
    )
}
export default ThreeApp;