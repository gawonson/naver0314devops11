import { DeleteForeverOutlined } from "@mui/icons-material";

const ThreeRowItem =(props)=>{
    let {idx,row,onDelete}=props;
    return(
        <tr>
            <td>{idx+1}</td>
            <td>{row.irum}</td>
            <td>{row.age}</td>
            <td>{row.blood}</td>
            <td>{row.today.toLocaleDateString("ko-KR")}</td>
            <td>
                <div onClick={()=>onDelete(idx)}><DeleteForeverOutlined/></div>
            </td>
        </tr>
    )
}
export default ThreeRowItem;