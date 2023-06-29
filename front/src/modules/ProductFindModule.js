import { createActions, handleActions } from "redux-actions";

const initialState = {
    pageInfo: {
        page: 1,
        totalItemCount: 1,
        pageItemCount: 10,
        categoryNo: 0,
        statusNo: 0,
        searchValue: '' 
      },
    products: [],
    categories: [],
    productStatus: [{statusNo: 1, statusName: '진행중'}, {statusNo: 2, statusName: '완료'}],
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
export const GET_PRODUCT = 'products/GET_PRODUCT';
export const SET_CATEGORY = 'products/SET_CATEGORY';
export const SET_SEARCH_VALUE = 'products/SET_CATEGORY';
export const GET_CATEGORIES = 'products/GET_CATEGORIES';
export const SET_PRODUCT_STATUS = 'products/SET_PRODUCT_STATUS';


const actions = createActions({
    [GET_PRODUCTS]: () => {},
    [PAGE_CHANGE]: () => {},
    [GET_PRODUCT]: () => {},
    [SET_CATEGORY]: () => {},
    [SET_SEARCH_VALUE]: () => {},
    [GET_CATEGORIES]: () => {},
    [SET_PRODUCT_STATUS]: () => {},

});

const productFindReducer = handleActions(
    {
        [GET_PRODUCTS]: (state, {payload}) => {
            state.products = payload.products;
            state.pageInfo = payload.pageInfo;

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
        [SET_CATEGORY]: (state, {payload}) => {
            state.pageInfo.categoryNo = payload;

            return {...state};
        },
        [SET_SEARCH_VALUE]: (state, {payload}) => {
            state.pageInfo.searchValue = payload;

            return {...state};
        },
        [SET_PRODUCT_STATUS]: (state, {payload}) => {
            state.pageInfo.statusNo = payload;

            return {...state};
        },
        [GET_CATEGORIES]: (state, {payload}) => {
            state.categories = payload.data;

            return {...state};
        },
    },
    initialState
);

export default productFindReducer;