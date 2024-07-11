import {  CloseSharp} from "@mui/icons-material";
import { Button } from "@mui/material";

const OneSubApp = ({idx,item,deleteFunction}) => {
    return(
       <>
        <tr>
            <td rowSpan={4} align="center" style={{backgroundColor:'#ccf'}}>
                <img src={require(`../image/${item.sphoto}`)} alt="image" style={{width:'120px', height:'130px' , border:'1px solid gray'}}/>
                <br/>
                <div  onClick={()=>deleteFunction(idx)}><CloseSharp style={{cursor:'pointer'}}/></div>

            </td>
            <td>
                상품번호 : {idx+1}
            </td>
        </tr>
        <tr>
        <td>
                상품명 : {item.sname}
            </td>  
        </tr>
        <tr>
        <td>
                가격 : {item.sprice}
            </td>
        </tr>
        <tr>
            <td>
                상품색상 :<b style={{backgroundColor:item.scolor}}> {item.scolor}</b>
            </td>
        </tr>
       </>
    )
}
export default OneSubApp;