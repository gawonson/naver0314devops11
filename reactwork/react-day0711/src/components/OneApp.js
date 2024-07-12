import { Alert, Button } from '@mui/material';
import { useState } from "react";
import OneSubApp from './OneSubApp';

const OneApp = () => {

      //삭제
      const deleteItem=(e)=>{
        let a=window.confirm((e+1)+"번째 상품을 삭제하시겠습니까?")
        if(a){
        setInputArray(inputArray.filter((m,n)=>n!==e))}
        else
        return;
    }

    const [inputArray,setInputArray]=useState([
        {
            sname:"신상슈즈",
            sphoto:"15.jpg",
            sprice:23000,
            scolor:"orange"
        }
    ]);
    const [inputs,setInputs]=useState({
        sname:"",
        sphoto:"",
        sprice:0,
        scolor:"#ffcccc"
    })

    //각 입력태그에서 호출 할 이벤트
    const chageDataEvent=(e)=>{
        let {name,value}=e.target;
        setInputs(
            {
                ...inputs,
                [name]:value//같은 name을 찾아서 value값을 넣는다.
            }
        )
    }

    //상품추가
    const addSangpumEvent=(e)=>{
        setInputArray(inputArray.concat(inputs));
    }

    //입력값 초기화버튼 이벤트
    const initDataEvent=(e)=>{
        setInputs({
            sname:"",
            sphoto:"14.jpg",
            sprice:0,
            scolor:"#ffcccc"
        })
    }
  
    return(
        <div>
            <h1>OneApp-모든 입력값 하나의 변수에 넣기/객체 배열 출력-tr의 row span</h1>
            <table className="table table-bordered" style={{width:'300px'}}>
                <tbody>
                    <tr>
                        <th style={{backgroundColor:'#ccf',width:'100px'}}>상품명</th>
                        <td>
                            <input type="text" className="form-control" value={inputs.sname} name="sname" onChange={chageDataEvent}></input>
                        </td>
                    </tr>
                    <tr>
                        <th style={{backgroundColor:'#ccf',width:'100px'}}>색상</th>
                        <td>
                            <input type="color" className="form-control" value={inputs.scolor} name="scolor" onChange={chageDataEvent}></input>
                        </td>
                    </tr>
                    <tr>
                        <th style={{backgroundColor:'#ccf',width:'100px'}}>가격</th>
                        <td>
                            <input type="text" className="form-control" value={inputs.sprice} name="sprice" onChange={chageDataEvent}></input>
                        </td>
                    </tr>
                    <tr>
                        <th style={{backgroundColor:'#ccf',width:'100px'}}>사진</th>
                        <td>
                            <select className="form-select" name="sphoto" onChange={chageDataEvent} value={inputs.sphoto}>
                                <option value={'14.jpg'}>플렛슈즈</option>
                                <option value={'23.jpg'}>여름용모자</option>
                                <option value={'30.jpg'}>보석머리띠</option>
                                <option value={'32.jpg'}>투피스</option>
                                <option value={'31.jpg'}>자켓</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align="center">
                            <Button variant="contained" color="success" onClick={addSangpumEvent}>상품추가</Button>
                            <Button variant="contained" color="info" onClick={initDataEvent}>입력값 초기화</Button>
                        </td>
                    </tr>
                    {/* <tr>
                        <td colSpan={2} align="center">
                            <h4>
                                상품명 : {inputs.sname}<br/>
                                색 상 : {inputs.scolor}<br/>
                                가 격 : {inputs.sprice}<br/>
                                사 진 : {inputs.sphoto}<br/>
                            </h4>
                        </td>
                    </tr> */}
                </tbody>
            </table>
            <h4>총 {inputArray.length}개의 배열 데이터가 있습니다</h4>
            <table className='table table-stripted' style={{width:'400px'}}>
                    <tbody>
                        {
                            inputArray.map((item,idx)=>
                            <OneSubApp key={idx} idx={idx} item={item} deleteFunction={deleteItem}/>
                            )
                        }
                    </tbody>
            </table>
        </div>
    )
}
export default OneApp;