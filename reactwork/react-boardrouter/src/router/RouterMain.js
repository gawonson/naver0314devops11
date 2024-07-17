import { Route, Router, Routes } from "react-router-dom";
import Menu from "../components/Menu";
import '../components/MyStyle.css';
import Home from "../components/Home";
import BoardForm from "../components/BoardForm";
import BoardList from "../components/BoardList";
import BoardDetail from "../components/BoardDetail";
const RouterMain =()=>{
    return(
        <div>
            <Menu/>
            <br style={{clear:'both'}}/>
            <Routes>
                <Route path="/" element={<Home/>}></Route>
                <Route path="/board">
                    <Route path="form" element={<BoardForm/>}/>
                    <Route path="list" element={<BoardList/>}/>
                    <Route path="detail/:boardnum" element={<BoardDetail/>}/>
                </Route>
            </Routes>
        </div>
    )
}
export default RouterMain;