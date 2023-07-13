import { createActions, handleActions } from "redux-actions";

const initialState = {
    purchaseRegistInfo: {
      amount: 0
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
            state.purchaseRegistInfo.amount = payload;

            return {...state};
        },
        [POST_PURCHASE]: (state, {payload}) => {
            console.log(payload);
            
            return {...state};
        },
    },
    initialState
);

export default PurchaseModule;