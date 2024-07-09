import { useState } from 'react';
import photo1 from '../image/1.jpg';



const TwoApp=()=>{
    const [photo,setPhoto]=useState('18');

    //radio 이벤트 
    const radioClick=(e)=>{
        setPhoto(e.target.value);
    }


    return(
        <div>
            <h3 className="alert alert-info">TwoApp-image를 불러오는 또다른 방법</h3>
            <h5>import 를 이용해서 가져오는 방법</h5>
            <img src={photo1} alt='photo1' style={{width:'100px'}}></img>
            <h5>require 를 이용해서 가져오는 방법</h5>
            <img alt="photo2" src={require(`../image/2.jpg`)} style={{width:'100px'}}></img>
            <hr/>
            <h5>radio를 이용해서 이미지 나타내기</h5>
            <label>
                <input type='radio' name='photo' defaultValue={'17'} onClick={radioClick}/>신민아&nbsp;
            </label>
            <label>
                <input type='radio' name='photo' defaultValue={'18'} defaultChecked onClick={radioClick}/>신세경&nbsp;
            </label>
            <label>
                <input type='radio' name='photo' defaultValue={'20'} onClick={radioClick}/>유아인&nbsp;
            </label>
            <label>
                <input type='radio' name='photo' defaultValue={'15'} onClick={radioClick}/>설현&nbsp;
            </label>

            <br/><br/>
            <img  alt="photo" src={require(`../image/${photo}.jpg`)} style={{width:'200px',marginLeft:'100px'}}></img>
        </div>
    )
}
export default TwoApp;