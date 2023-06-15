import { createActions, handleActions } from "redux-actions";

const initialState = {
    name: '상품이름',
    price: 1000,
    category: 1,
    no: 0,
    categorys: []
};

export const SET_NAME = 'product/SET_NAME';
export const SET_PRICE = 'product/SET_PRICE';
export const SET_CATEGORY = 'product/SET_CATEGORY';
export const POST_PRODUCT = 'product/REGIST_PRODUCT';
export const GET_REGIST_PRODUCT = 'product/GET_REGIST_PRODUCT';

const actions = createActions({
    [SET_NAME]: () => {},
    [SET_PRICE]: () => {},
    [SET_CATEGORY]: () => {},
    [POST_PRODUCT]: () => {},
    [GET_REGIST_PRODUCT]: () => {}

});


/* 리듀서 */
const productRegistReducer = handleActions(
    {
        [SET_NAME]: (state, { payload }) => {
            state.name = payload;
            console.log(payload);
            console.log(state);
            return {...state};
        },
        [SET_PRICE]: (state, { payload }) => {
            state.price = payload;
            return {...state};
        },
        [SET_CATEGORY]: (state, { payload }) => {
            state.category = payload;
            return {...state};
        },
        [POST_PRODUCT]: (state, { payload }) => {
            console.log(payload.data);
            state.no = payload.data.productNo;
            
            console.log(state);

            return {...state};
        },
        [GET_REGIST_PRODUCT]: (state, {payload}) => {
            state.categorys = payload.data;
            return {...state};
        }
    },
    initialState
);

export default productRegistReducer;