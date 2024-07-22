import { useCallback, useState } from "react";
import Light from "./Light";

const SmartHome =()=>{
    const [masterOn,setMasterOn]=useState(false);
    const [kitchenOn,setKithenOn]=useState(false);
    const [bathOn,setBathOn]=useState(false);
    // const toggleMaster=()=>{
    //     setMasterOn(!masterOn);
    // }
    // const toggleKitchen=()=>{
    //     setKithenOn(!kitchenOn);
    // }
    // const togglebathOn=()=>{
    //     setBathOn(!bathOn);
    // }

    const toggleMaster=useCallback(()=>{
        setMasterOn(!masterOn);
    },[masterOn])

    const toggleKitchen=useCallback(()=>{
        setKithenOn(!kitchenOn);
    },[kitchenOn]);
    const togglebathOn=useCallback(()=>{
        setBathOn(!bathOn)
    },[bathOn]);
    return(
        <div style={{margin:'100px 100px'}}>
            <Light room={'침실'} on={masterOn} toggle={toggleMaster}/>
            <Light room={'주방'} on={kitchenOn} toggle={toggleKitchen}/>
            <Light room={'욕실'} on={bathOn} toggle={togglebathOn}/>
        </div>
    )
}
export default SmartHome;