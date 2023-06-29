import { createActions, handleActions } from "redux-actions";

const initialState = {
    memberInfo: {
        memberId: '',
        memberName: '',
        memberPassword: ''
    },
    isSignupSuccess: false,
    signupResultMessage: ''
};

export const SET_ID = 'members/SET_ID';
export const SET_NAME = 'members/SET_NAME';
export const SET_PWD = 'members/SET_PWD';
export const POST_SIGNUP = 'members/POST_SIGNUP';
export const SET_SIGNUP_SUCCESS = 'members/SET_SIGNUP_SUCCESS';

const actions = createActions({
    [SET_ID]: () => {},
    [SET_NAME]: () => {},
    [SET_PWD]: () => {},
    [POST_SIGNUP]: () => {},
    [SET_SIGNUP_SUCCESS]: () => {},

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
        [POST_SIGNUP]: (state, {payload}) => {
            state.signupResultMessage = payload.data.message;
            state.isSignupSuccess = payload.data.result;

            return {...state};
        },
        [SET_SIGNUP_SUCCESS]: (state, {payload}) => {
            
            state.isSignupSuccess = !payload;

            return {...state};
        }
    },
    initialState
);

export default memberReducer;