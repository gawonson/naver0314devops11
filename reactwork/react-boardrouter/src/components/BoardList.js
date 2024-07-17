import { Alert } from "@mui/material";
import axios from "axios";
import { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";
import img1 from '../image/no1.png';
const BoardList =()=>{
    const [boardList,setBoardList]=useState([]);
    const storage=process.env.REACT_APP_STORAGE;
    const getDataList =()=>{
        axios.post("/boot/board/list")
        .then(res=>{
            setBoardList(res.data);
        });
    }
    useEffect(()=>{
        getDataList();
    },[]);

    return(
        <div style={{width:'600px'}}>
            <Alert>총 {boardList.length}개의 게시물이있습니다</Alert>
            <table className="table table-striped">
                <thead>
                    <tr className="table-danger">
                        <th style={{width:'50px'}}>번호</th>
                        <th style={{width:'250px'}}>제목</th>
                        <th style={{width:'70px'}}>작성자</th>
                        <th style={{width:'100px'}}>작성일</th>
                        <th style={{width:'50px'}}>조회</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        boardList &&
                        boardList.map((item,idx)=>
                            
                            <tr key={idx}>
                                <td>{boardList.length-idx}</td>
                                <td>
                                    <NavLink to={`/board/detail/${item.boardnum}`} style={{textDecoration:'none',color:'black'}}>
                                    <img src={`${item.photo}`=='no'?`${img1}`:`${storage}/${item.photo}`} alt='' style={{width:'40px',height:'40px',marginRight:'5px'}}/>
                                    {item.subject}</NavLink>
                                </td>
                                <td>{item.writer}</td>
                                <td><span>{item.writeday.substring(0,10)}</span></td>
                                <td>{item.readcount}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>

        </div>
    )
}
export default BoardList;