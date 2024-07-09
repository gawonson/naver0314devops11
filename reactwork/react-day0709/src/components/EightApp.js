import './MyStyle.css';
const EightApp=()=>{
    const personArray=[
        {pname:"전지현",photo:"8.jpg",addr:"제주도 애월읍",age:45},
        {pname:"설현",photo:"15.jpg",addr:"부산 해운대구",age:26},
        {pname:"신민아",photo:"17.jpg",addr:"서울시 강남구",age:19},
        {pname:"수지",photo:"19.jpg",addr:"서울시 여의도",age:29},
        {pname:"강동원",photo:"9.jpg",addr:"경기도 용인시",age:41}
    ]
    return(
        <div>
            <h1 className="alert alert-info">오늘의 문제-배열</h1>
            <table className='table table-bordered' style={{width:'500px'}}>
                <tbody>
             <tr>
                <th>번호</th>
                <th>이름</th>
                <th>주소</th>
                <th>사진</th>
             </tr>
            {
                personArray.map((item,idx)=>   
                <tr>
                    <td>{idx+1}</td>
                    <td>{item.pname}</td>
                    <td>{item.addr}</td>
                    <td>
                        <img alt='' src={require(`../image/${item.photo}`)} className='smallphoto'/>
                    </td>
                </tr>
                )
            }
                </tbody>
            </table>
        </div>
    )
}
export default EightApp;