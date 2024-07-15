import { DeleteForeverOutlined, EditNote } from "@mui/icons-material";
import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import { useEffect, useState } from 'react';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Slide from '@mui/material/Slide';

const Transition = React.forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />;
  });
const MyCarRowItem=({row,idx,ondel,onUpdate})=>{
    const [carname,setCarname]=React.useState(row.carname);
    const [carprice,setCarprice]=useState(row.carprice);
    const [carcolor,setCarcolor]=useState(row.carcolor);

    // useEffect (()=>{
    //     setCarcolor(row.carcolor);
    //     setCarprice(row.carprice);
    //     setCarname(row.carname);
    // })


    const photopath1="https://rittbvra3706.edge.naverncp.com/CkpFfqomNo/mycar"
    const photopath2="?type=f&w=40&h=40&faceopt=true&ttype=jpg"
    const photopath="https://kr.object.ncloudstorage.com/bitcamp-gawon-136/mycar/"
    
    const clickdel=(num)=>{
        let a=window.confirm("해당 상품을 삭제할까요?");
        if(a){
            ondel(num);
        }
    }

    const [open, setOpen] = React.useState(false);
    const handleClickOpen = () => {
        setOpen(true);
      };
    
      const handleClose = () => {
        setOpen(false);
      };


//수정
const [open2, setOpen2] = React.useState(false);
const handleClickOpen2 = () => {
    setOpen2(true);
  };

  const handleClose2 = () => {
    setOpen2(false);
  };
const updateMycarEvent=()=>{
    onUpdate({num:row.num,carname,carprice,carcolor});
    setOpen2(false);
}



    return(
        <tr style={{fontSize:'14px'}}>
            {/* dialog */}
         
            <td>  
                <React.Fragment>
                <img src={`${photopath1}/${row.carphoto}${photopath2}`} style={{border:'5px',marginLeft:'5px'}} onClick={handleClickOpen}/>
              
                
                    <Dialog
                        open={open}
                        TransitionComponent={Transition}
                        keepMounted
                        onClose={handleClose}
                        aria-describedby="alert-dialog-slide-description"
                    >
                        <DialogTitle>{"자세히보기"}</DialogTitle>
                        <DialogContent>
                        <DialogContentText id="alert-dialog-slide-description">
                            <img src={`${photopath}${row.carphoto}`} style={{border:'5px',marginLeft:'5px', width:"300px",height:'300px'}}/>
                        </DialogContentText>
                        </DialogContent>
                        <DialogActions>
                        <Button onClick={handleClose}>닫기</Button>
                        </DialogActions>
                    </Dialog>
                </React.Fragment>
                <span>{row.carname}</span>
            </td>
            <td align="right">{row.carprice}만원</td>
            <td align="center">
                <div style={{width:'30px',height:'30px',backgroundColor:row.carcolor}}></div>
            </td>
            <td>{row.carguip}</td>
            <td>
                <span style={{color:'gray',fontSize:'13px'}}>{row.writeday}&nbsp;<DeleteForeverOutlined style={{cursor:'pointer'} }
                onClick={()=>clickdel(row.num)}
                />&nbsp;
                <EditNote style={{cursor:'pointer'}} onClick={handleClickOpen2}/>
                <Dialog
                        open={open2}
                        TransitionComponent={Transition}
                        keepMounted
                        onClose={handleClose2}
                        aria-describedby="alert-dialog-slide-description"
                    >
                        <DialogTitle>{"자동차 정보수정"}</DialogTitle>
                        <DialogContent>
                        <DialogContentText id="alert-dialog-slide-description">
                        <table className="table table-bordered" style={{width:'500px'}}>

                        <tbody>
                    <tr>
                        <td className="table-success" style={{width:'100px'}}>자동차명</td>
                        <td style={{width:'200px'}}>
                            <input type='text' className="form-control" value={carname} onChange={(e)=>setCarname(e.target.value)}/>
                        </td>
                        <td rowSpan={5} valign="middle">
                           
                        </td>
                    </tr>
                    
                    <tr>
                        <td className="table-success" style={{width:'100px'}}>차 가격</td>
                        <td>
                            <input type='text' className="form-control" style={{width:'200px'}} value={carprice} onChange={(e)=>setCarprice(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td className="table-success" style={{width:'100px'}}>차 색깔</td>
                        <td>
                            <input type='color' className="form-control" style={{width:'200px'}} value={carcolor} onChange={(e)=>setCarcolor(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3} align="center">

                            <Button variant="contained" color="success" onClick={updateMycarEvent} >등록</Button>
                        </td>
                    </tr>
                </tbody>
            </table>
                        </DialogContentText>
                        </DialogContent>
                        <DialogActions>
                        <Button onClick={handleClose2}>닫기</Button>
                        </DialogActions>
                    </Dialog>
                </span>

            </td>
        </tr>
    )
}
export default MyCarRowItem;
