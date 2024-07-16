import { Alert } from "@mui/material";
import { useParams } from "react-router-dom";

const About =()=>{
    const {about1}=useParams();
    return(
        <div>
            <Alert severity="info">about</Alert>
            {
                about1==null?
                    <div>
                          <h2>저는 백수입니다</h2>
                    </div>
                :
                <div>
                        <h2>저는 현재 {about1}에 다니고있습니다</h2>
                </div>
            }
        </div>
    )
}
export default About;