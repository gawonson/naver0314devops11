import { useState } from "react";
import FiveApp from "./FiveApp";
import FourApp from "./FourApp";
import OneApp from "./OneApp";
import SixApp from "./SixApp";
import ThreeApp from "./ThreeApp";
import TwoApp from "./TwoApp";
import SevenApp from "./SevenApp";
import EightApp from "./EightApp";

const MainApp =()=>{

    const [idx,setIdx]=useState(8);

    return(
        <div>
            <h3>2024-07-09 react</h3>
            <br/>
            <select className="form-select" style={{width:'300px'}} onChange={(e)=>{setIdx(Number(e.target.value))}}>
                <option value={1}>1번 컴포넌트</option>
                <option value={2} >2번 컴포넌트</option>
                <option value={3} >3번 컴포넌트</option>
                <option value={4}>4번 컴포넌트</option>
                <option value={5}>5번 컴포넌트</option>
                <option value={6} >6번 컴포넌트</option>
                <option value={7} >7번 컴포넌트</option>
                <option value={8} selected>오늘의 문제</option>
            </select>
            <br/>
            {
                idx===1?<OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>:idx===4?<FourApp/>:idx===5?<FiveApp/>:idx===6?<SixApp/>:idx===7?<SevenApp/>:<EightApp/>
            }
        </div>

    );
};
export default MainApp;