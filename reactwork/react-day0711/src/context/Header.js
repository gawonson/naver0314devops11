import { useContext } from "react";
import { ThemeContext } from "./ThemeContext";
import { UserContext } from "./UserContext";

const Head =()=>{
    const {isDark}=useContext(ThemeContext);
    const username=useContext(UserContext);
    return(
        <div>
            <header className="header" style={{backgroundColor:isDark?'black':'lightgray'}}>
                <h1>안녕하세요 {username}님</h1>
            </header>
        </div>
    )
}
export default Head;