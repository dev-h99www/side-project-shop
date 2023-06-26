import axios from 'axios';
import { getDateAndTime } from '../util/getTime';
import { getServerAddr } from '../util/getServerAddr';
import { GET_REGIST_PRODUCT, POST_PRODUCT } from '../modules/ProductRegistModule';
import { GET_PRODUCT, GET_PRODUCTS, GET_PRODUCTS_COUNT } from '../modules/ProductFindModule';

export function registProductAPI(name, category, price) {
    const POST_PRODUCT_URL = getServerAddr() + '/products/regist';

    return async function registProduct(dispatch, getState) {
        let registInfo = {
            productName: name, 
            productCategoryNo: category, 
            productStatusNo: 1,
            productDate: getDateAndTime(),
            productPrice: price};

        const result = await axios.post(POST_PRODUCT_URL, registInfo)
                                    .catch(err => console.log(err));

        dispatch({type:POST_PRODUCT, payload: result});
    };
};

export function findRegistProductInfoAPI() {

    const GET_REGIST_PRODUCT_URL = getServerAddr() + '/products/regist';

    return async function findRegistProductInfo(dispatch, getState) {

        const result = await axios.get(GET_REGIST_PRODUCT_URL).catch(err => console.log(err));

        dispatch({type: GET_REGIST_PRODUCT, payload: result});
    }
}

export function findProductCountAPI(productStatusNo) {
    const GET_PRODUCTS_COUNT_URL = getServerAddr() + '/products/counts';

    return async function findProductsCounts(dispatch, getState) {
        
        const result = await axios.get(GET_PRODUCTS_COUNT_URL, {params: { productStatusNo }}).catch(err => console.log(err));

        dispatch({type: GET_PRODUCTS_COUNT, payload: result});
    }
}

export function findProductsAPI(pageInfo) {
    const GET_PRODUCTS_URL = getServerAddr() + '/products';

    return async function findProducts(dispatch, getState) {
        
        const result = await axios.get(GET_PRODUCTS_URL, {params : { 
                                                                    page: pageInfo.page,
                                                                    totalItemCount: pageInfo.totalItemCount,
                                                                    pageItemCount: pageInfo.pageItemCount,
                                                                    type: pageInfo.type,
                                                                    categoryNo: pageInfo.categoryNo,
                                                                    statusNo: pageInfo.statusNo
                                                                    }
                                                            }
                                    ) 
                                    .catch(err => console.log(err));

        dispatch({type: GET_PRODUCTS, payload: result});
    }
}

export function getProductInfoAPI(productNo) {
    const GET_PRODUCT_URL = getServerAddr() + '/products/' + productNo;

    return async function getProductInfo(dispatch, getState) {
            
            const result = await axios.get(GET_PRODUCT_URL).catch(err => console.log(err));

            dispatch({type: GET_PRODUCT, payload: result});
    }
}