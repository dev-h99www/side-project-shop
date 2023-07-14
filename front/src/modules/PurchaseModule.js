import { createActions, handleActions } from "redux-actions";

const initialState = {
    registInfo: {
      amount: 0
    },
    registResult: {
        registInfo: {},
        result: false,
        message: ""
    },
    userPurchases: {
        searchInfo: {
            page: 1,
            totalItemCount: 1,
            pageItemCount: 10,
            categoryNo: 0,
            statusNo: 0,
            searchValue: '',
            userNo: 0
        },
        purchases: []
    }
}

export const SET_PRODUCT_AMOUNT = 'products/SET_PRODUCT_AMOUNT';
export const POST_PURCHASE = 'products/POST_PURCHASE';
export const GET_PURCHASES = 'products/GET_PURCHASES';
export const SET_USER_NO = 'products/SET_USER_NO';
export const PAGE_CHANGE = 'products/PAGE_CHANGE';

const actions = createActions({
    [SET_PRODUCT_AMOUNT]: () => {},
    [POST_PURCHASE]: () => {},
    [GET_PURCHASES]: () => {},
    [SET_USER_NO]: () => {},
    [PAGE_CHANGE]: () => {},

});


const PurchaseModule = handleActions(
    {
        [PAGE_CHANGE]: (state, {payload}) => {
            state.userPurchases.searchInfo.page = payload;

            return {...state};
        },
        [SET_PRODUCT_AMOUNT]: (state, {payload}) => {
            state.registInfo.amount = payload;

            return {...state};
        },
        [POST_PURCHASE]: (state, {payload}) => {
            const{data, message, result} = payload;

            state.registResult.registInfo = data;
            state.registResult.message = message;
            state.registResult.result = result;
            return {...state};
        },
        [GET_PURCHASES]: (state, {payload}) => {
            const{data} = payload;
            state.userPurchases.searchInfo = data.pageInfo;
            state.userPurchases.purchases = data.purchases;

            return {...state};
        },
        [SET_USER_NO]: (state, {payload}) => {
            state.userPurchases.searchInfo.userNo = payload;

            return {...state};
        },
    },
    initialState
);

export default PurchaseModule;