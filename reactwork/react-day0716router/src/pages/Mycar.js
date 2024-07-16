import { NavLink, Route, Routes } from "react-router-dom";
import Mycarlist from './Mycarlist';
import Mycarphoto from './Mycarphoto';
import { Alert } from "@mui/material";
const Mycar =()=>{
    return(
        <div>
            <Alert security="info">mycar</Alert>
            <div>
            <ul className="menu">
                <li>
                    <NavLink to={'/mycar/mycarphoto'} >목록1</NavLink>
                </li>
                <li>
                    <NavLink to={'/mycar/mycarlist'} >목록2</NavLink>
                </li>
            </ul>
            </div>
            <div style={{clear:'both'}}>
                <Routes>
                    <Route path="mycarphoto" element={<Mycarphoto/>}/> 
                    <Route path="mycarlist" element={<Mycarlist/>}/> 
                </Routes>
            </div>
        </div>
    )
}
export default Mycar;