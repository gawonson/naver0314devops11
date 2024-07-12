import { useState } from "react";
import ThreeWriteForm from "./ThreeWriteForm";
import ThreeRowItem from "./ThreeRowItem";

const ThreeApp = () => {
        const[dataArray,setDataArray]=useState([
            {irum:'이영자',blood:'AB',age:34,today: new Date()},
            {irum:'강호동',blood:'O',age:44,today: new Date()},
            {irum:'유재석',blood:'B',age:14,today: new Date()}
        ])
        //삭제이벤트
        const deleteData=(idx)=>{
            setDataArray(dataArray.filter((d,i)=>i!==idx));
        }

        //추가버튼 이벤트
        const addData=(data)=>{
            setDataArray(dataArray.concat({
                ...data,
                today:new Date()
            }))
        }
    return(
        <div>
            <h1>ThreeApp-data추가,삭제,출력(부모,자식 컴포넌트)</h1>
            {/* 입력폼 컴포넌트 */}
            <ThreeWriteForm onAdd={addData}/>
            <hr/>
            <table className="table table-striped" style={{width:'450px'}}>
                <thead>
                    <tr className="table-danger">
                        <th style={{width:'50px'}}>번호</th>
                        <th style={{width:'80px'}}>이름</th>
                        <th style={{width:'60px'}}>나이</th>
                        <th style={{width:'70px'}}>혈액형</th>
                        <th style={{width:'100px'}}>등록일</th>
                        <th >삭제</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        dataArray.map((row,idx)=>
                            <ThreeRowItem key={idx} idx={idx} row={row} onDelete={deleteData} />
                        )
                    }
                </tbody>
            </table>



        </div>
    )
}
export default ThreeApp;