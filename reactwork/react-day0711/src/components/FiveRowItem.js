const FiveRowItem =({mycar})=>{
    const storage="https://kr.object.ncloudstorage.com/bitcamp-gawon-136/mycar/";
    return(
        <>
        <tr>
            <td style={{width:'200px'}} align="center" rowSpan={5}>
                <img alt="" style={{width:'180px',height:'180px'}} src={`${storage}${mycar.carphoto}`}/>
            </td>
        </tr>
        <tr>
            <td>차 이름 : {mycar.carname}</td>
        </tr>
        <tr>
            <td>차 가격 : {mycar.carprice}만원</td>
        </tr>
        <tr>
            <td style={{backgroundColor:`${mycar.carcolor}`}}>{mycar.carcolor}</td>
        </tr>
        <tr>
            <td style={{fontSize:'13px'}}>등록일 : {mycar.writeday}</td>
        </tr>
        </>
    )
}
export default FiveRowItem;