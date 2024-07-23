import { Button } from "@mui/material";
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const MemberForm=()=>{
    const [idcheck,setIdcheck]=useState(false);
    const [userid,setUserId]=useState('');
    const [passwd,setPasswd]=useState('');
    const [hp,setHp]=useState('');

    const navi=useNavigate();

    const userIdCheckEvent=()=>{
        let url=`/boot/member/check?userid=${userid}`;
        axios.get(url)
        .then(res=>{
            if(res.data==='success'){
                alert("이미가입된 아이디입니다");
                setUserId('');
                setIdcheck(false);
            }else{
                alert("가입가능한 아이디입니다.");
                setIdcheck(true);
            }
        })
    }
    const addSubmitMember=(e)=>{
        e.preventDefault();
        if(idcheck===false){
            alert("아이디 중복확인을 해주세요");
            return;
        }
        let url=`/boot/member/insert?userid=${userid}&passwd=${passwd}&hp=${hp}`
        axios.get(url)
        .then(res=>{
            navi("/member/list");
        })
    }
    return( 
        <form onSubmit={addSubmitMember}>
            <table className="table table-bordered" style={{width:'300px'}}>
                <caption align="top"><h5><b>회원가입</b></h5></caption>
                <tbody>
                    <tr>
                        <th style={{width:'100px'}}>아이디</th>
                        <td className="input-group">
                            <input type="text" value={userid} onChange={(e)=>{
                                setUserId(e.target.value);
                                setIdcheck(false);
                            }}className="form-control"/>
                            &nbsp;
                            <Button variant="contained" color="error" onClick={userIdCheckEvent}>중복확인</Button>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width:'100px'}}>비밀번호</th>
                        <td className="input-group">
                            <input type="password" value={passwd} className="form-control" required onChange={(e)=>setPasswd(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width:'100px'}}>핸드폰</th>
                        <td className="input-group">
                            <input type="text" value={hp} className="form-control" required onChange={(e)=>setHp(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align="center">
                            <Button variant="contained" color="success" type="submit">회원가입</Button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    )
}
export default MemberForm;