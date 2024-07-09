import { AccessAlarm, AddAlarm, Bookmark } from "@mui/icons-material";
import { Button } from "@mui/material";
import styled from "styled-components";

const OneApp=()=>{
    //h1 태그에 스타일을 추가해보자 
    //태그 자체를 만들 수 있는듯?
    const Title=styled.h1`
                                font-size:1.5em;
                                text-align:center;
                                color:orange;
                                background-color:pink;
                                `
    //버튼에 스타을 푸가
    const MyButton=styled.button`
                                    color:orange;
                                    width:200px;
                                    height:60px;
                                    border:1px solid hotpink;
                                    border-radius:30px;
                                    margin-top:10px;
                                    `
    //style 확장
    const MyButton2 = styled(MyButton)`
                                    color:blue;
                                    background-color:yellow;
                                    border:2px solid gray;                        
                                `
    //title 2
    const Title2=styled(Title)`
                                background-color:black;
                                color:white;
                                text-align:left;
                                font-family:East Sea Dokdo;
                                `
    return(
        <div>
            <h3 className="alert alert-info"><AccessAlarm/><AddAlarm/>OneApp-styled-components</h3>
            <h1>Hello H1</h1>
            <Title>Hello Title</Title>
            <hr/>
            <Button variant="outlined" color="secondary">Hello Button</Button>
            <Button variant="contained" color="success">Hello Button</Button>
            <br/>
            <MyButton>MyButton Styled</MyButton>
            <MyButton2>MyButton2 style</MyButton2>
            <Title2>Hello Title2</Title2>
        </div>
    )
}
export default OneApp;