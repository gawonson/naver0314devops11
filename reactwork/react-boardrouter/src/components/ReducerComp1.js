import { Alert, Button } from "@mui/material"
import { useReducer, useState } from "react";

// useReducer : state 관리가 용이하며 유지,보수가 간편하다
// 호출 : dispatch(type,action) 로 호출 시 -> reducer(state,action) 함수가 호출됨
//  rdducer 는 state를 업데이트하는 역할 
// dispatch 에 state 업데이트를 요구
// action : 요구의 내용 


//상수 등록
const ACTION_TYPE={
    add:'addmoney',//add 라고 주면 addmoney 가 호출
    sub:'submoney'//sub 라고 주면 submoney가 호출
}

//첫번째 예제는 간단하게 입출금을 하는 예제
const reducer=(state,action)=>{
    console.log("reducer(은행)가 일을 합니다",state,action);
    //action type 에 따라 state(money) 변경 처리
    switch(action.type){
        case ACTION_TYPE.add:
            // case 'addmoney':
            return state+Number(action.payload);
        case ACTION_TYPE.sub:
            return state-Number(action.payload);
        default:
            return state;//반드시 else 가 있어야함
    }
}
const ReducerComp1 =()=>{
    const [number,setNumber]=useState(0);
    const [money,dispatch]=useReducer(reducer,0);
    return(
        <div>
            <Alert>Reducer component #1</Alert>
            <h3>useReducer 은행에 오신것을 환영합니다</h3>
            <h3> 잔고 : <b>{money}</b></h3><hr/>
            <input type="number" value={number} step={1000} onChange={(e)=>setNumber(e.target.value)} className="form-cotrol" style={{width:'200px'}}/>
            <Button variant="contained" color="success" size="small" onClick={()=>dispatch({type:ACTION_TYPE.add,payload:number})}>입금</Button>
            &nbsp;&nbsp;
            <Button variant="contained" color="success" size="small" onClick={()=>dispatch({type:ACTION_TYPE.sub,payload:number})}>출금</Button>

        </div>
    )
}

export default ReducerComp1;