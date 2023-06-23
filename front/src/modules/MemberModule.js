import { createActions, handleActions } from "redux-actions";

const initialState = {
    memberInfo: {
        memberId: '',
        memberName: '',
        memberPassword: ''
    },
    isSignupSuccess: false,
    isSigninSuccess: false,
    loginInfo: {
        token: '',
        exprTime: 0,
        userInfo: {}
    }
};

export const SET_ID = 'members/SET_ID';
export const SET_NAME = 'members/SET_NAME';
export const SET_PWD = 'members/SET_PWD';
export const POST_LOGIN = 'members/POST_LOGIN';
export const POST_SIGNUP = 'members/POST_SIGNUP';
export const SET_SIGNUP_SUCCESS = 'members/SET_SIGNUP_SUCCESS';
export const SET_IS_SIGNIN = 'members/SET_IS_SIGNIN';

const actions = createActions({
    [SET_ID]: () => {},
    [SET_NAME]: () => {},
    [SET_PWD]: () => {},
    [POST_LOGIN]: () => {},
    [POST_SIGNUP]: () => {},
    [SET_SIGNUP_SUCCESS]: () => {},
    [SET_IS_SIGNIN]: () => {}

});


/* 리듀서 */
const memberReducer = handleActions(
    {
        
        [SET_ID]: (state, { payload }) => {

            state.memberInfo.memberId = payload;

            return {...state};
        },
        [SET_NAME]: (state, { payload }) => {

            state.memberInfo.memberName = payload;

            return {...state};
        },
        [SET_PWD]: (state, {payload}) => {
            
            state.memberInfo.memberPassword = payload;

            return {...state};
        },
        [POST_LOGIN]: (state, {payload}) => {

            state.isSigninSuccess = payload.data.result;
            state.loginInfo.token = payload.data.data.token;
            state.loginInfo.exprTime = payload.data.data.exprTime;
            state.loginInfo.userInfo = payload.data.data.user;

            console.log(state);
            return {...state};
        },
        [POST_SIGNUP]: (state, {payload}) => {
            
            state.isSignupSuccess = payload.data.result;

            return {...state};
        },
        [SET_SIGNUP_SUCCESS]: (state, {payload}) => {
            
            state.isSignupSuccess = !payload;

            return {...state};
        },
        [SET_IS_SIGNIN]: (state, {payload}) => {
            
            state.isSigninSuccess = payload;

            return {...state};
        }
    },
    initialState
);

export default memberReducer;