
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import  Axios  from 'axios';
import { useEffect, useState } from 'react';


const Mycarphoto =()=>{
    const [itemData,setItemData]=useState([])
    let fileName='https://kr.object.ncloudstorage.com/bitcamp-gawon-136/mycar/';
    
    const MyCarList=()=>{
        Axios.get("/mycar/list")
        .then(res=>setItemData(res.data));
     }

            //처음 시작시 목록 가져오기-한번만 호출
            useEffect(()=>{
                MyCarList();
            },[]);



    return(
        <ImageList sx={{ width: 500, height: 450 }} cols={3} rowHeight={164}>
            {itemData.map((item,idx) => (
                <ImageListItem key={idx}>
                <img
                    srcSet={`${fileName}${item.carphoto}?w=164&h=164&fit=crop&auto=format&dpr=2 2x`}
                    src={`${fileName}${item.carphoto}?w=164&h=164&fit=crop&auto=format`}
                    alt={item.carphoto}
                    loading="lazy"
                />
                </ImageListItem>
            ))}
         </ImageList>
    )
}
export default Mycarphoto;