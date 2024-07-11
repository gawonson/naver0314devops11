import { useState } from "react";
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";

const Main=()=>{

    const [idx,setIdx]=useState(3);
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
                    <input type="radio" name="app" defaultValue={1} onClick={chageApp} value={2} />TwoApp
                </label>
                <br/>
                <label>
                    <input type="radio" name="app" defaultValue={1} onClick={chageApp} defaultChecked value={3}/>ThreeApp
                </label>
                <br/>
                <label>
                    <input type="radio" name="app" defaultValue={1} onClick={chageApp}  value={4}/>FourApp
                </label>
             
            </div>
            <hr/>
            {
                idx===1?<OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>:<FourApp/>
            }
        </div>
        
    )
}
export default Main;
