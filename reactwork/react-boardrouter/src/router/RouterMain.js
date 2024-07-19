import { Route, Router, Routes } from "react-router-dom";
import Menu from "../components/Menu";
import '../components/MyStyle.css';
import Home from "../components/Home";
import BoardForm from "../components/BoardForm";
import BoardList from "../components/BoardList";
import BoardDetail from "../components/BoardDetail";
import Cal from "../components/Cal";
import UpdatePassForm from "../components/UpdatePassForm";
import UpdateForm from "../components/UpdateForm";
import DaumPostApp from "../components/DaumPostApp";
import SweetAlertApp from "../components/SweetAlertApp";
const RouterMain =()=>{
    return(
        <div>
            <Menu/>
            <br style={{clear:'both'}}/>
            <Routes>
                <Route path="/" element={<Home/>}></Route>
                <Route path="/board">
                    <Route path="updatepass/:boardnum" element={<UpdatePassForm/>}/>
                    <Route path="form" element={<BoardForm/>}/>
                    <Route path="list" element={<BoardList/>}/>
                    <Route path="detail/:boardnum" element={<BoardDetail/>}/>
                    <Route path="cal" element={<Cal/>}/>
                    <Route path="updateform/:boardnum" element={<UpdateForm/>}/>
                </Route>
                <Route path="/post" element={<DaumPostApp/>}/>
                <Route path="/sweet" element={<SweetAlertApp/>}/>
            </Routes>
        </div>
    )
}
export default RouterMain;