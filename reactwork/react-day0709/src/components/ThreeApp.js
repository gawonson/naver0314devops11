import { Alert, Switch } from "@mui/material";
import { useState } from "react";
import img1 from '../image/17.jpg';
import img2 from '../image/12.jpg';
const ThreeApp=()=>{
    const [show,setShow]=useState(true);
    const [visible,setVisible]=useState('visible');

    const photoStyle={
        width:'200px',
        height:'200px',
        border:'1px solid gray',
        borderRadius:'100px'
    }
    const photoCheckEvent=(e)=>{
        setShow(e.target.checked);
    }
    const photoSwitchEvent=(e)=>{
        setVisible(e.target.checked===true?'visible':'hidden')
    }


    return(
        <div>
            <Alert>ThreeApp</Alert>
            <Alert severity="info">이미지 show/hide하는 여러방법</Alert>
            <label>
                <input type="checkbox" defaultChecked onClick={photoCheckEvent}/>사진 1 보이기
                <br/>
              
            </label>
            {

                show&&

            <img src={img1} alt="img1" style={photoStyle}></img>

            }


            <hr/>
            <Switch color="warning" defaultChecked onChange={photoSwitchEvent}></Switch><br></br>
            <img src={img2} alt="img2" style={{width:'200px' , visibility:visible}}></img>
        </div>
    )
}
export default ThreeApp;