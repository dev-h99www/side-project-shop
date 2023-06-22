import { useDispatch, useSelector } from 'react-redux';
import { SET_ID, SET_NAME, SET_PWD, SET_SIGNUP_SUCCESS } from '../modules/MemberModule';
import SignupCSS from './SignupCSS.module.css';
import { useNavigate } from 'react-router-dom';
import { signupAPI } from '../apis/MemberAPICALL';
import { useEffect } from 'react';

function Signup() {

  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { memberInfo, isSignupSuccess } = useSelector(state => state.memberReducer)
  
  const signUpBtnHandler = () => {
    dispatch(signupAPI(memberInfo));
  };

  const backBtnHandler = () => {
    navigate('/');
  };

  useEffect(
    () => {
      if(isSignupSuccess) {
        alert('sign up success');
        navigate('/');
        dispatch({type: SET_SIGNUP_SUCCESS, payload: isSignupSuccess});
      } 
    },[isSignupSuccess]
  );
  return(
  <div>
    <div className={SignupCSS.headArea}>
        회원가입
    </div>
    <hr/>
    <div className={SignupCSS.bodyArea}>
        <div className={SignupCSS.loginFormArea}>
          <label className={SignupCSS.loginInputLabel}>아이디</label>
          <input onChange={ e => dispatch({type: SET_ID, payload: e.target.value}) } className={SignupCSS.loginInputBox} type="text"/>

          <br/>

          <label className={SignupCSS.loginInputLabel}>이름
          </label><input onChange={ e => dispatch({type: SET_NAME, payload: e.target.value}) } className={SignupCSS.loginInputBox} type="text"/>
          
          <br/>

          <label className={SignupCSS.loginInputLabel}>비밀번호
          </label><input onChange={ e => dispatch({type: SET_PWD, payload: e.target.value}) } className={SignupCSS.loginInputBox} type="password"/>

          <br/>
          <br/>       

          <button onClick={ backBtnHandler } className={SignupCSS.signUpBtn}>뒤로가기</button>
          <button onClick={ signUpBtnHandler } className={SignupCSS.signUpBtn}>회원가입</button>
        </div>
      </div>
  </div>
  );
}

export default Signup;