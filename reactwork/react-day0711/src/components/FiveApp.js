import { Alert } from "@mui/material";
import Axios from "axios";
import { useEffect, useState } from "react";
import FiveRowItem from "./FiveRowItem";

/*
axios는 현재 커뮤니티에서 가장 많이 사용하는 http 통신 라이브러리이다.
엑시오스는 Promise 기반의 API 형식이 다양하게 제공되어 별도으이 로직을 구현할핑요없이 API 만으로도 간편하게 원하는 로직을 구현할수있다
promise란? 서버데이터를 요청바하여 받아오는 동작고 ㅏ같은 비동기 로직 처리에 유용한 자바스크립트 객체이다 
Http Get 요청
axios.get('url주소').then().catch();
http 옵션에 대한 옵션 속성 정의 
axios({
method:'get',
url:'url주소',
...
});
*/
const FiveApp =()=>{
    const [mycarlist,setMycarList]=useState([]);
    //백엔드에서 mycar 목록을 가져온다
    const list =()=>{
        Axios.get("/mycar/list")
        .then(res=>{
            setMycarList(res.data);
        })
    }
    //처음 로딩시 목록을 가져온다
    useEffect(()=>{
        list();
    },[])//처음 한번만 호출
    return (
        <div>
            <h1>FiveApp-Axios db 데이터 가져오기</h1>
            <Alert severity="info">총 {mycarlist.length}개의 자동차 정보가 있습니다.</Alert>
            <table className="table table-bordered" style={{width:'400px'}}>
                <tbody>
                    {
                        mycarlist.map((mycar,idx)=>
                            <FiveRowItem mycar={mycar} key={idx}/>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}
export default FiveApp;