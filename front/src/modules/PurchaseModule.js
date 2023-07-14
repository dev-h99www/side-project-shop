import { createActions, handleActions } from "redux-actions";

const initialState = {
    registInfo: {
      amount: 0
    },
    registResult: {
        registInfo: {},
        result: false,
        message: ""
    }
}

export const SET_PRODUCT_AMOUNT = 'products/SET_PRODUCT_AMOUNT';
export const POST_PURCHASE = 'products/POST_PURCHASE';

const actions = createActions({
    [SET_PRODUCT_AMOUNT]: () => {},
    [POST_PURCHASE]: () => {},

});


const PurchaseModule = handleActions(
    {
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
    },
    initialState
);

export default PurchaseModule;