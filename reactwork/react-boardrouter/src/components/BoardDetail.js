import { Alert, Button } from "@mui/material";
import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import * as React from 'react';

import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import InputEmojiWithRef from "react-input-emoji";
import { DeleteForeverOutlined, EditNote, HighlightOff, UpdateDisabledOutlined, UpdateDisabledRounded, UpdateOutlined, UpdateTwoTone } from "@mui/icons-material";

const BoardDetail = () => {
    const { boardnum } = useParams();
    const [open, setOpen] = React.useState(false);
    const [comment, setComment] = useState([]);
    const [newcom, setNewcom] = useState('');
    const [nickname, setNickname] = useState('');
    const [comidx,setComidx]=useState('');

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const navi = useNavigate();
    const [list, setList] = useState('');
    const storage = process.env.REACT_APP_STORAGE;

    const getDetail = () => {
        axios.get(`/boot/board/detail?boardnum=` + boardnum)
            .then(res => { setList(res.data) })
    }

    useEffect(() => {
        getDetail();
        getComment();
    }, []);

    const getComment = () => {
        axios.get("/boot/comment/list?boardnum=" + boardnum)
            .then(res => {
                setComment(res.data);
            })
    }

    //닉네임 중복확인
    const checkNick = () => {
        axios.get("/boot/comment/check?nickname=" + nickname)
            .then(res => {
                if (res.data === 0) {
                    alert("사용가능한 닉네임입니다")
                    setNickname(nickname)
                } else {
                    alert("중복된 닉네임입니다")
                    return;
                }
            })
    }

    //답글등록
    const addComment = (newComment) => {
        if (nickname === '') {
            alert("닉네임 중복확인을 해주세요")
            return;
        }
        axios.get(`/boot/comment/insert?boardnum=${boardnum}&nickname=${nickname}&comment=${newComment}`)
            .then(res => {
                setNewcom('');
                setNickname('');
                getComment();
            })
    }

    useEffect(() => {
        if (newcom) {
            addComment(newcom);
        }
    }, [newcom]);

    useEffect(()=>{
        if(comidx){
            delComment(comidx)
        }
    },[comidx])
    //삭제 이벤트
    const delComment=(idx)=>{
        axios.get("/boot/comment/delete?idx="+idx)
        .then(res=>{
            alert("댓글이 삭제되었습니다.")
            getComment();
        })
    }


    return (
        <div>
            <Alert>상세보기</Alert>
            <table className="table table-boardered" style={{ width: '500px' }}>
                <tbody>
                    <tr>
                        <td colSpan={3} align="center" style={{ height: '60px', fontSize: '30px' }}>{list.subject}</td>
                    </tr>
                    <tr>
                        <td>작성자 : {list.writer}</td>
                        <td>작성일 : <span style={{ color: 'gray' }}>{list.writeday}</span></td>
                        <td>조회수 : {list.readcount}</td>
                    </tr>
                    <tr>
                        <td colSpan={3} style={{ height: '300px' }}>
                            <pre dangerouslySetInnerHTML={{ __html: list.content }} />
                            <img src={`${list.photo}` !== 'no' ? `${storage}/${list.photo}` : ''} alt="" />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3} align='center'>
                            <Button variant="outlined" color="secondary" onClick={() => navi('/board/list')} style={{ marginRight: '10px' }}>목록으로</Button>
                            <Button variant="outlined" color="error" onClick={() => navi('/board/form')} style={{ marginRight: '10px' }}>새 글쓰기</Button>
                            <Button variant="outlined" color="error" onClick={() => navi(`/board/updatepass/${boardnum}`)} style={{ marginRight: '10px' }}>수정</Button>
                            <Button variant="outlined" color="warning" onClick={handleClickOpen}>삭제</Button>
                            <Dialog
                                open={open}
                                onClose={handleClose}
                                PaperProps={{
                                    component: 'form',
                                    onSubmit: (event) => {
                                        event.preventDefault();
                                        const formData = new FormData(event.currentTarget);
                                        const formJson = Object.fromEntries(formData.entries());
                                        const pass = formJson.password;
                                        axios.get(`/boot/board/deletecheckpass?boardnum=${boardnum}&pass=${pass}`)
                                            .then(res => {
                                                if (res.data.result === 'success') {
                                                    alert("삭제되었습니다.")
                                                    navi("/board/list")
                                                } else {
                                                    alert("비밀번호가 일치하지 않습니다");
                                                    return;
                                                }
                                            })
                                        handleClose();
                                    },
                                }}
                            >
                                <DialogTitle>삭제 확인</DialogTitle>
                                <DialogContent>
                                    <DialogContentText>
                                        비밀번호를 입력해주세요
                                    </DialogContentText>
                                    <TextField
                                        autoFocus
                                        required
                                        margin="dense"
                                        id="name"
                                        name="password"
                                        label="password"
                                        type="password"
                                        fullWidth
                                        variant="standard"
                                    />
                                </DialogContent>
                                <DialogActions>
                                    <Button onClick={handleClose}>취소</Button>
                                    <Button type="submit">글 삭제</Button>
                                </DialogActions>
                            </Dialog>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table className="table table-bordered" style={{ width: '600px' }}>
                <thead>
                    <tr>
                        <th className="table-warning" style={{ width: '50px' }}>
                            번호
                        </th>
                        <th className="table-warning" style={{ width: '300px' }}>
                            내용
                        </th>
                        <th className="table-warning" style={{ width: '150px' }}>
                            닉네임/날짜
                        </th>
                        <th className="table-warning" style={{ width: '80px' }}>
                            수정/삭제
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        comment &&
                        comment.map((item, idx) =>
                            <tr key={idx}>
                                <td>{comment.length - idx}</td>
                                <td>{item.comment}</td>
                                <td style={{textAlign:'center'}}>{item.nickname}<br/><span style={{color:'gray'}}>{item.writeday}</span></td>
                                <td>
                                    <EditNote style={{cursor:'pointer'}} onClick={()=>{let com=window.prompt("댓글수정",item.comment);
                                        axios.post("/boot/comment/update",{comment:com,idx:item.idx})
                                        .then(res=>{
                                            getComment();
                                        })

                                    }}/>
                                    <HighlightOff style={{cursor:'pointer'}} onClick={()=>{setComidx(item.idx)}}/>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
            <table>
                <tbody>
                    <tr>
                        <td>
                            <input type="text" value={nickname} onChange={(e) => setNickname(e.target.value)} placeholder="닉네임" />
                            <Button variant="outlined" size="small" id="btnCheck" onClick={checkNick}>중복확인</Button>
                        </td>
                    </tr>
                    <tr>
                        <td style={{ width: '660px' }}>
                            <InputEmojiWithRef placeholder="제목을 입력 후 엔터를 눌러주세요"  value={newcom} onEnter={(text) => setNewcom(text)} />
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}

export default BoardDetail;
