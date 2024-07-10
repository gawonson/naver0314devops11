
import { Button } from '@mui/material';
import './MyStyle.css'
import { DeleteForeverOutlined } from '@mui/icons-material';

const SixChild2App=({row,idx,onDelete})=>{
    
    return(
        <tr style={{backgroundColor:row.color}}>
            <td>{row.cname}</td>
            <td>
                <img alt='img' className='small' src={require(`../mycar/${row.cphoto}`)}></img>
            </td>
            <td>
                {row.cprice}
            </td>
            <td>
                <Button variant='contained' color='error' startIcon={<DeleteForeverOutlined/>} onClick={()=>onDelete(idx)}>Del</Button>
            </td>
        </tr>
    )
}
export default SixChild2App;