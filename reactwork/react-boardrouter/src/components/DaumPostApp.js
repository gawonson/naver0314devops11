import { Alert } from "@mui/material";
import { useState } from "react";
import DaumPostcode from 'react-daum-postcode';
import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';

const DaumPostApp =()=>{
    const [openPostcode,setOpenPostcode]=useState(false);
    const [address,setAddress]=useState('');

    const [openPostcode2,setOpenPostcode2]=useState(false);
    const [address2,setAddress2]=useState('');
    const [open, setOpen] = React.useState(false);

    const addrhandle={
        clickButton:()=>{
            setOpenPostcode(current=>!current);
        },

        //주소선택이벤트
        selectAdress : (data)=> {
            console.dir(data);
            setAddress(
                `주소 : ${data.address}
                우편번호 : ${data.zonecode}
                빌딩이름 : ${data.buildingName}`);
            setOpenPostcode(false);
        }

    }

    const addrhandle2={
        clickButton:()=>{
            setOpenPostcode2(current=>!current);
            setOpen(true);
        },

        //주소선택이벤트
        selectAdress2 : (data)=> {
            console.dir(data);
            setAddress(
                `주소 : ${data.address}
                우편번호 : ${data.zonecode}
                빌딩이름 : ${data.buildingName}`);
            setOpenPostcode2(false);
            //다이얼로그 닫기
            setOpen(false)
        }

    }

    const handleClose = () => {
        setOpen(false);
      };

    return(
        <div>
            <Alert>카카오 주소 나타내기</Alert>
            <h4>카카오 주소 나타내기 #1</h4>
            <Button variant="contained" color="success" onClick={addrhandle.clickButton}>주소나타내기</Button>

            <h3>{address}</h3>
            {
                openPostcode &&
                <DaumPostcode
                    onComplete={addrhandle.selectAdress} //값을 선택할경우 실행되는 이벤트
                    autoClose={false}//값을 선택할경우 사용되는 DOM을 제거하여 자동 닫힘 설정
                    defaultQuery="강남대로 94길 20"//팝업을 열때 기본적으로 입력되는 검색어
                    />
            }
            <hr/>
            <h4>카카오 주소 나타내기 #2</h4>
            <Button variant="contained" color="success" onClick={addrhandle2.clickButton}>주소나타내기2</Button>

            <h3>{address2}</h3>
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                {"Use Google's location service?"}
                </DialogTitle>
                <DialogContent>
                <DialogContentText id="alert-dialog-description">
                

                <DaumPostcode
                    onComplete={addrhandle2.selectAdress} //값을 선택할경우 실행되는 이벤트
                    autoClose={false}//값을 선택할경우 사용되는 DOM을 제거하여 자동 닫힘 설정
                    defaultQuery="반포자이"//팝업을 열때 기본적으로 입력되는 검색어
                    />
            
                </DialogContentText>
                </DialogContent>
                <DialogActions>
                <Button onClick={handleClose}>닫기</Button>

                </DialogActions>
            </Dialog>
        </div>
    )
}
export default DaumPostApp;