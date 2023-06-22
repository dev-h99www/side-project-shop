import { createActions, handleActions } from "redux-actions";

const initialState = {
    pageInfo: {
        page: 1,
        totalItemCount: 1,
        pageItemCount: 10,
        type: ''
      },
    products: [],
    product: {
        productNo: 0,
        productName: '',
        productPrice: 0,
        productCategory: {productCategoryNo: 0, productCategoryName: ''},
        productStatus: {productStatusNo: 0, productStatusName: ''}
    }
}


export const GET_PRODUCTS = 'products/GET_PRODUCTS';
export const PAGE_CHANGE = 'products/PAGE_CHANGE';
export const GET_PRODUCTS_COUNT = 'products/GET_PRODUCTS_COUNT';
export const GET_PRODUCT = 'products/GET_PRODUCT';

const actions = createActions({
    [GET_PRODUCTS]: () => {},
    [PAGE_CHANGE]: () => {},
    [GET_PRODUCT]: () => {},
    [GET_PRODUCTS_COUNT]: () => {}

});

const productFindReducer = handleActions(
    {
        [GET_PRODUCTS]: (state, {payload}) => {
            
            state.products = payload.data;

            return {...state};
        },
        [GET_PRODUCT]: (state, {payload}) => {

            state.product = payload.data;

            return {...state};
        },
        [PAGE_CHANGE]: (state, {payload}) => {

            state.pageInfo.page = payload;

            return {...state};
        },
        [GET_PRODUCTS_COUNT]: (state, {payload}) => {

            state.pageInfo.totalItemCount = payload.data;

            return {...state};
        }
    },
    initialState
);

export default productFindReducer;