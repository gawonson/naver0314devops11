import { NavLink } from "react-router-dom";

const Menu =()=>{
    return(
        <ul className="main_menu">
            <li>
                <NavLink to={"/"}>Home</NavLink>
            </li>
            <li>
                <NavLink to={"/board/form"}>글쓰기</NavLink>
            </li>
            <li>
                <NavLink to={"/board/list"}>목록</NavLink>
            </li>
            <li>
                <NavLink to={"/board/cal"}>달력</NavLink>
            </li>
            <li>
                <NavLink to={"/post"}>카카오주소</NavLink>
            </li>
            <li>
                <NavLink to={"/sweet"}>SweetAlert</NavLink>
            </li>
            <li>
                <NavLink to={"/reducer1"}>ReducerComp1</NavLink>
            </li>
            <li>
                <NavLink to={"/reducer2"}>ReducerComp2</NavLink>
            </li>
            <li>
                <NavLink to={"/usememo"}>usememo</NavLink>
            </li>
            <li>
                <NavLink to={"/callback"}>callback</NavLink>
            </li>
       
        </ul>
    )
}
export default Menu;