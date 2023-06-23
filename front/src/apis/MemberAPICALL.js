import axios from "axios";
import { POST_SIGNUP } from "../modules/MemberModule";
import { getServerAddr } from "../util/getServerAddr";

export function loginAPI(memberInfo) {

  const POST_LOGIN_URL = getServerAddr() + '/members/login';

  return axios.post(POST_LOGIN_URL, memberInfo).catch(err => console.log(err));

  // return async fun
}

export function signupAPI(memberInfo) {

  const POST_SIGNUP_URL = getServerAddr() + '/members/signup';

  return async function signup(dispatch, getState) {

    const result = await axios.post(POST_SIGNUP_URL, memberInfo).catch(err => console.log(err));

    dispatch({type: POST_SIGNUP, payload:result});
  }
}