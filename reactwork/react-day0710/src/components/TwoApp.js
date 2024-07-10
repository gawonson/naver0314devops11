import { DeleteForeverOutlined } from "@mui/icons-material";
import { Alert, Button } from "@mui/material"
import { useState } from "react";

const TwoApp=()=>{

    const [names,setNames]=useState([]);
    const [n,setN]=useState("");

    //이름 추가 이벤트
    const addName=(e)=>
        {
            setN(e.target.value)
            
        };

    //버튼 이벤트
    const addNameList=(e)=>{
        if(n.length===0){
            alert("이름을 입력해주세요")
        }
        else{
            setNames(names.concat(n));
            setN("");
        }
    }

    //삭제 이벤트
    const deleteMessage=(i)=>{
        let a=window.confirm("삭제하시겠습니까?")
        
        if(a){
            setNames(names.filter((m,n)=>n!==i));
        }
        else{
            return;
        }
    }

    return (
        <div>
            <Alert>TwoApp</Alert>
            
            <div className="input-group">이름입력:
                <input type="text"  onChange={addName} value={n} />
                <button type="button" className="btn btn-outline-danger" onClick={addNameList}>추가</button>
            </div>
            {
                names &&
                names.map((item,i)=>
                <h3>
                    {item}
                    <DeleteForeverOutlined style={{cursor:'pointer'}}  onClick={()=>deleteMessage(i)} />
                </h3>
                )
            }

        </div>
    )
}
export default TwoApp;