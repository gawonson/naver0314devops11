import { Alert } from "@mui/material";
import image from '../image/s4.JPG'
import { NavLink, Route, Routes } from "react-router-dom";
import Moim1 from './Moim1';
import Moim2 from './Moim2';
import Moim3 from './Moim3';

// import '../components/MyStyle.css';
const Member =()=>{
    return(
        <div>
            <Alert severity="error" style={{fontSize:'20px'}}>저의 모임 목록입니다 - 중첩라우터 공부</Alert>
            <img alt="" src={image}/>
            <ul className="menu">
                <li>
                    <NavLink to={'/member/moim1'}>모임1</NavLink>
                </li>
                <li>
                    <NavLink to={'/member/moim2'}>모임2</NavLink>
                </li>
                <li>
                    <NavLink to={'/member/moim3'}>모임3</NavLink>
                </li>
            </ul>
            <div style={{clear:'both' , marginTop:'20px', width:'300px', backgroundColor:'orange'}}>
                <Routes>
                    <Route path='moim1' element={<Moim1/>}/>
                    <Route path='moim2' element={<Moim2/>}/>
                    <Route path='moim3' element={<Moim3/>}/>
                </Routes> 
            </div>
        </div>
    )
}
export default Member;