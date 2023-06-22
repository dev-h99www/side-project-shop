import { useSelector, useDispatch } from 'react-redux';
import LoginCSS from './LoginCSS.module.css';
import { SET_ID, SET_PWD } from '../modules/LoginModule.js';
import { loginAPI } from '../apis/LoginAPICALL'

function Login() {

  const { loginInfo } = useSelector(state => state.loginReducer);
  const dispatch = useDispatch();

  const  loginBtnHandler = () => {
    dispatch(loginAPI(loginInfo));
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

          <button className={LoginCSS.loginButton}>회원가입</button>
          <button onClick={ loginBtnHandler } className={LoginCSS.loginButton}>로그인</button>
        </div>
      </div>
    </div>
  );
}

export default Login;