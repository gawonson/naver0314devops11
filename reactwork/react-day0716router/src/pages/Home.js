import { Alert, Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

const Home =()=>{
    const navi=useNavigate();
    return(
        <div>
            <Alert severity="warning">Home</Alert>
            <h3>페이지 이동 연습</h3>
            <Button variant="contained" size="small" color="success" onClick={()=>navi('/about')}>About page로 이동</Button><br/>
            <Button variant="contained" size="small" color="error" onClick={()=>navi('/mycar')}>Mycar page로 이동</Button><br/>
            <Button variant="contained" size="small" color="warning" onClick={()=>navi('/member/moim1')}>member page로 이동</Button><br/>
        </div>
    )
}
export default Home;