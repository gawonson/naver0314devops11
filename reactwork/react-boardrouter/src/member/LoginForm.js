import { Button } from "@mui/material";
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const LoginForm=()=>{
    const [userid,setUserid]=useState('');
    const [passwd,setPasswd]=useState('');
    const navi=useNavigate();
    const submitLoginEvent=(e)=>{
        e.preventDefault();
        axios.get(`/boot/member/login?userid=${userid}&passwd=${passwd}`)
        .then(res=>{

            if(res.data.result==='noid'){
                alert("회원 아이디가 아닙니다.\n가입 후 로그인해주세요");
                return;
            }else if(res.data.result==='fail'){
                alert("비밀번호가 맞지 앗습니다");
                return;
            }else{
                //토큰을 얻어서 세션 스토리지에 저장
                sessionStorage.token=res.data.token;
                //home으로 이동
                window.location.reload();
            }
        })
    }
    return(
        <div style={{margin:'30px 100px'}}>
            {
                sessionStorage.token!=null?
                <h2><b>로그인중입니다.</b></h2>
                :
                <form onSubmit={submitLoginEvent}> 
                <table className="table table-bordered"style={{width:'300px'}}>
                    <caption align='top'><h5><b>[회원 로그인]</b></h5></caption>
                    <tbody>
                        <tr>
                            <th className="table-danger" style={{widht:'100px'}}>아이디</th>
                            <td>
                                <input type="text" className="form-control" value={userid} required onChange={(e)=>setUserid(e.target.value)}/>
                            </td>
                        </tr>
                        <tr>
                            <th className="table-danger" style={{widht:'100px'}}>비밀번호</th>
                            <td>
                                <input type="password" className="form-control" value={passwd} required onChange={(e)=>setPasswd(e.target.value)}/>
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={2} align="center">
                                <Button variant="contained" color="success" type="submit">로그인</Button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>}
        </div>
    )
}
export default LoginForm;