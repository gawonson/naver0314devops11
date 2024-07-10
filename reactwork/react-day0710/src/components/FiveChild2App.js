import './MyStyle.css';
// const FiveChild2App =({photo,msg})=>{
    const FiveChild2App =(props)=>{
        let {photo,msg}=props;
        return(

        <div className="box1">
            <img className='small' alt='img1' src={require(`../mycar/${photo}`)}></img>
            <b>{msg}</b>
        </div>
    )
}
export default FiveChild2App;