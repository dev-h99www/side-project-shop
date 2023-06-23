import { useSelector, useDispatch } from 'react-redux';
import LoginCSS from './LoginCSS.module.css';
import { POST_LOGIN, SET_ID, SET_PWD } from '../modules/MemberModule.js';
import { loginAPI } from '../apis/MemberAPICALL'
import { useNavigate } from 'react-router-dom';
import { getCookie, setCookie } from '../cookies/cookie';
import { Cookies } from'react-cookie';
import jwtDecode from 'jwt-decode';

function Login() {

  const { memberInfo } = useSelector(state => state.memberReducer);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  
  const  loginBtnHandler = async () => {
    await loginAPI(memberInfo).then((res) => {

      const {data, result} = res.data;
      const generatedToken = data.token;
      const expires = new Date();
      expires.setMilliseconds(expires.getMilliseconds() + data.exprTime);

      if(result == false) {
        alert("아이디와 비밀번호를 확인하세요.");
      }


      if(generatedToken != undefined && generatedToken != null) {
        
        dispatch({type: POST_LOGIN, payload: res});
        setCookie('token', generatedToken, { expires })
        window.location.replace('/');
      }

    })
    .catch((err) => {
      alert('login error');
    })
  }

  const signUpBtnHandler = () => {
    navigate("/signup");            
  }
  return (
    <div>
      <div className={LoginCSS.headArea}>
          로그인
      </div>
      <hr/>
      <div className={LoginCSS.bodyArea}>
        <div className={LoginCSS.loginFormArea}>
          <label className={LoginCSS.loginInputLabel}>아이디</label>
          <input onChange={ e => dispatch({type: SET_ID, payload: e.target.value}) } className={LoginCSS.loginInputBox} type="text"/>

          <br/>

          <label className={LoginCSS.loginInputLabel}>비밀번호
          </label><input onChange={ e => dispatch({type: SET_PWD, payload: e.target.value}) } className={LoginCSS.loginInputBox} type="password"/>

          <br/>
          <br/>      

          <button onClick={ signUpBtnHandler } className={LoginCSS.loginButton}>회원가입</button>
          <button onClick={ loginBtnHandler } className={LoginCSS.loginButton}>로그인</button>
        </div>
      </div>
    </div>
  );
}

export default Login;