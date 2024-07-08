import logo from './logo.svg';
import './App.css';
// 사실 이 파일은 확장자만 js 이고 html태그를 인식하는 jsx이다
//JSA와 HTML의 차이점
/* 
1. 모든 요소는 짝이 맞아야함 <br></br>
 2. 특정 이름이 HTML언어 사양이 아닌 DOM APT에 기반을 둔다
 3. 태그 속성이 낙타표기법으로 표기를 한다 (카멜 표기법) 
 */
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
