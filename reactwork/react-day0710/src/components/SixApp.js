import { Alert } from "@mui/material"
import SixChildApp from "./SixChildApp";
import { useState } from "react";
import SixChild2App from "./SixChild2App";

const SixApp=()=>{
    const [count,setCount]=useState(0);
    const [array,setArray]=useState([{cname:"아우디",cphoto:"mycar15.png",cprice:'2300',color:'#afeeee'},
        {cname:"벤츠",cphoto:"mycar7.png",cprice:'4800',color:'#ffc0cb'},
        {cname:"제네시스",cphoto:"mycar12.png",cprice:'8600',color:'#e0ffff'},
        {cname:"미니",cphoto:"mycar11.png",cprice:'6300',color:'#40e0d0'}
    ])
    //삭제하는 함수
    const deleteCar = (idx)=>{
        setArray(array.filter((m,n)=>n!==idx));
    }
    // count 변경 이벤트
    const countIncre =()=>setCount(count+1);
    return (
        <div>
            <Alert>SixApp</Alert>
            <Alert severity="error" style={{fontSize:'20px'}}>회원 방문 횟수 {count}회</Alert>
            <SixChildApp carname="아반떼" carphoto="mycar8.png" carprice="4500" bgcolor="#ffc0cb" onIncre={countIncre}/>
            <SixChildApp carname="그랜져" carphoto="mycar5.png" carprice="8000" bgcolor="#7fffd4" onIncre={countIncre}/>
            <SixChildApp carname="벤츠" carphoto="mycar13.png" carprice="2100" bgcolor="orange" onIncre={countIncre}/>
            <hr style={{clear:'both'}}/>
            <table className="tbstyle">
                <thead>
                   <tr style={{backgroundColor:'#f5f5dc'}}>
                        <th style={{width:'100px'}}>자동차명</th>
                        <th style={{width:'90px'}}>사진</th>
                        <th style={{width:'140px'}}>가격</th>
                        <th style={{width:'100px'}}>삭제</th>
                   </tr>
                </thead>
                <tbody>
                    {
                        array.map((item,idx)=><SixChild2App row={item} key={idx} onDelete={deleteCar} idx={idx}/>)
                    }
                </tbody>
            </table>
        </div>
    )
}
export default SixApp;