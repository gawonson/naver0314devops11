//Main 에 함수형으로 각종 컴포넌트를 배치해보자

import { useState } from "react";
import { FiveApp } from "./FiveApp";
import FourApp from "./FourApp";
import { OneApp } from "./OneApp";
import SixApp from "./SixApp";
import ThreeApp from "./ThreeApp";
import TwoApp from "./TwoApp";


const Main=()=>{
    const [idx,setIdx]=useState(6);
    return (
        <div>
            <h1>2024-07-08 리액트 첫수업</h1>
            <select className="form-select" style={{width:'200px'}} onChange={(e)=>{setIdx(Number(e.target.value))}}>
                <option value={1}>1번 컴포넌트</option>
                <option value={2}>2번 컴포넌트</option>
                <option value={3}>3번 컴포넌트</option>
                <option value={4}>4번 컴포넌트</option>
                <option value={5}>5번 컴포넌트</option>
                <option value={6} selected>오늘의 문제</option>
            </select>
            <br></br><br></br>
            {
                idx===1? <OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>:idx===4?<FourApp/>:idx===5?<FiveApp/>:<SixApp/>
            }


       
        </div>
    )
}

export default Main;