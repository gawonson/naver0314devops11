import './MyStyle.css'

const TwoApp=()=>{
    let message="Have a GoodDay"
    return(
        <div>
            <h1 className="alert alert-info">TwoApp--function형태</h1>
            <div className='msg' style={{backgroundColor:'orange',border:'10px solid gray'}}>{message}</div>
            <div className='msg' style={{backgroundColor:'pink',color:'blue', boxShadow:'5px 5px 5px'}}>{message}</div>
            <div className='msg' style = {{border:'10px groove gold',borderRadius:'30px'}}>{message}</div>
        </div>
    )
}
export default TwoApp;