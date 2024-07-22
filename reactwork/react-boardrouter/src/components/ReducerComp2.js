import { Alert, Button } from "@mui/material"
import { useReducer, useState } from "react";
import Student from './Student.js'
//reducer 설정시 초기값 미리 지정
const initialState={
    count:2,
    students:[
        {
            id:new Date(),
            name:'이영자',
            isHere:false
        },
        {
            id:new Date(),
            name:'candy',
            isHere:true
        }
    ]
}
const reducer=(state,action)=>{
    switch(action.type){
        //학생추가는 이름만 받아서 넣기
        case 'add-student':
            //payload를 통해서 name을 전달받을 예정
            const name=action.payload.name;
            //추가할 학생 정보구성
            const addStudent={
                id:new Date(),
                //name:name,
                name,//key, value가 같을경우 한번만
                isHere:false

            }
            const data={
                count:state.count+1,
                students:[
                    ...state.students,
                    addStudent
                ]
            }
            return data;
        //학생 삭제는 id값 받아 그거 빼고 다시 넣기
        case 'delete-student':
            return {
                count:state.count-1,
                students:state.students.filter(s=>s.id!=action.payload.id)
            };
        //isHere 빼고 다 그대로
        case 'mark-student':
            
            return {
                count:state.count,
                students:state.students.map(s=>{
                    if(s.id==action.payload.id){
                        return{
                            ...s,
                            isHere:!s.isHere
                        }
                    }
                    return s;
                })
            }
        default:
            return state;
    }
}
const ReducerComp2 =()=>{
    //필요한 state 변수
    const [name,setName]=useState('');
    const [studentInfo,dispatch]=useReducer(reducer,initialState);
    return(
        <div>
            <Alert>Reducer component #2</Alert>
            <h4>총 학생수 : {studentInfo.count}명</h4>
            <div className="input-group" style={{width:'230px'}}>
                <input type="text" value={name} className="form-control" onChange={(e)=>setName(e.target.value)}/>
                <Button variant="outlined" color="error" size="small" onClick={()=>{dispatch({'type':'add-student',payload:{name}});setName('');}} >추가</Button>
            </div>
            <div className="input-group" style={{width:'300px',marginTop:'20px'}}>
                <h5>학생 목록 출력</h5>
                {
                    studentInfo.students.map((stu,idx)=>
                    <Student key={idx} stu={stu} dispatch={dispatch}/>)
                }
            </div>
        </div>
    )
}

export default ReducerComp2;