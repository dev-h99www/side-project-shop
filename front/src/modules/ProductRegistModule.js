import { createActions, handleActions } from "redux-actions";

const initialState = {
    name: '상품이름',
    price: 1000,
    category: 1,
    no: 0,
    categories: []
};

export const SET_NAME = 'product/SET_NAME';
export const SET_PRICE = 'product/SET_PRICE';
export const SET_CATEGORY = 'product/SET_CATEGORY';
export const POST_PRODUCT = 'product/POST_PRODUCT';
export const GET_CATEGORIES = 'product/GET_CATEGORIES';

const actions = createActions({
    [SET_NAME]: () => {},
    [SET_PRICE]: () => {},
    [SET_CATEGORY]: () => {},
    [POST_PRODUCT]: () => {},
    [GET_CATEGORIES]: () => {}

});


/* 리듀서 */
const productRegistReducer = handleActions(
    {
        [SET_NAME]: (state, { payload }) => {

            state.name = payload;

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

            state.no = payload.data.data.productNo;
            
            return {...state};
        },
        [GET_CATEGORIES]: (state, {payload}) => {

            state.categories = payload.data;

            return {...state};
        }
    },
    initialState
);

export default productRegistReducer;