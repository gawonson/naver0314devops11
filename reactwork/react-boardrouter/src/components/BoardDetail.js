import { Alert, Button } from "@mui/material";
import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const BoardDetail =()=>{
    const {boardnum}=useParams();

    const navi=useNavigate();
    const [list, setList] = useState('');
    const storage=process.env.REACT_APP_STORAGE;
    const getDetail=()=>{
        axios.get(`/boot/board/detail?boardnum=`+boardnum)
        .then(res => setList(res.data))
    }

    useEffect(()=>{
        getDetail();
    },[])

    return(
        <div>
            <Alert>상세보기</Alert>
            <table className="table table-boardered" style={{width:'500px'}}>
                <tbody>
                    <tr>
                        <td colSpan={3} align="center" style={{height:'60px',fontSize:'30px'}}>{list.subject}</td>
                    </tr>
                    <tr>
                        <td >작성자 : {list.writer}</td>
                        <td >작성일 : <span style={{color:'gray'}}>{list.writeday}</span></td>
                        <td >조회수 : {list.readcount}</td>
                    </tr>
                    <tr>
                       <td colSpan={3} style={{height:'300px'}}>
                            {list.content}
                            <img src={`${list.photo}`!=='no'?`${storage}/${list.photo}`:''}></img>
                        </td> 
                    </tr>
                    <tr>
                        <td colSpan={3} align='center'>
                            <Button variant="contained" color="error" onClick={()=>navi('/board/list')} style={{marginRight:'10px'}}>목록으로</Button>
                            <Button variant="contained" color="error" onClick={()=>navi('/board/form')}>새 글쓰기</Button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}
export default BoardDetail;