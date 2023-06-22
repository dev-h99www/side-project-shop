import { useSelector, useDispatch } from 'react-redux';
import LoginCSS from './LoginCSS.module.css';
import { SET_ID, SET_PWD } from '../modules/MemberModule.js';
import { loginAPI } from '../apis/MemberAPICALL'
import { useNavigate } from 'react-router-dom';

function Login() {

  const { memberInfo } = useSelector(state => state.memberReducer);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const  loginBtnHandler = () => {
    dispatch(loginAPI(memberInfo));
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