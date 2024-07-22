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
import ReducerComp1 from "../components/ReducerComp1";
import ReducerComp2 from "../components/ReducerComp2";
import MemoTest from "../components2/MemoTest";
import ShowState from "../components2/ShowState";
import CallBackTest from "../components2/CallBackTest";
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
                <Route path="/reducer1" element={<ReducerComp1/>}/>
                <Route path="/reducer2" element={<ReducerComp2/>}/>
                <Route path="/usememo" element={<MemoTest/>}/>
                <Route path="/callback" element={<CallBackTest/>}/>

            </Routes>
        </div>
    )
}
export default RouterMain;