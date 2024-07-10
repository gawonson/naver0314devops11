import { Button } from '@mui/material';
import './MyStyle.css'
const SixChildApp=(props)=>{
    let {carname,carphoto,carprice,onIncre,bgcolor}=props;
    return(
        <div className="box2"style={{backgroundColor:bgcolor}}>
            자동차명 : {carname}<br/>
            가 격 : {carprice}<br/>
            사 진 <br/>
            <img className='small2' alt='car' src={require(`../mycar/${carphoto}`)}/>
            <br/>
            <Button variant='outlined' color='error' size="small" onClick={onIncre}>방문</Button>
        </div>
    )
}
export default SixChildApp;