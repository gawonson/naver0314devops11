import Axios, * as others from 'axios';
import { useEffect, useState } from "react";


const Mycarlist =()=>{
    const [list,setList]=useState([]);    
    const MyCarList=()=>{
       Axios.get("/mycar/list")
       .then(res=>setList(res.data));

    }
    //처음 시작시 목록 가져오기-한번만 호출
    useEffect(()=>{
        MyCarList();
    },[]);

    return(
      <div>
        <table className='table table-bordered' style={{width:'500px'}}>
            <thead>
                <tr>
                    <th className='table-warning' style={{width:'50px'}}>번호</th>
                    <th className='table-warning'>이름</th>
                    <th className='table-warning'>가격</th>
                    <th className='table-warning'>색상</th>
                </tr>
                {
                    list.map((item,idx)=>
                        <tr key={idx}>
                            <td>{idx+1}</td>
                            <td>{item.carname}</td>
                            <td>{item.carprice}</td>
                            <td>
                                <div style={{height:'30px',borderRadius:'30px',border:'1px solid gray',backgroundColor:`${item.carcolor}`}}></div>
                            </td>
                        </tr>
                    )
                }
            </thead>
        </table>

      </div>
    )
}
export default Mycarlist;