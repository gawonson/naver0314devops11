import './components/MyStyle.css'
import Menu from './components/Menu'
import { Route, Routes } from 'react-router-dom';
import {Food, Home, About, Mycar } from './pages';
import photo1 from './image/s5.JPG'
import photo2 from './image/s2.JPG'
import Member from './pages/Member';


const RouterMain =()=>{
    return(
        <div>
            <Menu/>
            <hr style={{clear:'both'}}/>
            <Routes>
                {/* 내가 등록한 주소 */}
                <Route path='/' element={<Home/>}/>
                {/* <Route path='/food' element={<Food/>}/> */}

                 {/* 파라미터 있을때 */}
                 <Route path='/food' element={<Food/>}>
                    <Route path=':food1' element={<Food/>}/>
                    <Route path=':food1/:food2' element={<Food/>}/>
                 </Route>
                
                <Route path='/about' element={<About/>}>
                    <Route path=':about1' element={<About/>}/>
                </Route>
                {/* 직접 태그를 써도됨 */}
                <Route path='/login/*' element={
                    <div>
                        <h2>로그인 메뉴입니다</h2>
                        <img src={photo1} alt=''/>
                        <About/>
                    </div>
                }/>
                <Route path='/mycar/*' element={<Mycar/>}/>

                <Route path='/member/*' element={<Member/>}/>
                
                {/* 그 이외의 모든 매핑주소에 대한 처리 */}
                <Route path='*' element={
                    <div>
                        <h2>잘못된 페이지입니다</h2>
                        <img alt='' src={photo2}/>
                    </div>
                }/>
            </Routes>
            
        </div>
    )
}
export default RouterMain; 