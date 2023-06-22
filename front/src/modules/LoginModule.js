import { createActions, handleActions } from "redux-actions";

const initialState = {
    loginInfo: {
        id: '',
        pwd: ''
    }
};

export const SET_ID = 'login/SET_ID';
export const SET_PWD = 'login/SET_PWD';
export const POST_LOGIN = 'login/POST_LOGIN';

const actions = createActions({
    [SET_ID]: () => {},
    [SET_PWD]: () => {},
    [POST_LOGIN]: () => {}

});


/* 리듀서 */
const loginReducer = handleActions(
    {
        
        [SET_ID]: (state, { payload }) => {

            state.loginInfo.id = payload;

            return {...state};
        },
        [SET_PWD]: (state, {payload}) => {
            
            state.loginInfo.pwd = payload;

            return {...state};
        },
        [POST_LOGIN]: (state, {payload}) => {
            

            return {...state};
        }
    },
    initialState
);

export default loginReducer;