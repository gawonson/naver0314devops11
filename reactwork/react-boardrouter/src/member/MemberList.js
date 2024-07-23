import axios from "axios";
import { useEffect, useState } from "react";

const MemberList=()=>{
    const [list,setList]=useState([]);

    const getList=()=>{
        axios.get("/boot/member/list")
        .then(res=>{
            setList(res.data)
        })
    };

    useEffect(()=>{
        getList(); 
    },[]);
    return(
        <div>
             {
                sessionStorage.token==null?<h5>로그인이 필요합니다</h5>:
                <div>
            <table className="table table-bordered" style={{width:'580px'}}>
                <caption align='top'><h3><b>회원 리스트</b></h3></caption>
                <thead >
                    <tr>
                        <th className="table-secondary" style={{width:'50px'}}>번호</th>
                        <th className="table-secondary" style={{width:'150x'}}>아이디</th>
                        <th className="table-secondary" style={{width:'150px'}}>전화번호</th>
                        <th className="table-secondary" style={{width:'180px'}}>가입일</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        list &&
                        list.map((item,idx)=>
                        <tr>
                            <td>{idx+1}</td>
                            <td>{item.userid}</td>
                            <td>{item.hp}</td>
                            <td>{item.gaipday}</td>
                        </tr>

                    )
                    }
                </tbody>
            </table></div>}
        </div>
    )
}
export default MemberList;