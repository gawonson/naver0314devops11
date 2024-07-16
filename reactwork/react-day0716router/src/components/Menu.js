import { NavLink } from "react-router-dom";

const Menu =()=>{
    return(
        <div>
            <ul className="menu">
                <li>
                    <NavLink to={'/'}>Home</NavLink>
                </li>
                <li>
                    <NavLink to={'/food'}>Food</NavLink>
                </li>
                <li>
                    <NavLink to={'/food/11'}>Food #1</NavLink>
                </li>
                <li>
                    <NavLink to={'/food/2/4'}>Food #2</NavLink>
                </li>
                <li>
                    <NavLink to={'/about'}>About</NavLink>
                </li>
                <li>
                    <NavLink to={'/about/Samsung'}>About #2</NavLink>
                </li>
                <li>
                    <NavLink to={'/about/Naver'}>About #3</NavLink>
                </li>
                <li>
                    <NavLink to={'/member'}>member</NavLink>
                </li>
                <li>
                    <NavLink to={'/mycar'}>mycar</NavLink>
                </li>
            </ul>
        </div>
    )
}
export default Menu;