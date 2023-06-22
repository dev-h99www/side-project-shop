import axios from "axios";
import { POST_LOGIN, SET_ID, SET_PWD } from "../modules/LoginModule";
import { getServerAddr } from "../util/getServerAddr";

export function loginAPI(loginInfo) {

  const POST_LOGIN_URL = getServerAddr() + '/members/login';

  return async function login(dispatch, getState) {

    const result = await axios.post(POST_LOGIN_URL, loginInfo).catch(err => console.log(err));

    dispatch({type: POST_LOGIN, payload: result});
  }
}