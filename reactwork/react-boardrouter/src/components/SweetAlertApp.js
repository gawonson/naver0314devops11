import { Alert, Button } from "@mui/material";
import Swal from "sweetalert2";
import xmas1 from '../image/santa.gif';
import tree1 from '../image/tree1.gif';
import tree2 from '../image/tree2.gif';
import tree3 from '../image/tree3.gif';
import bell1 from '../image/bell1.gif';
import { useState } from "react";

const SweetAlertApp =()=>{

    const [sangpum,setSangpum]=useState("애플워치");
    
    //버튼 이벤트 #1
    const buttonEvent1=()=>{
        Swal.fire("안녕")//basic
    }
    //버튼 이벤트 #2
    const buttonEvent2=()=>{
        Swal.fire({
            title:"Swal Test 2",
            // text:"줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>"
            html:"줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>",
            icon:"info",//warning, error, success, info,
            confirmButtonColor:"#abcabc",//16진수
            confirmButtonText:"확인",
            cancelButtonColor:'orange',
            cancelButtonText:"취소",
            showCancelButton:'true'

        }).then(result=>{
            if(result.isConfirmed){
                Swal.fire("처리했습니다")
            }else{
                Swal.fire("취소했습니당")
            }
        })
    }
    //버튼 이벤트 #3
    const buttonEvent3=()=>{
        Swal.fire({
            title:'사진 넣기',
            html:`<h5>사진을 넣어보세요</h5><img src=${tree1} alt=''/>`,
            imageUrl:xmas1,
            imageHeight:60,
            imageWidth:50,
            icon:'success'
        })
        
    }
    //버튼 이벤트 #4
    const buttonEvent4=()=>{
        Swal.fire({
            title:'input email address',
            input:'email',
            inputLabel:'Your Email Address',
            inputPlaceholder:'Enter your email address',
            showCancelButton:'true',
            cancelButtonText:"취소"
        })
    }
    //버튼 이벤트 #5
    const buttonEvent5=()=>{
        Swal.fire({
            title:'상품구매',
            imageUrl:'../house1.gif',/*public dml tkwlsdms rudfhfh sjgrl */
            html:`[${sangpum}] 상품을 구매하시겠습니까?`,
            showCancelButton:'true',
            cancelButtonText:"cencel"
        }).then(result=>{
            if(result.isConfirmed){
                Swal.fire(`[${sangpum}]을 결재했습니다`);
            }
        })
    }
     //버튼 이벤트 #6
     const buttonEvent6=()=>{
        const arr=[
            {photo:tree1,msg:"캔디"},
            {photo:tree2,msg:"마이클"},
            {photo:tree3,msg:"영자"},
            {photo:bell1,msg:"철수"}
        ];
        let s="";
        for(let a of arr){
            s+=`<img alt="" src=${a.photo} width=30/>&nbsp;&nbsp;<b>${a.msg}</b><br/>`;
        }
        Swal.fire({
            icon:'success',
            title:'좋아요 누른사람',
            imageUrl:xmas1,
            html:s
        });
     }
    return(

        <div>

            <Alert>SweetAlert 공부하기</Alert>
            <Button variant="contained" color='error' size='small'  onClick={buttonEvent1}>SweetAlert #1</Button><br/><br/>
            <Button variant="contained" color='error' size='small'  onClick={buttonEvent2}>SweetAlert #2</Button><br/><br/>
            <Button variant="contained" color='error' size='small'  onClick={buttonEvent3}>SweetAlert #3</Button><br/><br/>
            <Button variant="contained" color='error' size='small'  onClick={buttonEvent4}>SweetAlert #4</Button><br/><br/>
            <Button variant="contained" color='error' size='small'  onClick={buttonEvent5}>SweetAlert #5</Button><br/><br/>
            <Button variant="contained" color='error' size='small'  onClick={buttonEvent6}>SweetAlert #6</Button><br/><br/>


        </div>
    )
}
export default SweetAlertApp;