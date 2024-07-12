import { useState } from "react";
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import Root from "../context/Root"
import FiveApp from "./FiveApp";
const Main=()=>{

    const [idx,setIdx]=useState(6);
    const chageApp=(e)=>{
        setIdx(Number(e.target.value));
    }
    return(
        <div>
            <h2>2024-07-11 리액트 수업</h2>
            <div>
                <label>
                    <input type="radio" name="app"  onClick={chageApp} value={1} />OneApp
                </label>
                <br/>
                <label>
                    <input type="radio" name="app" defaultValue={1} onClick={chageApp}  value={2} />TwoApp
                </label>
                <br/>
                <label>
                    <input type="radio" name="app" defaultValue={1} onClick={chageApp}  value={3}/>ThreeApp
                </label>
                <br/>
                <label>
                    <input type="radio" name="app" defaultValue={1} onClick={chageApp} value={4}/>FourApp
                </label>
                <br/>
                <label>
                    <input type="radio" name="app" defaultValue={1} onClick={chageApp}  value={5}/>Root
                </label>
                <br/>
                <label>
                    <input type="radio" name="app" defaultValue={1} onClick={chageApp} defaultChecked value={6}/>FiveApp
                </label>
                <br/>
            </div>
            <hr/>
            {
                idx===1?<OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>:idx===4?<FourApp/>:idx===5?<Root/>:<FiveApp/>
            }
        </div>
        
    )
}
export default Main;
