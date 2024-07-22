import { Alert, Button } from "@mui/material"

const Student =({stu,dispatch})=>{
    return(
        <div className="input-group" style={{width:'300px'}}>
            <div style={{textDecoration:stu.isHere===true?'line-through':'none', width:'130px',cursor:'pointer',color:stu.isHere==true?'gray':'black'}}
            onClick={()=>dispatch({type:'mark-student',payload:{id:stu.id}})}>
                {stu.name}
            </div>
            &nbsp;
            <Button variant="contained" color="success" size="small" onClick={()=>dispatch({type:'delete-student',payload:{id:stu.id}})}>삭제</Button>
        </div>
    )
}
export default Student;