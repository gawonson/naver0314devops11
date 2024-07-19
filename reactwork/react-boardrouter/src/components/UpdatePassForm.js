import { Button } from "@mui/material";
import axios from "axios";
import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const UpdatePassForm=()=>{
    const navi = useNavigate();
    const {boardnum}=useParams();

    const [pass,setPass]=useState('');

    const checkpass=()=>{
        axios.get(`/boot/board/updatecheckpass?boardnum=${boardnum}&pass=${pass}`)
        .then(res=>{
            if(res.data.result=='success'){
                navi("/board/updateform/"+boardnum);
            }else{
                alert("비밀번호가 틀립니다.")
            }
        }
        )
    }
    return(
        <div>
            비밀번호<input type="password" onChange={(e)=>setPass(e.target.value)}/>
            <Button variant="contained" color="error" onClick={()=>navi("/board/detail/"+boardnum)} >취소</Button>
            <Button variant="contained" color="error" onClick={checkpass} >수정</Button>
        </div>
    )
}
export default UpdatePassForm;