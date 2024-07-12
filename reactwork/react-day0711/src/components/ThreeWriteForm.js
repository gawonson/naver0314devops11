import { useState } from "react";

const ThreeWriteForm =(props)=>{
    let {onAdd}=props
    const [irum,setIrum]=useState('');
    const [blood,setBlood]=useState('A');
    const [age,setAge]=useState('');

    const addDataEvent=(e)=>{
        onAdd({irum,age,blood})
        //초기화
        setIrum("");
        // setBlood("A");
        setAge("");
    }
    return(

        <div className="input-group" style={{width:'450px'}} >
            <h5>이름</h5>
            <input type='text' className="form-control" style={{width:'80px'}} value={irum} onChange={(e)=>setIrum(e.target.value)}/>
            <h5>나이</h5>
            <input type='text' className="form-control" style={{width:'50px'}} value={age} onChange={(e)=>setAge(e.target.value)}/>
            <h5>혈액형</h5>
            <select className="form-select" value={blood} onChange={(e)=>setBlood(e.target.value)}>
                <option >A</option>
                <option >B</option>
                <option >O</option>
                <option >AB</option>
            </select>
            <button type="button" className="btn btn-sm btn-success" onClick={addDataEvent}>추가</button>
        </div>

    )
}
export default ThreeWriteForm;