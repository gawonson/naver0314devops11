import './MyStyle.css'
import con from '../data/PostingData.json'
import { fontSize } from '@mui/system';
const FourApp = () => {
    const deal=con.deal;
    return(
        <div>
            <h1>FourApp-JsonData 읽기 문제</h1>

            {
                deal.map((item,i)=>
                    <div style={{float:'left' , fontSize:'12px'}}  >
                        <img src={item.img} alt='' style={{width:'300px'}}/>
                        <br/>
                            <h6 style={{color:'gray',fontSize:'10px'}}>{item.company}</h6>
                            <br/>
                            <b style={{fontSize:'13px'}}>{item.title}</b><br/>
                            <b style={{color:'aquamarine'}}>{item.sale}</b>
                            <b>&nbsp;{item.price}</b><br/>
                    </div>

                    )
            }
            </div>

    )
}
export default FourApp;