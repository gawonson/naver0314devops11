import { useState } from 'react';
import img1 from '../1.jpg';
import img2 from '../2.jpg';
import img3 from '../17.jpg';
import img4 from '../18.jpg';




const SixApp=()=>{

    const [photo,setPhoto]=useState(img1);
    const [border,setborder]=useState('dotted');
    const [show,setShow]=useState(true);
    const [message,setMessage]=useState("리액트 문제 다 풀면 복습 100%보장")
    const [fsize,setFsize]=useState(20);

    return(
        <div style={{padding:'20px'}}>
            <h1 className="alert alert-warning">SixApp-문제</h1>
            <hr></hr>
            <h1 style={{color:'hotpink',fontFamily:'East Sea Dokdo'}}>오늘의 문제</h1>
            <hr/>
            &nbsp;<input type='checkbox' value={show} onChange={(e)=>{setShow(!show)}}/>&nbsp;사진 숨김
            
            <button type='button' className='btn btn-outline-danger' style={{marginLeft:'600px'}} onClick={()=>{setFsize(fsize-2)}}>점점 작게</button>
            <button type='button' className='btn btn-outline-danger' style={{marginLeft:'30px'}}  onClick={()=>{setFsize(fsize+2)}}>점점 크게</button><br/><br/>
            <input type='text' placeholder={message} value={message} style={{width:'800px',height:'60px'}} onChange={(e)=>{setMessage(e.target.value)}}></input><br/>
            <table style={{width:'1000px'}}>
                <tbody>
                    <tr>
                        <td style={{width:'300px'}}>
                            <select className='form form-select' style={{width:'250px'}} onChange={(e)=>{setPhoto(e.target.value)}}>
                                <option value={img1}>여진구</option>
                                <option value={img2}>김우빈</option>
                                <option value={img3}>신민아</option>
                                <option value={img4}>신세경</option>
                            </select>
                        </td>
                        <td rowSpan={2}>
                        {
                            show&&
                            <img src={photo} style={{width:'300px' , border:`10px ${border} pink`}}></img>
                            }
                        </td>
                    </tr>
                    <tr>
                        <td style={{width:'300px'}}>
                            <select className='form form-select' style={{width:'250px'}} onChange={(e)=>{setborder(e.target.value)}}>
                                <option selected>dotted</option>
                                <option>solid</option>
                                <option>dashed</option>
                                <option>inset</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2}>
                            <h1 className='alert alert-info' style={{fontSize:`${fsize}px`}}>{message}</h1>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}

export default SixApp;