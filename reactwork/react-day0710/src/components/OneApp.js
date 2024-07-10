import { DeleteForeverOutlined } from "@mui/icons-material";
import { Alert } from "@mui/material"
import { useState } from "react";

const OneApp=()=>{

    const [msg,setMsg]=useState(["Happy","안녕","Bitcamp"]);
    //메세지 입력 후 엔터시 이벤트
    const addMessageEvent =(e)=>{
        if(e.key==='Enter'){
            // setMsg(msg.push(e.target.value));
            setMsg(msg.concat(e.target.value))
            e.target.value="";
        }
    }
    //i번지의 메세지 삭제하는 함수
    const deleteMessage=(i)=>{
//방법 1 slice
        // setMsg(
        //     [
        //         ...msg.slice(0,i),...msg.slice(i+1,msg.length)
        //     ]
        // )
//방법2 filter
        setMsg(msg.filter((m,n)=>n!==i));

    }

    return (
        <div>
            <Alert>OneApp-배열에 데이터 추가 / 삭제</Alert>
            <hr/>
            <input type='text' className="form-control" style={{width:'300px'}} placeholder="메세지 입력 후 엔터" onKeyUp={addMessageEvent}/>

            <hr/>
            <h3 style={{color:"red"}}>배열 데이터 출력</h3>
            <Alert severity="info">총{msg.length}개의 메세지가 있어요</Alert>
            {
                ///* msg 값이 널이 아닐경우에만 출력 */
                msg &&
                msg.map((m,i)=>
                    <h4 key={i} >{m}
                    &nbsp;&nbsp;
                    <DeleteForeverOutlined style={{cursor:'pointer'}}  onClick={()=>deleteMessage(i)} />
                    </h4>
                )
            }
        </div>
    )
}
export default OneApp;