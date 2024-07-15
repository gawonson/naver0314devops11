import { Alert, Button } from '@mui/material';
import Axios from 'axios';
import MyCarRowItem from './MyCarRowItem';
import { useEffect, useState } from 'react';
import MyCarWriteForm from './MyCarWriteForm';
import axios from 'axios';
import * as React from 'react';



const MyCarList=()=>{
    const [list,setList]=useState([]);
    const [show,setShow]=useState(true);

    const MyCarList=()=>{
        Axios.get("/mycar/list")
        .then(res=>setList(res.data));

    }

    //처음 시작시 목록 가져오기-한번만 호출
    useEffect(()=>{
        MyCarList();
    },[]);

    //자동차 등록버튼 이벤트
    const addMycarEvent=(data)=>{
        console.log(data);
        axios.post("/mycar/insert",data)
        .then(res=>{
            MyCarList();
        })
    }

    //삭제하기 이벤트
    const delRow =(num)=>{
        axios.delete("/mycar/delete?num="+num)
        .then(res=>{
            MyCarList();
        })
    }

        //다이얼로그
        const updateMycar=(data)=>{

            axios.post("/mycar/update",data)
            .then(res=>{
                MyCarList();
            })
        }


    return(
        <div>

            <Button variant='contained' color='info' onClick={()=>setShow(!show)}>자동차 등력 show/hide</Button>
            {
                show &&
                <MyCarWriteForm onsave={addMycarEvent}/>
            }
                <Alert severity='success' style={{fontSize:'15px',width:'500px'}}>
                    <b>총 {list.length}개의 자동차 정보가 있습니다.</b>
                </Alert>
                <table className='table table-bordered'
                style={{width:'500px'}}>
                    <thead>
                        <tr className='table-danger'>
                            <th style={{width:'150px'}}>자동차명</th>
                            <th style={{width:'100px'}}>가격</th>
                            <th style={{width:'60px'}}>색상</th>
                            <th style={{width:'120px'}}>구입일</th>
                            <th style={{width:'120px'}}>등록일</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            list.map((row,idx)=>
                            <MyCarRowItem key={idx} idx={idx} row={row} ondel={delRow} onUpdate={updateMycar}/>)
                        }
                    </tbody>
                </table>
        </div>
    )
}
export default MyCarList;