import { useRef } from 'react';
import cate from'../data/CateData.json'
import './MyStyle.css'
import errorImg from './no1.png'
const TwoApp = () => {
    const navData=cate.navData;
    const categoryData=cate.categoryData;
    //image ref
    const mainPhotoRef=useRef(null)

    return(
        <div>
            <h1>TwoApp-json Data 출력</h1>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        navData.map((item,i)=>
                            <li key={i}>
                                <div>
                                    <img src={item.img} alt='' className='imgcategory' onClick={(e)=>mainPhotoRef.current.src=e.target.src}/>
                                </div>
                                <div >
                                    {item.title}
                                </div>
                            </li>
                        )
                    }
                </ul>
            </div>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        categoryData.map((item,i)=>
                            <li key={i}>
                                <div>
                                    <img src={item.img} alt='' className='imgcategory' onMouseOver={(e)=>mainPhotoRef.current.src=e.target.src} />
                                </div>
                                <div >
                                    {item.title}
                                </div>
                            </li>
                        )
                    }
                </ul>
            </div>
            <div>
                <img src={mainPhotoRef} alt="" ref={mainPhotoRef}style={{width:'300px',height:'300px',border:'5px inset gray',margin:'10px 200px'}} onError={(e)=>e.target.src}/>

            </div>
        </div>
    )
}
export default TwoApp;