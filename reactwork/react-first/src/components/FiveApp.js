import { useState } from 'react';
import car1  from '../mycar1.png'

const FiveApp=()=>{
    const [show,setShow]=useState(true);
    const [fcolor,setFcolor]=useState("red");
    const [fname,setFname]=useState("Gamja Flower");
    const [bcolor,setBcolor]=useState("#afeeee")
    let message= "오늘은 react를 공부 중입니당!!"
    return(
        <div>
            <h1 className="alert alert-warning">FiveApp-글꼴변경</h1>
            <button type='button' className='btn btn-sm btn-info' onClick={()=>{setShow(!show)}}>show/hide</button>
            {
                show&&
                <img alt='car' src={car1} style={{width:'200px'}}></img>
                
            }
            <hr/>
            <div style={{fontSize:'30px', color:fcolor,fontFamily:fname,backgroundColor:bcolor}}>
                {message}
            </div>
            <br>
            </br>
            <h5>select 이벤트를 이용해서 글꼴변경하기</h5>
            <div className='input-group' style={{width:'300px'}}>
                <select className='form-select' style={{width:'120px'}} onChange={(e)=>{setFname(e.target.value)}}>
                    <option>East Sea Dokdo</option>
                    <option>Jua</option>
                    <option selected>Gamja Flower</option>
                    <option>Single Day</option>
                    <option>Gaegu</option>
                </select>
                &nbsp;&nbsp;
                <select className='form-select' style={{width:'120px'}} onChange={(e)=>{setFcolor(e.target.value)}}>
                    <option>green</option>
                    <option>orange</option>
                    <option selected>red</option>
                    <option>purple</option>
                    <option>hotpink</option>
                </select>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' defaultValue='#afeeee' name='bcolor' defaultChecked onClick={(e)=>{setBcolor(e.target.value)}}/>하늘색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' defaultValue='#fffacd' name='bcolor' onClick={(e)=>{setBcolor(e.target.value)}}/>노란색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type='radio' defaultValue='#90ee90' name='bcolor' onClick={(e)=>{setBcolor(e.target.value)}}/>그린색
                </label>
            </div>
        </div>
    )
}
export {FiveApp};